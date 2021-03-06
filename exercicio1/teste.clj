;;; Douglas Janovik Maliszewski
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(use '[clojure.string])
(use '[clojure.java.io])
(import java.util.ArrayList)

;Maquina de Pilha
(defn MP  [a array]
	;(println " ==" a)
	(if (starts-with? a "PUSH ") 
		(do (def b(replace-first a "PUSH " ""))
			(if (starts-with? b "1") 
				(do 
					(def c(replace-first b "1\n" ""))
					(.add array "1")
					(MP c array)
				)
				(if (starts-with? b "2") 
					(do 
						(def c(replace-first b "2\n" ""))
						(.add array "2")
						(MP c array)
					)
					(if (starts-with? b "3") 
						(do 
							(def c(replace-first b "3\n" ""))
							(.add array "3")
							(MP c array)
						)
						(if (starts-with? b "4") 
							(do 
								(def c(replace-first b "4\n" ""))
								(.add array "4")
								(MP c array)
							)
							(if (starts-with? b "5") 
								(do 
									(def c(replace-first b "5\n" ""))
									(.add array "5")
									(MP c array)
								)
								(if (starts-with? b "6") 
									(do 
										(def c(replace-first b "6\n" ""))
										(.add array "6")
										(MP c array)
									)
									(if (starts-with? b "7") 
										(do 
											(def c(replace-first b "7\n" ""))
											(.add array "7")
											(MP c array)
										)
										(if (starts-with? b "8") 
											(do 
												(def c(replace-first b "8\n" ""))
												(.add array "8")
												(MP c array)
											)
											(if (starts-with? b "9") 
												(do 
													(def c(replace-first b "9\n" ""))
													(.add array "9")
													(MP c array)
												)
												)
										)
									)
								)
							)
						)
					)
				)
			)
		)
	)
	(def d (replace-first a "\n" ""))
	(if (starts-with? d "SUM") 
			(do
				(def newArray (new java.util.ArrayList) )
				(def s1 ( - (.size array) 2) )
				(def s2 ( - (.size array) 1) )
				(def soma1( read-string(.get array s2 )) )
				(def soma2( read-string (.get array s1 )) )
				(def resultado ( + soma1 soma2 ) )
				(.add newArray (str resultado))
				(doseq [n (range (-(.size array) 2))]
						(.add newArray (.get array n))
				)
				(.add newArray (str resultado))
				(def c(replace-first d "SUM" ""))
				(MP c newArray)
			)
			(if (starts-with? d "MULT") 
				(do
					(def newArray (new java.util.ArrayList) )
					(def s1 ( - (.size array) 2) )
					(def s2 ( - (.size array) 1) )
					(def soma1( read-string(.get array s2 )) )
					(def soma2( read-string(.get array s1 )) )
					(def resultado ( * soma1 soma2 ) )
					(doseq [n (range(-(.size array)2))]
						(.add newArray (.get array n))
					)
					(.add newArray (str resultado))
					(def c(replace-first d "MULT" ""))
					(MP c newArray)
				)
				(if (starts-with? d "PRINT") 
					(do
						(println(.get array (- (.size array) 1)) )
						(def c(replace-first d "PRINT" ""))
						(MP c array)
					)
				)
			)
	)

)
;;Inicio execução
(with-open [rdr (reader "outPut.txt")]
       ( def a (join "\n" ( line-seq rdr ) ) )       
)
(def array (new java.util.ArrayList) )
(MP a array)
(def l(atom (.size array) ) )
