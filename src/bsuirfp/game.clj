(ns bsuirfp.game
  (:gen-class )
  )

(defn exitable_iterate [f x]
  (let [res (f x)]
    (cond
      (nil? res) [x]
      :else (cons x
              (lazy-seq
                (exitable_iterate f res)
                )
              )
      )
    )
  )

(defn step [state] state)

(defn -main
  [& args]

  (last
    (exitable_iterate
      step
      0
      )
    )


  ;(while true (println (read-line )))
  ;(last(iterate
  ;  ))
  ;)
  )
(-main)