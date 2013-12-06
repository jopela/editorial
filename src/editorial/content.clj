(ns editorial.content
  (:require [clojure.string :as string])
  (:import (java.net URL)))

(defn source-dispatch                                                              
    "dispatch function for sources content fetcher"                                  
    [url]                                                                            
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

