(ns bsuirfp.numeric_adv
  (:gen-class ))

(defn sum_pairs [list] (map #(apply + %1) (partition-all 2 list)))

(defn ^:private swap-elts [x i j]
  (assoc x i (x j) j (x i)))

(defn ^:private rand-range
  ([n] (rand-int n))
  ([m n] (+ m (rand-int (- n m)))))

(defn knuth-shuffle [xs]
  (let [v (vec xs)]
    (reduce
      #(swap-elts %1 %2 (rand-range %2 (count %1)))
      v
      (range (count v))
      )
    )
  )