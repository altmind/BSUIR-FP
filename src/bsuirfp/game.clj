(ns bsuirfp.game
  (:gen-class )
  (:import java.io.File)
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

(defn step [state]
  (let [inputstring (do (println (format "[%s] What's next? Type help for options." ('state state))) (read-line))]
    (cond
      (= inputstring "quit") nil
      (= inputstring "stats") (let
                                [games ('games state)]
                                (println "Stats:")
                                (println (format "\tWON: %d" ('won games)))
                                (println (format "\tLOST: %d" ('lost games)))
                                state
                                )
      (= inputstring "state") (do (println state) state)
      (= inputstring "help") (do
                               (println "Guess a number game")
                               (println "Available commands")
                               (println "  quit")
                               (println "  stats")
                               (println "  state")
                               (println "  help")
                               (println "  eval [..]")
                               (println "  easier")
                               (println "  harder")
                               (println "  maybe [..]")
                               (println "  new")
                               state
                               )

      (.startsWith inputstring "eval") (do (println (format ">%s" (eval (read-string (.substring inputstring (.length "eval")))))) state)
      (= inputstring "easier") (let
                                   [maxguesses ('maxguesses state)]
                                   (if
                                     (> 10 maxguesses)
                                     (do
                                       (println (format "OK. Now you have %d guesses." (inc maxguesses)))
                                       (assoc state 'maxguesses (inc maxguesses))
                                       )
                                     (do (println "already too easy") state)
                                     )
                                   )
      (= inputstring "harder") (let
                                 [maxguesses ('maxguesses state)]
                                 (if
                                   (< 2 maxguesses)
                                   (do
                                     (println (format "OK. Now you have %d guesses." (dec maxguesses)))
                                     (assoc state 'maxguesses (dec maxguesses))
                                     )
                                   (do (println "already too hard") state)
                                   )
                                 )
      (.startsWith inputstring "maybe") (let
                                          [
                                            guess (Integer/parseInt (second (.split inputstring " ")))
                                            games ('games state)
                                            current ('current state)
                                            expecting ('expecting current)
                                            guessesleft ('guessesleft current)
                                            ]
                                          (if
                                            (= ('state state) 'game)
                                            (cond
                                              (= guess expecting)
                                              (do
                                                (println "Correct, Correct!")
                                                (merge state {'state 'gameover 'games (assoc games 'won (inc ('won games)))})
                                                )
                                              (not= guess expecting)
                                              (cond
                                                (= guessesleft 1)
                                                (do
                                                  (println "You've lost")
                                                  (println (format "I've guessed %d." expecting))
                                                  (merge state {'state 'gameover 'games (assoc games 'lost (inc ('lost games)))})
                                                  )
                                                :else (do
                                                        (cond
                                                          (< guess expecting) (println "My number is bigger")
                                                          (> guess expecting) (println "My number is smaller")
                                                          )
                                                        (merge state {'current
                                                                           (assoc current 'guessesleft (dec guessesleft))
                                                                           }
                                                          )
                                                        )
                                                )
                                              )
                                            (do (println "Start game with 'new'") state)
                                            )
                                          )
      (= inputstring "new") (do (println "Let's play a game. I've guessed a number between 1 and 25, try to guess")
                              (merge
                                state
                                {
                                  'state 'game
                                  'current {
                                             'expecting (inc (rand-int 25))
                                             'guessesleft ('maxguesses state)
                                             }
                                  }
                                ))
      :else (do (println "Sorry, i do not understand") state)
      )
    )
  )

(def filename (format "%s/%s" (System/getProperty "user.home") "clogame.clj"))

(defn load-settings []
  (let [f (File. filename)]
    (if (.exists f)
      (read-string (slurp filename))
      {
        'state 'gameover
        'games {'won 0 'lost 0}
        'current {
                   'expecting 0
                   'guessesleft 0
                   }
        'maxguesses 5
        }
      )
    )
  )

(defn save-settings [x]
  (spit filename x)
  )

(defn -main
  [& args]

  (save-settings
    (last
      (exitable_iterate
        step
        (load-settings)
        )
      )
    )

  ;(while true (println (read-line )))
  ;(last(iterate
  ;  ))
  ;)
  )
(-main)