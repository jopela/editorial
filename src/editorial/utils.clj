(ns editorial.utils
  (:require [clojure.string :as string]))

(defn trim-lowercase
  "apply a trim and lowercase operation on strings but leave the keywords
  alone"
  [item]
  (let [tlc (comp string/lower-case string/trim)]
    (cond
      (= clojure.lang.Keyword (class item)) item
      :else (tlc item))))

(defn trim-lowercase-set
  "take the elements of coll, trim them, apply the lowercase function
  and put them in a set."
  [coll]
  (set (map trim-lowercase coll)))

(defn clean-logical-mapping
  "apply trim-lowercase-set to the elements of a logical section mapping.
  This function is used to make sure that the data structure found in 
  editorial.definitions (which could potentially be manipulated by
  non-developpers) remains valid after manipulation."
  [coll]
  (into {} (for [x coll :let [k (first x)
                              v (-> x second trim-lowercase-set)]] [k v])))

