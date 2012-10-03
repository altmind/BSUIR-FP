(ns bsuirfp.test.numeric_adv_test
  (:use clojure.test bsuirfp.numeric_adv)
  )


(deftest test_sum_pairs
  (testing "Test sum pairs in list."
    (is (= [3 7 11 15] (sum_pairs [1 2 3 4 5 6 7 8]))
      )
    (is (= [3 7 11 7] (sum_pairs [1 2 3 4 5 6 7]))
      )
    (is (= [3] (sum_pairs [1 2]))
      )
    (is (= [] (sum_pairs []))
      )
    )
  )

(defn prompt-read [prompt]
  (print (format "%s: " prompt))
  (flush)
  (read-line)
  )

(deftest test_shuffle
  (testing "Test shuffle shuffles. May fail if random generates the same seq"
    (is (not= (knuth-shuffle (range 1 100)) (knuth-shuffle (range 1 100)))
      )
    (let [in (seq (.split #"[\s,]" (prompt-read "Input array comma separated"))) out (knuth-shuffle in)]
      (print out)
      (is (not= in out))
      )
    )
  )

(deftest test_deep_sum
  (testing "Test deep sum"
    (is (= 15 (deep_sum [4 [1] [5 3] 2]))
      )
    (is (= 25 (deep_sum [[4 [4 [4]]] [2 [1] [5 3] 2]]))
      )
    (is (= 0 (deep_sum [0 [0 0 [[0] 0]]]))
      )
    (is (= 1 (deep_sum [0 [0 -1 [[0] 2]]]))
      )
    )
  )

