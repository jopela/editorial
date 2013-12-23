(ns editorial.content
  (:require [clojure.string :as string]
            [wikison.core :as sourcewiki])
  (:import (java.net URL)))

(defn source-dispatch                                                              
    "dispatch function for sources content fetcher"                                  
    [url & args]

    (let [wikimedia #{"wikipedia" "wikivoyage" "wikidata"}                           
          domain (-> url                                                               
                     URL.                                                              
                     (.getHost)                                                        
                     (string/split #"\.")                                              
                     butlast                                                           
                     last)]
      (cond 
        (contains? wikimedia domain) :wikimedia
        :else nil)))

; get the data from the given url source with the right source handler.
(defmulti  source-data source-dispatch)

(defmethod source-data :wikimedia 
  [url user-agent]
  (sourcewiki/article user-agent url))

(defmethod source-data :default
  [url user-agent]
  {:error (str "do not know how to transform " url " into a data structure."
               "if YOU know, add the relevent method to source-data.")})

