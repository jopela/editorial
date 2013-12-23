(ns editorial.core-test
  (:require [clojure.test :refer :all]
            [editorial.core :refer :all]))


(def url-err ["http://en.wikipedia.org/wiki/Montrealllllll" 
              "http://en.wikipedia.org/wiki/Montreal"])

(deftest editorial-with-err-url
  (testing "when urls list contains bogus url for ed content generation, there
           should be an error fictionary returned by editorial-content in the
           first position of the result vector."
    (let [in url-err
          ou (editorial-content url-err)]
      (is (= (count (first ou)) 1)))))

