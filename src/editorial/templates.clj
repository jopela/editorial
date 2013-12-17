(ns editorial.templates
  (:require [clojure.string :as string]
            [clojure.zip :as z]
            [editorial.definitions :as dfns]
            [editorial.utils :as utils]))

; The different article categories. There should be 1 template for each
; categories.

(def default-section-mapping (utils/clean-logical-mapping 
                               dfns/logical-section-map))

(defn merge-section
  "function to merge section"
  [& args]
  (letfn [(text-count[arg] (-> arg :text count))]
    (apply (partial max-key text-count) args)))

(defn match-logical?
  "returns logical true if the title node pointed by loc matches a title
  found in the logical-section-mapping given."
  [loc logical-section-mapping]
  (let [title-text (-> loc z/right z/node string/trim string/lower-case)] 
    (contains? logical-section-mapping title-text)))

(defn section-dic
  "extract the logical section dictionary from the current loc"
  [loc]
  (let [title (-> loc z/right z/node)
        text (-> loc z/up z/right z/down z/right z/node)]
    {:title title :text text}))
  
(defn logical-extract
  "walks the tree looking for the specified logical content and
  returns it if found. nil otherwise"
  [sections-mapping logical-section tree]
  (let [lsm (sections-mapping logical-section)]
    (loop [cur (z/vector-zip tree)]
      (let [node (z/node cur)]
        (cond 
          (and (= node :title) (match-logical? cur lsm)) (section-dic cur)
          (z/end? cur) nil
          :else (recur (z/next cur)))))))

(def not-nil? (complement nil?))

(defn template-article-dic
  "map the article-data into a dictionary data structure that fits the current
  mtrip representation of editorial content. title is the title given to the
  template (e.g: General_Information). sections is the ordered list of section
  for this template (e.g [:introduction :understand ...]." 
  [title sections articles-data]
  (loop [res {} 
         left sections]
    (if-let [section (first left)]
      (let [logical-secs (for [x articles-data 
                               :let [lang (x :lang) 
                                     sec (logical-extract 
                                           default-section-mapping
                                           section 
                                           (x :article))] 
                               :when (not-nil? sec)] {lang sec})]
        (cond
          (= 0 (count logical-secs)) (recur res (rest left))
          :else (recur (assoc res
                       section (apply (partial merge-with merge-section) 
                                      logical-secs)) (rest left))))
      {title res})))

; used for testing only
(def test-template (partial template-article-dic 
                            "General_Information"
                            [:understand :history :do :doubitchou]))

; mtrip general information template.
(def general-information 
  (partial template-article-dic 
           "General_Information" [:understand :history :do :climate :arts
                                  :culture :food]))


