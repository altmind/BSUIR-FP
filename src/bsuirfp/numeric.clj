(ns bsuirfp.numeric
  (:gen-class )
  (:use clojure.set))

(defn get_first_digit
  [item]
  (if
    (< item 10)
    (int item)
    (get_first_digit
      (/ item 10)
      )
    )
  )

(defn get_divisors
  [divisor]
  (filter
    (fn
      [item]
      (zero?
        (mod divisor item)
        )
      )
    (range 1 (+ divisor 1))
    )
  )

(defn get_common_divisors
  [divisors]
  (apply intersection
    (map
      #(set (get_divisors %1)
         ) divisors
      )
    )
  )

(defn get_gcd
  [a b]
  (if
    (zero? b)
    (Math/abs a)
    (get_gcd b (mod a b))
    )
  )
; as defined at http://code.activestate.com/recipes/577282-finding-the-gcd-of-a-list-of-numbers-aka-reducing-/#c1
(defn get_gcd_list
  [items]
  (reduce get_gcd items)
  )

(defn ^:private is_divisible [n divisor] (zero? (mod n divisor)))

(defn is_prime [n]
  (case n
    1 false
    2 true
    (every? false?
      (map
        (partial is_divisible n)
        (range
          2
          (inc (Math/sqrt n))
          )
        )
      )
    )
  )

(defn get_primes_from_to [a b]
  (filter
    is_prime
    (range a (inc b))
    )
  )

(defn calc_progression [& {:keys [n a0 d]}]

  (if (zero? n)
    0
    (+ a0
      (calc_progression
        :n (dec n)
        :a0 (+ a0 d)
        :d d)
      )
    )

  )
; taken from https://github.com/richhickey/clojure-contrib/blob/95dddbbdd748b0cc6d9c8486b8388836e6418848/src/main/clojure/clojure/contrib/seq.clj#L51
(defn ^:private indexed
  "Returns a lazy sequence of [index, item] pairs, where items come
  from 's' and indexes count up from zero.

  (indexed '(a b c d))  =>  ([0 a] [1 b] [2 c] [3 d])"
  [s]
  (map vector (iterate inc 0) s))

(defn ^:private bisect_positive_and_index [list]
  (reduce
    (fn [col x]
      (if
        (pos? (second x))
        {
          :indexes (conj (:indexes col) (first x))
          :elements (conj (:elements col) (second x))
          }
        col
        )
      )
    {:indexes [] :elements []}
    (indexed list)
    )
  )

(defn sort_positive [list]
  (let [obj (bisect_positive_and_index list) sorted_values (sort (:elements obj))]
    (println obj)
    (reduce
      (fn [col x]
        (assoc col (second x) (nth sorted_values (first x)))
        )
      list
      (indexed (:indexes obj))
      )
    )
  )
