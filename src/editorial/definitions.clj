(ns editorial.definitions)

(defn load-definition
  "load definitions from a file"
  [filename]
  (load-string (slurp filename)))

