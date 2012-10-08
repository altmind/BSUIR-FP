(ns bsuirfp.main
  (:gen-class)
  (:use clojure.test bsuirfp.numeric bsuirfp.test.base_test bsuirfp.test.numeric_test bsuirfp.test.lists_test bsuirfp.test.numeric_adv_test))

(defn -main
  [& args]
  (run-tests 'bsuirfp.test.base_test 'bsuirfp.test.numeric_test 'bsuirfp.test.lists_test 'bsuirfp.test.numeric_adv_test)
  )
(-main)
