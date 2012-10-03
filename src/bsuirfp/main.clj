(ns bsuirfp.main
  (:gen-class)
  (:use clojure.test bsuirfp.numeric bsuirfp.test.base_test bsuirfp.test.numeric_test bsuirfp.test.lists_test bsuirfp.test.numeric_adv_test))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run-tests 'bsuirfp.test.base_test 'bsuirfp.test.numeric_test 'bsuirfp.test.lists_test 'bsuirfp.test.numeric_adv_test)
  )
(-main)
