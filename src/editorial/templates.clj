(ns editorial.templates
  (:require [clojure.string :as string]
            [clojure.zip :as z]))

; The different article categories. There should be 1 template for each
; categories.
;
; TODO: implement a partial evaluator in wikison?

(def categories
  {:drinking          "Drinking & Nightlife"
   :attraction        "Attraction"
   :transport         "Transport"
   :hotel             "Hotel"
   :practical         "Practical Information"
   :restaurant        "Restaurant"
   :ugeneral           "General Information"
   :shopping          "Shopping"})

; TODO: load this from file
(def sections-mapping
  {:introduction #{"introduction"}
   :understand #{"understand" "comprendre"}
   :history #{"history" "histoire" "historia"}
   :do #{"do" "a faire"}})

; TODO: load this from file
; order of the logical section.
(def template-def
  [
   {
    :title "General_Information"
    :sections [:introduction :understand :do]
   }
   {
    :title "Shopping"
    :sections [:buy]
   }
   {
    :title "Drinking_&_Nightlife"
    :sections [:drink]
   }
   {
    :title "Restaurants"
    :sections [:eat]
   }
   {
    :title "Practical_Information"
    :sections [:public-transport 
               :tourist-information
               :orientation
               :get-in
               :talk 
               :transportation
               :with-children
               ]
   }
])

; TODO: load from file? this all seems to be configuration stuff.
(def languages
  #{"en" "it" "fr" "pt" "ar" "nl" "ko" "ru" "pl"})

(defn merge-section
  "function to merge section"
  [& args]
  (letfn [(text-count[arg] (-> arg :text count))]
    (apply (partial max-key text-count) args)))
  
(defn logical-extract
  "'manually' extract the logical section text from an article-data. So
  given :history it would return something like {:en {:text 'super text' 
  :title 'historia'}. Return the first section found." 
  [logical-section tree]
  (let [logical-section-mapping (sections-mapping logical-section)]
    (loop [cur (z/vector-zip tree)]
      (let [node (z/node cur)]
        (cond (and 
                (= node :title) 
                (-> cur 
                    z/right
                    z/node
                    string/trim
                    string/lower-case
                    logical-section-mapping)) {:title (-> cur
                                                          z/right
                                                          z/node)
                                               :text (-> cur 
                                                         z/up
                                                         z/right
                                                         z/down
                                                         z/right
                                                         z/node)}
              (z/end? cur) nil
              :else (recur (z/next cur)))))))

(def not-nil? (complement nil?))
        
(defn template-article-dic
  "map the article-data into a dictionary data structure that fits the current
  mtrip representation of editorial content. title is the title given to the
  template (e.g: General_Information). sections is the ordered list of section
  for this template (e.g [:introduction :understand ...]. supported-langs is
  the set of languages for which content will be generated and articles-data
  is the raw content fetched from the sources."
  [title sections supported-langs articles-data]
  (loop [res {} 
         left sections]
    (if-let [section (first left)]
      (let [logical-secs (for [x articles-data 
                               :let [lang (x :lang) 
                                     sec (logical-extract 
                                           section 
                                           (x :article))] 
                               :when (not-nil? sec)] {lang sec})]
        (cond
          (= 0 (count logical-secs)) (recur res (rest left))
          :else (recur (assoc res
                       section (apply (partial merge-with merge-section) 
                                      logical-secs)) (rest left))))
      {title res})))

(def test-template (partial template-article-dic 
                            "General_Information"
                            [:understand :history :do]
                            ["en" "fr" "pt"]))


(defn general-information
  "the general information editorial content template."
  [args]
  {:nothing :yest})

