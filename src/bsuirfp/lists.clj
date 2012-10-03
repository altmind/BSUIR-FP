(ns bsuirfp.lists
  (:gen-class )
  (:use clojure.set))

(defn
  sort_by_number [x]
  (sort-by #(nth %1 1) x)
  )

(defn
  sort_by_number_map [keyname x]
  (sort-by #(keyname %1) x)
  )

(defn signum [number]
  (cond
    (neg? number) -1
    (zero? number) 0
    :else 1
    )
  )

(defn
  reverse_number
  ([number] (* (signum number) (reverse_number 0 (Math/abs number))))
  ([header number]
    (if (zero? number) header
      (let [headnum (mod number 10) restnum (int (/ number 10))]
        (reverse_number (+ headnum (* 10 header)) restnum)
        )
      )
    )
  )
(defn reverse_numbers_list [list] (map reverse_number list)
  )