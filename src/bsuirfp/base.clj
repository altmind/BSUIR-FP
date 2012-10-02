(ns bsuirfp.base
  (:gen-class ))

(defn remove_tail_head
  [list]
  (butlast (rest list)))

(defn replace_negative_with_zeroes
  [list]
  (map #(if (neg? %1) 0 %1) list))

(defn remove_all_zeroes
  [list]
  (filter #(not (zero? %1)) list))

(defn duplicate_atoms_in_list_2
  [list]
  (if
    (empty? list)
    []
    (cons (first list)
      (cons (first list)
        (duplicate_atoms_in_list_2 (rest list))
        )
      )
    )
  )

(defn duplicate_atoms_in_list
  [list]
  (flatten
    (map (fn [x] [x x]) list)
    )
  )

(defn count_entries
  [what list]
  (reduce
    (fn [col item]
      (+ col
        (if
          (= what item)
          1
          0
          )
        )
      ) 0 list
    )
  )

(defn reverse_list
  [list]
  (reduce
    (fn [col item]
      (concat [item] col)
      )
    []
    list
    )
  )