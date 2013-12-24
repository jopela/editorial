(ns editorial.utils-test
  (:require [clojure.test :refer :all]
            [editorial.utils :refer :all]))

(deftest trim-lowercase-1
  (testing "strings should be trimmed and lowercased"
    (let [in " Trim "
          ex "trim"
          ou (trim-lowercase in)]
      (is (= ex ou)))))

(deftest trim-lowercase-2
  (testing "keywords should be left untouched"
    (let [in :keyword
          ex :keyword
          ou (trim-lowercase in)]
      (is (= ex ou)))))

(def trim-lowercase-set-1-in
  #{"History" "historia" " Historia"})

(def trim-lowercase-set-1-ex
  #{"history" "historia"})

(deftest trim-lowercase-set-1
  (testing "elements in the set shoudl be trimmed and to lowercase"
    (let [in trim-lowercase-set-1-in
          ex trim-lowercase-set-1-ex
          ou (trim-lowercase-set in)]
      (is (= ex ou)))))

(def trim-lowercase-set-2-in
  #{" History" :keyword})

(def trim-lowercase-set-2-ex
  #{"history" :keyword})

(deftest trim-lowercase-set-2
  (testing "Elements in the set should be trimmed and lowercased and keywords
    should be untouched."
    (let [in trim-lowercase-set-2-in
          ex trim-lowercase-set-2-ex
          ou (trim-lowercase-set in)]
      (is (= ex ou)))))

(def clm-1-in
  {:history  #{" History" "Histoire"}
   :understand #{"Comprendre" " understand "}})

(def clm-1-ex
  {:history #{"history" "histoire"}
   :understand #{"comprendre" "understand"}})

(deftest clean-logical-mapping-test
  (testing "should return a cleaned up version!"
    (let [in clm-1-in
          ex clm-1-ex
          ou (clean-logical-mapping in)]
      (is (= ex ou)))))
