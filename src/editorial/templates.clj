(ns editorial.templates)

; The different article categories. There should be 1 template for each
; categories.

(def categories
  {:drinking          "Drinking & Nightlife"
   :attraction        "Attraction"
   :transport         "Transport"
   :hotel             "Hotel"
   :practical         "Practical Information"
   :restaurant        "Restaurant"
   :general           "General Information"
   :shopping          "Shopping"})

(def logical-cat 
  {#{"History" "Historia" "Histoire"} :history})

(defn all-languages
  [& args]
  true)

(defn text-section
  "text-section takes a list of source and returns a sub datastructure 
  representing a section with text. Made to extract article sections from
  article-like sources."
  ([logical-category languages sources]
   nil)

  ([logical-category sources]
   (text-section logical-category all-languages sources)))

(defn template
  "template function that render it's sources argument into data structure"
  [categorie sections sources])

(defn general-information
  "create the general information template from a collection of sources"
  [sources]
  {:general_information "gen-info"})

(defn 
  "create the general information template from a collection of sources"
  [sources]
  {:general_information "gen-info"})


