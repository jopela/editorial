(ns editorial.template-test
  (:require [clojure.test :refer :all]
            [editorial.templates :refer :all]
            [editorial.definitions :as definitions]
            [clojure.zip :as z]))

(def mapping-conf "/etc/editorial.d/mappings.conf")
(def default-section-mapping (definitions/load-definition mapping-conf))

(def test-template (partial template-article-dic
                            "General_Information"
                            [
                             :history
                             :do 
                             :understand
                             :architecture 
                             :arts
                             :respect
                             ]
                            default-section-mapping))

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

(def sdk-1-in
  (-> [:abstract "text"]
      z/vector-zip
      z/down))

(def sdk-1-ex
  {:title "introduction" :text "text"})

(deftest section-dic-keyword-1
  (testing "should cast the element of a section into a dic when matched with
           keyword"
    (let [in sdk-1-in
          ex sdk-1-ex
          ou (section-dic-keyword :introduction in)]
      (is (= ex ou)))))

(deftest section-dic-test-1
  (testing "should be able to cast the element of a section into a dictionnaty
           that has a title and a text elem."
    (let [in sdt-1-in
          ex sdt-1-ex 
          ou (section-dic-title in)]
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
    (is (= true (match-logical-title? match-logical?-test-1-in-loc
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

(def logical-extract-tree-3
  [:article
   [:abstract "text"]
   [:sections
    [:section
     [:title "history"]
     [:text "the text"]]]])

(deftest logical-extract-test-3
  (testing "the abstract section should be considered the introduction and
           it should be extracted if it is found in the section mapping."
    (let [in logical-extract-tree-3
          ex {:title "introduction" :text "text"}
          ou (logical-extract default-section-mapping :introduction in)]
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
                 [:text "do"]]]]
    :url "http://theshortone.com"}
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
                 [:text "do"]]]]
    :url "http://thelongone.com"}])

(deftest template-article-dic-test-1
  (testing "when 2 section could make it into the final content, must pick
           the longest one"
    (let [in articles-data
          ex {"General_Information" {:understand {"en" {:title " Understand "
                                                        :text "understand++"
                                                        :source "http://thelongone.com"}}
                                     :history {"en" {:title " History "
                                                     :text "history"
                                                     :source "http://theshortone.com"}}
                                     :do {"en" {:title " Do "
                                                :text "do"
                                                :source "http://theshortone.com"}}}}
          ou (test-template in)]
      (is (= ex ou)))))

;3 different sources, 2 different languages , each containing an introduction
; and 2 containing a conflicting history section.
(def articles-data-1-in
  [{:lang "en"
     :article [:article 
               [:abstract "Long introduction (longest of en)"]
               [:sections
                [:section
                 [:title " Understand "]
                 [:text "long understand"]]
                [:section
                 [:title " History "]
                 [:text "long history"]]
                [:section
                 [:title " Do "]
                 [:text " long do "]]]]
    :url "http://long.com"}

   {:lang "en"
    :article [:article 
               [:abstract "short introduction"]
               [:sections
                [:section
                 [:title " Understand "]
                 [:text "understand"]]
                [:section
                 [:title " Voyager "]
                 [:text "voyager"]]
                [:section
                 [:title " Cossin "]
                 [:text "cossin"]]]]
    :url "http://short.com"}

   {:lang "fr"
    :article [:article 
               [:abstract "texte introductif"]
               [:sections
                [:section
                 [:title " Comprendre "]
                 [:text "des choses"]]
                [:section
                 [:title " Voyager "]
                 [:text "voyage voyage"]]
                [:section
                 [:title " Cossin "]
                 [:text "do"]]]]
    :url "http://french.com"}])

(def articles-data-1-ex
  {"General_Information" {:introduction {"en" {:title "introduction"
                                               :text "Long introduction (longest of en)"
                                               :source "http://long.com"}
                                         "fr" {:title "introduction" 
                                               :text "texte introductif"
                                               :source "http://french.com"}}
                          :understand   {"en" {:title " Understand "
                                               :text "long understand"
                                               :source "http://long.com"}
                                         "fr" {:title " Comprendre "
                                               :text "des choses"
                                               :source "http://french.com"}}
                          :history      {"en" {:title " History "
                                               :text "long history"
                                               :source "http://long.com"}}
                          :do           {"en" {:title " Do "
                                               :text " long do "
                                               :source "http://long.com"}}}})


(deftest template-article-dic-test-2
  (testing "all content from different article sources should be merged
           into a single editorial content result"
    (let [in articles-data-1-in
          ex articles-data-1-ex
          ou (test-template in)]
      (is (= ex ou)))))

