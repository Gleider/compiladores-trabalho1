#!/bin/bash

x="teste"
menu ()
{
while true $x != "teste"
do
clear
echo "================================================"
echo "Trabalho de Compiladores"
echo "Criado por: Douglas Janovik e Gleider Mackedanz"
echo ""
echo "Digite o exercício desejado"
echo ""
echo "1) Executar Máquina de pilha em Clojure"
echo""
echo "2) Executar Analisador Léxico para mini-java"
echo ""
echo "0) Sair"
echo ""
echo "================================================"

echo "Digite a opção desejada:"
read x
echo "================================================"

case "$x" in


    1)
      echo "Executando Máquina de pilha em Clojure..."
      cd exercicio1 && java Compilador teste.txt > outPut.txt
      java -cp clojure-1.8.0.jar clojure.main < MP.clj
      echo ""
      echo "Finalizado."
      echo "Pressione enter para voltar..."
      read p
      cd ..

echo "================================================"
;;
    2)
      echo "Executando Analisador Léxico para mini-java..."
      cd exercicio2 && flex minijava.l
      gcc lex.yy.c	
      gnome-terminal -e ./a.out
      echo "Finalizado."
      echo "Pressione enter para voltar..."
      read p
      cd ..

echo "================================================"
 ;;
       0)
         echo "saindo..."
         sleep 2
         clear;
         exit;
echo "================================================"
;;

*)
        echo "Opção inválida!"
esac
done

}
menu


