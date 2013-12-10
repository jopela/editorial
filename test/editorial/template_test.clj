(ns editorial.template-test
  (:require [clojure.test :refer :all]
            [editorial.templates :refer :all]))

(def logical-extract-tree-1
  [:article 
   [:abstract "introduction text"]
   [:sections 
    [:section
     [:title "history"]
     [:text "the history of *thing* is fascinating"]]
    [:section
     [:title "understand"]
     [:text "you need to understand this"]]]])

(def logical-extract-tree-2
  [:article
   [:abstract "intro"]
   [:sections
    [:section
     [:title " Comprendre "]
     [:text "vous devez comprendre"]]]])
      
(deftest logical-extract-test-1
  (testing "should extract the history section when it is present"
    (let [in logical-extract-tree-1
          ex {:title "history" :text "the history of *thing* is fascinating"}
          ou (logical-extract :history in)]
      (is (= ex ou)))))

(deftest logical-extract-test-2
  (testing "should extract the understand section when it is present"
    (let [in logical-extract-tree-2
          ex {:title " Comprendre " :text "vous devez comprendre"}
          ou (logical-extract :understand in)]
      (is (= ex ou)))))


(def articles-data 
  [ {:lang "en"
     :article [:article 
               [:abstract "text"]
               [:

