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
%eof}

/*-*
 * PADROES NOMEADOS:
 */
WHITESPACE      = [ \n\t\r]           //espacos em branco, quebra de linha, tabula£cao e carriage return;
COMMENT         = [/*([^]|[\r\n])+*/] // qualquer texto entre /* e *
ID              = ([A-Za-z_][A-Za-z_0-9]*)
LITINTEGER      = ([1-9][0-9]*)|0
LITFLOAT        = (({LITINTEGER}).([0-9]*))|(E("+"|"-")({LITINTEGER}))



%%
/**
 * REGRAS LEXICAS:
 */
";"|"."|","|"="|"("|")"|"{"|"}|""["|"]" {System.out.println("Token Delimitador");}
"class"|"public"|"extends"|"static"|"void"|"int"|"boolean"|"void"|"while"|"if"|"else"|"return"|"false"|"true"|"this"|"new" {System.out.println("Token Palavra Chave");}
"||"|"&&"|"=="|"!="|"<"|"<="|">"|">="|"+"|"-"|"*"|"/"|"%"|"!" {System.out.println("Token Operador");}
{LITINTEGER}    { System.out.println("Token Literal Inteiro ("+yytext()+")"); }
{LITFLOAT}      { System.out.println("Token Literal Float ("+yytext()+")"); }
{ID}            { System.out.println("Token ID ("+yytext()+")"); }
{WHITESPACE}    { /*Fazer nada*/ }
{COMMENT}       { System.out.println("Token Comentario reconhecido e ignorado."); }