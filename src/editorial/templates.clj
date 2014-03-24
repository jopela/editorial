(ns editorial.templates
  (:require [clojure.string :as string]
            [clojure.zip :as z]
            [editorial.definitions :as definitions]
            [clojure.pprint :as pprint]))


; The different article categories. There should be 1 template for each
; categories.

(defn merge-section
  "function to merge section based on the char count"
  [& args]
  (letfn [(text-count [arg] (-> arg :text count))]
    (apply (partial max-key text-count) args)))

(defn match-logical-title?
  "returns logical true if the title node pointed by loc matches a title
  found in the logical-section-mapping given."
  [loc logical-section-mapping]
  (let [title-text (-> loc z/right z/node string/trim string/lower-case)] 
    (contains? logical-section-mapping title-text)))

(defn section-dic-title
  "extract the logical section dictionary from the current loc when we matched
  by title."
  [loc]
  (let [title (-> loc z/right z/node string/trim string/capitalize)
        text (-> loc z/up z/right z/down z/right z/node)]
    (array-map :title title :text text)))

(defn translate-logical-section
  "Takes a keyword and a language and return the appropriate section
  title for it."
  [logical-section language translation-mapping]
  (if-let [translation (get-in translation-mapping [logical-section language])]
    translation
    (name logical-section)))

(defn section-dic-keyword
  "extract the section dictionary from the current loc when we matched by 
  keyword."
  [language logical-section translation-mapping loc]
  (let [text (-> loc z/right z/node)]
    (array-map :title (-> logical-section (translate-logical-section
                                            language
                                            translation-mapping) 
                          string/capitalize) :text text)))

(defn logical-extract
  "walks the tree looking for the specified logical content and
  returns it if found. nil otherwise"
  [sections-mapping logical-section language translation-mapping tree]
  (if-let [lsm (sections-mapping logical-section)]
    (loop [cur (z/vector-zip tree)]
      (let [node (z/node cur)]
        (cond 
          ; matching by title.
          (and (= node :title) (match-logical-title? 
                                 cur 
                                 lsm)) (section-dic-title cur)
          ; matching by section keyword.
          (and (= (class node) clojure.lang.Keyword) (lsm node)) (section-dic-keyword 
                                                                   language 
                                                                   logical-section 
                                                                   translation-mapping 
                                                                   cur)
          (z/end? cur) nil
          :else (recur (z/next cur)))))
    nil))

(def not-nil? (complement nil?))

(defn template-article-dic
  " map the article-data into a dictionary data structure that fits the current
  mtrip representation of editorial content. title is the title given to the
  template (e.g: General_Information). sections is the ordered list of section
  for this template (e.g [:introduction :understand ...]." 
  [title sections section-mapping translation-mapping articles-data]
  (loop [res (java.util.LinkedHashMap.)
         left sections]
    (if-let [section (first left)]
      (let [logical-secs (for [x articles-data 
                               :let [lang (x :lang) 
                                     sec (logical-extract 
                                           section-mapping
                                           section 
                                           lang
                                           translation-mapping
                                           (x :article))
                                     source (array-map :source (x :url))] 
                               :when (not-nil? sec)] (array-map lang 
                                                      (merge sec source)))]
        (cond
          (= 0 (count logical-secs)) (recur res (rest left))
          :else (recur (do  
                         (.put 
                           res
                           section 
                         (apply 
                           (partial 
                             merge-with 
                             merge-section) 
                           logical-secs))
                        res) 
                       (rest left))))
      (array-map title res))))


(defn load-templates
  "construct the template functions from the template config, mapping 
  config files and translations config file."
  [template-filename mapping-filename translation-filename]
  (let [templates-definition (definitions/load-definition template-filename)
        mapping-definition (definitions/load-definition mapping-filename)
        translation-definition (definitions/load-definition translation-filename)]
    (letfn [(templater [x] (partial template-article-dic
                                    (x :title)
                                    (x :sections)
                                    mapping-definition
                                    translation-definition))]
      (map templater templates-definition))))

