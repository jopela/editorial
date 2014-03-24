(ns editorial.core-test
  (:require [clojure.test :refer :all]
            [editorial.core :refer :all]
            [editorial.templates :as templates]))


(def url-err ["http://en.wikipedia.org/wiki/Montrealllllll" 
              "http://en.wikipedia.org/wiki/Montreal"])

(def template-conf "/etc/editorial.d/templates.conf")
(def mapping-conf "/etc/editorial.d/mappings.conf")
(def translate-conf "/etc/editorial.d/translations.conf")
(def user-agent "editorial v0.1.1 jopela (pelletier@mtrip.com)")

(def test-templates (templates/load-templates 
                      template-conf 
                      mapping-conf 
                      translate-conf))

(deftest editorial-with-err-url
  (testing "when urls list contains bogus url for ed content generation, there
           should be an error fictionary returned by editorial-content in the
           first position of the result vector."
    (let [in url-err
          ou (editorial-content test-templates user-agent url-err)]
      (is (= (count (first ou)) 1)))))

