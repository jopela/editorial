(ns editorial.core
  (:gen-class)
  (:require [clojure.tools.cli :as c]
            [editorial.templates :as templates]
            [editorial.content :as content]))

; This is admitedly 'complex' code in the sence that it is not simple (it's
; compounded with lot's of stuff). For example, representation is chosen
; inside the template function (data is directly casted in a tree-like 
; dictionary data structure) so templates are completely format dependant.
; Sadly, this is the only solution I could come up with in the allocated time 
; frame. Hope this complexity will not bite me later on ...

(defn editorial-content
  "fetch some content from the web and generates some articles based on the
  given template function."
  ([templates urls]
    (let [articles-data (->> urls
                             (map content/source-data)
                             (filter (complement (fn [x] (contains? x :error )))))

          rendering (apply juxt templates)]

      (apply merge (rendering articles-data))))

  ([urls]
   (let [temps [templates/general-information]]
     (editorial-content temps urls))))

(defn -main
  "Generate editorial content given lists of url."
  [& args]
  (let [[opts arguments banner] 
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

    (println (editorial-content args))))


