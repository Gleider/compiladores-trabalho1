(require '[clojure.repl :refer :all])
(use '[clojure.string])
(use '[clojure.java.io])
(import java.util.ArrayList)


(def array(new java.util.ArrayList))
(.add array "22")
(.add array "1")
(.add array "3")
(.add array "22")
( println (.size array))
(.remove array "22" )

(doseq [n (range (-(.size array)2))]
( println  (.get array n))
)

