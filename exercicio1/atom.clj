(def vari (atom 22))
(swap! vari + 22)
(println @vari)