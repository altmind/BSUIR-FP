(ns bsuirfp.numeric_adv
  (:gen-class ))

(defn sum_pairs [list] (map #(apply + %1) (partition-all 2 list)))