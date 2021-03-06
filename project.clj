(defproject editorial "0.1.1"
  :description "Generates editorial content from a given url list"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.3.0"]
                 [org.clojure/data.json "0.2.3"]
                 [wikison "0.1.1"]
                 [com.taoensso/timbre "3.0.0-RC2"]]
  :main ^:skip-aot editorial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
