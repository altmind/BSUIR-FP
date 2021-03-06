(ns bsuirfp.test.numeric_test
  (:use clojure.test bsuirfp.numeric)
  )

(deftest test_numeric_get_first_digit
  (testing "Get first digit"
    (is (= 3 (get_first_digit 3761))
      )
    (is (= 0 (get_first_digit 0))
      )
    (is (= 3 (get_first_digit 3))
      )
    (is (= 3 (get_first_digit 37611231212121212))
      )
    )
  )

(defn test_helper_divisors_normalize
  "Sorts results of divisors call"
  [list]
  list
  )
(defn test_helper_get_common_divisors
  "Sorts results of set, convert to list"
  [list]
  (sort (vec list))
  )

(deftest test_numeric_get_first_digit
  (testing "Get first digit"
    (is (= 3 (get_first_digit 3761))
      )
    (is (= 0 (get_first_digit 0))
      )
    (is (= 3 (get_first_digit 3))
      )
    (is (= 3 (get_first_digit 37611231212121212))
      )
    )
  )

(deftest test_divisors
  (testing "Get divisors of int"
    (is (= [1, 3761] (test_helper_divisors_normalize (get_divisors 3761)))
      )
    (is (= [1, 2, 4, 8, 16, 32] (test_helper_divisors_normalize (get_divisors 32)))
      )
    (is (= [1] (test_helper_divisors_normalize (get_divisors 1)))
      )
    (is (= [1, 2] (test_helper_divisors_normalize (get_divisors 2)))
      )
    )
  )

(deftest test_gcd_list
  (testing "Get GCD of list"
    (is (= 4 (test_helper_divisors_normalize (get_gcd_list [4 32])))
      )
    (is (= 1 (test_helper_divisors_normalize (get_gcd_list [17 35])))
      )
    (is (= 32 (test_helper_divisors_normalize (get_gcd_list [32 256])))
      )
    (is (= 7 (test_helper_divisors_normalize (get_gcd_list [14 35])))
      )
    (is (= 7 (test_helper_divisors_normalize (get_gcd_list [14 35 42])))
      )
    (is (= 1 (test_helper_divisors_normalize (get_gcd_list [32 256 17])))
      )
    (is (= 4 (test_helper_divisors_normalize (get_gcd_list [32 48 12])))
      )
    )
  )

(deftest test_get_common_divisors
  (testing "Get common divisors"
    (is (= [1] (test_helper_get_common_divisors (get_common_divisors [3761 3762])))
      )
    (is (= [1, 2, 4, 8, 16, 32] (test_helper_get_common_divisors (get_common_divisors [32 64])))
      )
    (is (= [1, 2, 4] (test_helper_get_common_divisors (get_common_divisors [32, 64, 12])))
      )
    )
  )

(deftest test_is_prime
  (testing "Check if number is prime"
    (is (= true (is_prime 17))
      )
    (is (= false (is_prime 18))
      )
    (is (= false (is_prime 121))
      )
    (is (= false (is_prime 9))
      )
    (is (= true (is_prime 3))
      )
    (is (= true (is_prime 47))
      )
    )
  )

(deftest test_get_primes_from_to
  (testing "Get primes from M to N"
    (is (= [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37] (get_primes_from_to 2 40))
      )
    )
  )

;Посчитать сумму арифметической прогрессии с параметрами a0, d, n (a(i)=a(i-1)+d) без использования формулы суммы арифметической прогрессии.
(deftest test_calc_progression
  (testing "Calculate progression"
    (is (= 18 (calc_progression :n 3 :a0 2 :d 4))
      )
    )
  )

;(-4 3 4 -1 0 6 2) -> (-4 2 3 -1 0 4 6)
(deftest test_sort_positive
  (testing "Test sort positive numbers"
    (is (= [-4 2 3 -1 0 4 6] (sort_positive [-4 3 4 -1 0 6 2]))
      )
    (is (= [1 2 3 4] (sort_positive [4 3 2 1]))
      )
    (is (= [0 1 0 2 0 3 0 0 4] (sort_positive [0 4 0 3 0 2 0 0 1]))
      )
    (is (= [-1 -1 -1] (sort_positive [-1 -1 -1]))
      )
    (is (= [] (sort_positive []))
      )
    )
  )
