(ns editorial.template-test
  (:require [clojure.test :refer :all]
            [editorial.templates :refer :all]
            [clojure.zip :as z]))
(def sdt-1-in
  (->[:section
      [:title "history"]
      [:text "hist of"]]
    z/vector-zip
    z/down
    z/right
    z/down))

(def sdt-1-ex
  {:title "history" :text "hist of"})

(deftest section-dic-test-1
  (testing "should be able to cast the element of a section into a dictionnaty
           that has a title and a text elem."
    (let [in sdt-1-in
          ex sdt-1-ex 
          ou (section-dic in)]
      (is (= ex ou)))))
           
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

(def match-logical?-test-1-in-loc
  (-> [:title " History "]
      z/vector-zip
      z/down))

(def match-logical?-test-1-in-section
  #{"history" "do"})

(deftest match-logical?-test-1
  (testing "when trimmed lowercase section title match one of the elements
           of the set, should return true"
    (is (= true (match-logical? match-logical?-test-1-in-loc
                                match-logical?-test-1-in-section)))))

(deftest logical-extract-test-1
  (testing "should extract the history section when it is present"
    (let [in logical-extract-tree-1
          ex {:title "history" :text "the history of *thing* is fascinating"}
          ou (logical-extract default-section-mapping :history in)]
      (is (= ex ou)))))

(deftest logical-extract-test-2
  (testing "should extract the understand section when it is present"
    (let [in logical-extract-tree-2
          ex {:title " Comprendre " :text "vous devez comprendre"}
          ou (logical-extract default-section-mapping :understand in)]
      (is (= ex ou)))))

(deftest merge-section-test-1
  (testing "longest section should make it back"
    (let  [ex {:title "s1" :text "text++"}
           ou (merge-section {:title "s1" :text "text"} 
                            {:title "s1" :text "text++"})]
      (is (= ex ou)))))

(def articles-data 
  [{:lang "en"
     :article [:article 
               [:abstract "text"]
               [:sections
                [:section
                 [:title " Understand "]
                 [:text "understand"]]
                [:section
                 [:title " History "]
                 [:text "history"]]
                [:section
                 [:title " Do "]
                 [:text "do"]]]]}
   {:lang "en"
    :article [:article 
               [:abstract "text"]
               [:sections
                [:section
                 [:title " Understand "]
                 [:text "understand++"]]
                [:section
                 [:title " Voyager "]
                 [:text "voyager"]]
                [:section
                 [:title " Cossin "]
                 [:text "do"]]]]}])

(deftest template-article-dic-test-1
  (testing "when 2 section could make it into the final content, must pick
           the longest one"
    (let [in articles-data
          ex {"General_Information" {:understand {"en" {:title " Understand "
                                                        :text "understand++"}}
                                     :history {"en" {:title " History "
                                                     :text "history"}}
                                     :do {"en" {:title " Do "
                                                :text "do"}}}}
          ou (test-template articles-data)]
      (is (= ex ou)))))

