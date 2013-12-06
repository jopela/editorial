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

(defn template-article
  [kw articles-data]
  (let [articles (map :article articles-data)]
    {kw articles}))

(def general-information (partial template-article :general-information))


