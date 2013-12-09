(ns editorial.templates)

; TODO: 1) implement general information template.
;       2) replicate template format from file for all categories.
;       3) 

; The different article categories. There should be 1 template for each
; categories.

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
  {"General_Information" [:introduction :understand :do]})

; TODO: load from file? this all seems to be configuration stuff.
(def languages
  #{"en" "it" "fr" "pt" "ar" "nl" "ko" "ru" "pl"})

; this function will use the manual function mapping to get right category
; for the content of a section. Hopefully, this could be replaced with some
; supervised machine learning function in the future.
(defn logical-extract-manual
  "'manually' extract the logical section text from an article-data. So
  given :history it would return something like {:en {:text 'super text' 
  :title 'historia'}" 
  [logical-section tree]
  (let [concrete-section-title (sections-mapping logical-section)]
    (loop [cur 


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
      (let [logical-secs (map #(logical-extract-manual section (:article %)))] 
        (recur (assoc-in section

      {title res})))

