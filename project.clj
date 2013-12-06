(defproject editorial "0.1.1"
  :description "Generates editorial content from a given url list"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.4"]
                 [org.clojure/core.match "0.2.0"]
                 [instaparse "1.2.11"]
                 [wikison "0.1.1"]
                 [hiccup "1.0.4"]
                 [clj-http "0.7.7"]
                 [org.clojure/data.json "0.2.3"]
                 [intervox/clj-progress "0.1.1"]]
  :main ^:skip-aot editorial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
