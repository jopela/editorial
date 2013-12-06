(ns editorial.core
  (:gen-class)
  (:require [clojure.tools.cli :as c]
            [editorial.templates :as templates]
            [editorial.content :as content]))

(defn editorial-content
  "fetch some content from the web and generates some articles based on the
  given template function."
  [templates urls]
  (let [user-agent "mtrip content generator (pelletier@mtrip.com)"
        sources-data "lol" ]
    {:articles 
     {:general-information "bla bla bla"}}))

(defn -main
  "Generate editorial content given lists of url."
  [& args]
  (let [[opts args banner] 
        (c/cli args
          ["-h" "--help" "print this help banner and quit" :flag true]
          ["-v" "--version" "print version info" :flag true]
          ["-u" "--user-agent" "user agent string needed by some sources"])]

    (when (opts :help)
      (println banner)
      (System/exit 0))

    (when (opts :version)
      (println "v-0.1-alpha")
      (System/exit 0))

    (println (editorial-content "hello world" "from me"))))

