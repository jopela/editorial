(ns editorial.core
  (:gen-class)
  (:require [clojure.tools.cli :as c]
            [editorial.templates :as templates]
            [editorial.content :as content]
            [clojure.data.json :as json]
            [taoensso.timbre :as timbre]))

(timbre/refer-timbre)

(defn error-report
  "generates a human readable error report of the result of the editorial
  content generation."
  [error-sources]
  (doseq [e error-sources]
    (error (str (e :error) "\n"))))

(defn editorial-content
  "fetch some content from the web and generates some articles based on the
  given template function."
  ([templates user-agent urls]
   (letfn [(error? [x] (contains? x :error))]
    (let [articles-or-errors (map #(content/source-data % user-agent) urls)
          articles-data (filter (complement error?) articles-or-errors)
          errors (filter error? articles-or-errors)
          rendering (apply juxt templates)]
      [errors (apply merge (rendering articles-data))])))

  ([user-agent urls]
   (let [temps [templates/general-information]]
     (editorial-content temps user-agent urls)))

  ([urls]
   (let [temps [templates/general-information]
         def-user-agent "editorial v0.1.1 (jonathan.pelletier1@gmail.com)"]
     (editorial-content temps def-user-agent urls))))

; ~~~~ command line argument parsing options
(def cli-options
  [["-h" "--help" "prints an help message and quit"]
   ["-v" "--version" "print the current version number and quit"]
   ["-u" "--user-agent AGENT" "the user-agent string that will be used for http requests (e.g: my-tool v0.1.1 (my@email.com))"]
   ["-l" "--log-file PATH" "the path to tge log file. Defaults to /var/log/editorial.log" :default "/var/log/editorial.log" ]])

(defn -main
  "Generate editorial content given lists of url."
  [& args]
  
  (let [{:keys [options arguments summary errors]} 
        (c/parse-opts args cli-options)]

    (when (options :help)
      (println summary)
      (System/exit 0))

    (when (options :version)
      (println "v-0.1-alpha")
      (System/exit 0))

    (when-not (options :user-agent)
      (println "you must specify a user-agent string with --user-agent.")
      (System/exit 0))
    
    ; logger configuration
    (timbre/set-config! [:appenders :spit :enabled?] true)
    (timbre/set-config! [:shared-appender-config :spit-filename] 
                        (options :log-file))
    (timbre/set-config! [:appenders :standard-out :enabled?] false)

    (let [[errors content] (editorial-content (options :user-agent) arguments)]
      (do
        (error-report errors)
        (println (json/write-str content))
        (System/exit 0)))))


