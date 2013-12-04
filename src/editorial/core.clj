(ns editorial.core
  (:gen-class)
  (:require [clojure.tools.cli :as c]))

(defn -main
  "Generate editorial content given lists of url."
  [& args]
  (let [[opts args banner] 
        (c/cli args
          ["-h" "--help" "print this help banner and quit" :flag true]
          ["-v" "--version" "print version info" :flag true])]
    (when (opts :help)
      (println banner)
      (System/exit 0))

    (when (opts :version)
      (println "v-0.1-alpha")
      (System/exit 0))

    (doseq [elem args]
      (println elem))))


