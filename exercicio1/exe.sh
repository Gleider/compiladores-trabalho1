#!/bin/bash

cd clojure
java Compilador teste.txt > outPut.txt
java -cp clojure-1.8.0.jar clojure.main < MP.clj

