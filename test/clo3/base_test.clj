(ns clo3.base_test
  (:use clojure.test
        clo3.core
        clo3.base
        ))

(deftest test_base_remove_tail_head
  (testing "Removes head and tail of list"
    (is (= [2 3 4] (remove_tail_head [1 2 3 4 5]))
      )
    (is (= nil (remove_tail_head []))
      )
    (is (= nil (remove_tail_head [1]))
      )
    (is (= nil (remove_tail_head [1 2]))
      )
    (is (= [1 1 1] (remove_tail_head [1 1 1 1 1]))
      )
    )
  )


(deftest test_base_remove_tail_head
  (testing "Replace negative numbers with zeroes"
    (is (= [0] (replace_negative_with_zeroes [-1]))
      )
    (is (= [0 1 2 0 0] (replace_negative_with_zeroes [-1 1 2 -1 -3.14]))
      )
    (is (= [] (replace_negative_with_zeroes []))
      )
    )
  )

(deftest test_base_remove_all_zeroes
  (testing "Remove zeroes from list"
    (is (= [] (remove_all_zeroes [0 0]))
      )
    (is (= [-1 1 2] (remove_all_zeroes [0 -1 0 1 2 0]))
      )
    (is (= [] (remove_all_zeroes []))
      )
    )
  )

(deftest test_base_duplicate_atoms_in_list
  (testing "Duplicate each atom in list"
    (is (= [] (duplicate_atoms_in_list []))
      )
    (is (= [1 1] (duplicate_atoms_in_list [1]))
      )
    (is (= [1 1 2 2 3 3] (duplicate_atoms_in_list [1 2 3]))
      )
    )
  )

(deftest test_base_duplicate_atoms_in_list_2
  (testing "Duplicate each atom in list"
    (is (= [] (duplicate_atoms_in_list_2 []))
      )
    (is (= [1 1] (duplicate_atoms_in_list_2 [1]))
      )
    (is (= [1 1 2 2 3 3] (duplicate_atoms_in_list_2 [1 2 3]))
      )
    )
  )

(deftest test_count_entries
  (testing "Count entry of atom in list"
    (is (= 0 (count_entries 2 []))
      )
    (is (= 0 (count_entries 2 [3]))
      )
    (is (= 1 (count_entries 2 [2]))
      )
    (is (= 1 (count_entries 2 [0 1 2 3]))
      )
    (is (= 3 (count_entries 2 [2 2 -1 3 2 1]))
      )
    )
  )

(deftest test_reverse_list
  (testing "reverses list"
    (is (= [] (reverse_list []))
      )
    (is (= [1 2 3] (reverse_list [3 2 1]))
      )
    (is (= [1] (reverse_list [1]))
      )
    (is (= [1 1 1 1 1] (reverse_list [1 1 1 1 1]))
      )
    )
  )