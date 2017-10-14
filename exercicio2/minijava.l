DIGITO	[0-9]
LETRA	[a-zA-Z]
RESERV	("boolean"|"class"|"extends"|"public"|"static"|"void"|"main"|"String"|"return"|"int"|"if"|"else"|"while"|"System.out.println"|"length"|"true"|"false"|"this"|"new")
ID	{LETRA}({LETRA}|{DIGITO}|_)*
OP	("("|")"|"["|"]"|"{"|"}"|";"|"."|","|"="|"<"|">"|"=="|"!="|"="|"+"|"-"|"*"|"/"|"&&"|"!")
STR	("\""(.)*"\"")
COMENT	("//"(.)*|"/*"(.)*"*/")
IGNORE	[ \n\t\r\f]
%%
({OP}|{RESERV}|{STR})	{printf("%s\n", yytext);}
{DIGITO}+		{printf("Inteiro: %s\n",yytext);}
{DIGITO}+"."{DIGITO}+	{printf("Real: %s\n",yytext);} 
{ID}			{printf("Identificador: %s\n",yytext);}
({COMENT}|{IGNORE})	{/*ignora espaços, comentários, tab, etc*/}
%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
