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

