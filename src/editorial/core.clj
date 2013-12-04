(ns editorial.core
  (:gen-class)
  (:require [clojure.tools.cli :as c]
            [editorial.templates :as templates]))

(defn editorial
  "generate editorial content for the given urls"
  ([templates urls]
   nil)

  ([urls]
   (let [templates []


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

    (println "hello world")))

