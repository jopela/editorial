(ns editorial.utils
  (:require [clojure.string :as string]))

(defn trim-lowercase-set
  "take the elements of coll, trim them, apply the lowercase function
  and put them in a set."
  [coll]
  (let [trim-lowercase (comp string/lower-case string/trim)]
    (set (map trim-lowercase coll))))

(defn clean-logical-mapping
  "apply trim-lowercase-set to the elements of a logical section mapping.
  This function is used to make sure that the data structure found in 
  editorial.definitions (which could potentially be manipulated by
  non-developpers) remains valid after manipulation."
  [coll]
  (into {} (for [x coll :let [k (first x)
                              v (-> x second trim-lowercase-set)]] [k v])))

