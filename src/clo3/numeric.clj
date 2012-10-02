(ns clo3.numeric
  (:gen-class ) (:use clojure.set))

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