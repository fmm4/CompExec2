package main;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%
%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

/*-*
 * PADROES NOMEADOS:
 */
WHITESPACE      = [ \n\t\r]           
COMMENT         = ("/*"+([^]|[\r\n])+"*/") |("//"~\n)
ID              = ([A-Za-z_][A-Za-z_0-9]*)
LITINTEGER      = ([1-9][0-9]*)|0
LITFLOAT        = (({LITINTEGER})+"."+([0-9]*+[1-9]))|("E"+("+"|"-")+({LITINTEGER}))

%%

";"
{return symbolFactory.newSymbol("PONTOVIRGULA",PONTOVIRGULA);}
"."
{return symbolFactory.newSymbol("PONTO",PONTO);}
","
{return symbolFactory.newSymbol("VIRGULA",VIRGULA);}
"="
{return symbolFactory.newSymbol("IGUAL",IGUAL);}
"("
{return symbolFactory.newSymbol("PARENT_ESQ",PARENT_ESQ);}
")"
{return symbolFactory.newSymbol("PARENT_DIR",PARENT_DIR);}
"{"
{return symbolFactory.newSymbol("CURLY_ESQ",CURLY_ESQ);}
"}"
{return symbolFactory.newSymbol("CURLY_DIR",CURLY_DIR);}
"["
{return symbolFactory.newSymbol("COLCHE_ESQ",COLCHE_ESQ);}
"]"
{return symbolFactory.newSymbol("COLCHE_DIR",COLCHE_DIR);} 
"class"
{return symbolFactory.newSymbol("K_CLASS",K_CLASS);} 
"public"
{return symbolFactory.newSymbol("K_PUBLIC",K_PUBLIC);} 
"extends"
{return symbolFactory.newSymbol("K_EXTENDS",K_EXTENDS);} 
"static"
{return symbolFactory.newSymbol("K_STATIC",K_STATIC);} 
"void"
{return symbolFactory.newSymbol("T_VOID",T_VOID);} 
"int"
{return symbolFactory.newSymbol("T_INT",T_INT);} 
"String"
{return symbolFactory.newSymbol("T_STRING",T_STRING);} 
"main"
{return symbolFactory.newSymbol("K_MAIN",K_MAIN);}
"length"
{return symbolFactory.newSymbol("K_LENGTH",K_LENGTH);}
"System.out.println"
{return symbolFactory.newSymbol("K_PRINT",K_PRINT);}
"boolean"
{return symbolFactory.newSymbol("T_BOOLEAN",T_BOOLEAN);} 
"while"
{return symbolFactory.newSymbol("K_WHILE",K_WHILE);} 
"if"
{return symbolFactory.newSymbol("K_IF",K_IF);} 
"else"
{return symbolFactory.newSymbol("K_ELSE",K_ELSE);} 
"return"
{return symbolFactory.newSymbol("K_RETURN",K_RETURN);} 
"false"
{return symbolFactory.newSymbol("B_FALSE",B_FALSE);} 
"true"
{return symbolFactory.newSymbol("B_TRUE",B_TRUE);} 
"this"
{return symbolFactory.newSymbol("K_THIS",K_THIS);} 
"new"
{return symbolFactory.newSymbol("K_NEW",K_NEW);} 
"||"
{return symbolFactory.newSymbol("OP_OR",OP_OR);} 
"&&"
{return symbolFactory.newSymbol("OP_AND",OP_AND);} 
"=="
{return symbolFactory.newSymbol("OP_EQ",OP_EQ);} 
"!="
{return symbolFactory.newSymbol("OP_DIF",OP_DIF);} 
"<"
{return symbolFactory.newSymbol("OP_LT",OP_LT);} 
"<="
{return symbolFactory.newSymbol("OP_LET",OP_LET);} 
">"
{return symbolFactory.newSymbol("OP_GT",OP_GT);} 
">="
{return symbolFactory.newSymbol("OP_GET",OP_GET);} 
"+"
{return symbolFactory.newSymbol("A_PLUS",A_PLUS);} 
"-"
{return symbolFactory.newSymbol("A_MINUS",A_MINUS);} 
"*"
{return symbolFactory.newSymbol("A_MULT",A_MULT);} 
"/"
{return symbolFactory.newSymbol("A_DIV",A_DIV);} 
"%"
{return symbolFactory.newSymbol("A_MOD",A_MOD);} 
"!"
{return symbolFactory.newSymbol("A_FAT",A_FAT);} 

{LITINTEGER}    
{ return symbolFactory.newSymbol("LITERAL_INTEIRO",LITERAL_INTEIRO);}	
{LITFLOAT}      
{ return symbolFactory.newSymbol("LITERAL_FLUTUANTE",LITERAL_FLUTUANTE);}
{ID}       
{ return symbolFactory.newSymbol("IDENTIFICADOR",IDENTIFICADOR);}
{COMMENT}       
{}
{WHITESPACE}    
{ /*Ignorado*/ }
.				
{ throw new Error("Token nao identificado: <"+yytext()+">");}