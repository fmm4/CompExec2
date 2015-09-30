%%
/*-*
 * FUNCOES LEXICAS:
 */
%line
%column
%unicode
%standalone
%class CompEx2

//Nehuma variavel e utilizada
%{

%}

//Nao faz nada quando termina o arquivo
%eof{
	System.out.println("Leitura terminada.");
%eof}

/*-*
 * PADROES NOMEADOS:
 */
WHITESPACE      = [ \n\t\r]           
COMMENT         = ("/*"+([^]|[\r\n])+"*/") 
ID              = ([A-Za-z_][A-Za-z_0-9]*)
LITINTEGER      = ([1-9][0-9]*)|0
LITFLOAT        = (({LITINTEGER})+"."+([0-9]*+[1-9]))|("E"+("+"|"-")+({LITINTEGER}))
UNKNOWN         = ("//") // Utilizar ("//"~\n) e passar novamente pelo JFlex se quiser ignorar a linha toda.

%%
/**
 * REGRAS LEXICAS:
 */
";"|"."|","|"="|"("|")"|"{"|"}|""["|"]" {System.out.println("Token Delimitador	("+yytext()+")");}
"class"|"public"|"extends"|"static"|"void"|"int"|"boolean"|"while"|"if"|"else"|"return"|"false"|"true"|"this"|"new" {System.out.println("Token Palavra Chave	("+yytext()+")");}
"||"|"&&"|"=="|"!="|"<"|"<="|">"|">="|"+"|"-"|"*"|"/"|"%"|"!" {System.out.println("Token Operador		("+yytext()+")");}
{LITINTEGER}    { System.out.println("Token Literal Inteiro	("+yytext()+")"); }	
{LITFLOAT}      { System.out.println("Token Literal Float	("+yytext()+")"); }
{ID}            { System.out.println("Token ID		("+yytext()+")"); }
{WHITESPACE}    { /*Fazer nada*/ }
{COMMENT}       { System.out.println("Token Comentario reconhecido e ignorado."); }
{UNKNOWN}       { System.out.println("!!ERRO!! Token Desconhecido"); }
