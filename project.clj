(defproject editorial "0.1.0-alpha"
  :description "Generates editorial content from a given url list"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.4"]]
  :main ^:skip-aot editorial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
