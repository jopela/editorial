(ns editorial.template-test
  (:require [clojure.test :refer :all]
            [editorial.templates :refer :all]))

(def logical-extract-tree
  [:article 
   [:abstract "introduction text"]
   [:sections 
    [:section
     [:title "history"]
     [:text "the history of *thing* is fascinating"]]
    [:section
     [:title "understand"]
     [:text "you need to understand this"]]]])
      
(deftest logical-extract-test-1
  (testing "should extract the history section when it is present"
    (let [in logical-extract-tree
          ex {:title "history" :text "the history of *thing* is fascinating"}
          ou (logical-extract :history in)]
      (is (= ex ou)))))
