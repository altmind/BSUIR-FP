(ns bsuirfp.test.lists_test
  (:use clojure.test bsuirfp.lists)
  )

(deftest test_sort_by_number
  (testing "Sorts by number"
    (is (= [["b" "375271"] ["a" "375272"] ["c" "375273"]] (sort_by_number [["a" "375272"] ["b" "375271"] ["c" "375273"]]))
      )
    (is (= [["b" "375271"] ["a" "375272"] ["d" "375273"] ["c" "375274"]] (sort_by_number [["a" "375272"] ["b" "375271"] ["c" "375274"] ["d" "375273"]]))
      )
    (is (= [] (sort_by_number []))
      )
    (is (= [["a" "375272"]] (sort_by_number [["a" "375272"]]))
      )
    )
  )

(deftest test_sort_by_number_mappy
  (testing "Sorts by number with map interface"
    (is (= ["c" "b" "a"] (map :name (sort_by_number_map :phone [{:name "a" :phone "375272"} {:name "b" :phone "375271"} {:name "c" :phone "375270"}])))
      )
    (is (= [] (map :name (sort_by_number_map :phone [])))
      )

    (is (= ["a"] (map :name (sort_by_number_map :phone [{:name "a" :phone "375272"}])))
      )
    )
  )

(deftest test_reverse_number
  (testing "Test number reversal. Defined in lists, thou is not really list-related."
    (is (= 5671 (reverse_number 1765))
      )
    (is (= 56713 (reverse_number 31765))
      )
    (is (= 0 (reverse_number 0))
      )
    (is (= 3 (reverse_number 3))
      )
    (is (= -5671 (reverse_number -1765))
      )
    )
  )

(deftest test_reverse_numbers_in_list
  (testing "Test reversal each number in list."
    (is (= [5671 0 -3 -123 561 1] (reverse_numbers_list [1765 0 -3 -321 165 1]))
      )
    )
  )

