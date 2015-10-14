import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;

%%
%line
%column
%unicode
%public
%class Lexer
%implements sym
%cup

/* 
Declarações

código dentro de %{ e %}, é copiado para a classe gerada. 
a ideia é utilizar este recurso para declarar atributos e métodos usados nas ações 
*/ 
%{
	public Lexer(ComplexSymbolFactory sf, java.io.inputStream is){
		this(is);
		symbolFactory = sf;
	}
	public Lexer(CComplexSymbolFactory sf, java.io.Reader reader){
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
    	System.out.println("Aviso: " + message + " em : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("Erro na leitura: " + message + " em : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}


%eof{
	System.out.println("Leitura terminada.");
%eof}

%eofval{
	return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

/*-*
 * PADROES NOMEADOS:
 */
WHITESPACE      = [ \n\t\r]           
COMMENT         = ("/*"+([^]|[\r\n])+"*/") 
ID              = ([A-Za-z_][A-Za-z_0-9]*)
LITINTEGER      = ([1-9][0-9]*)|0
LITFLOAT        = (({LITINTEGER})+"."+([0-9]*+[1-9]))|("E"+("+"|"-")+({LITINTEGER}))

%%
/**
 * REGRAS LEXICAS:
 */
";"|"."|","|"="|"("|")"|"{"|"}"|"["|"]" 
{ return symbolFactory.newSymbol("DELIMITADOR",DELIMITADOR); }
"class"|"public"|"extends"|"static"|"void"|"int"|"boolean"|"while"|"if"|"else"|"return"|"false"|"true"|"this"|"new" 
{ return symbolFactory.newSymbol("PALAVARA_CHAVE",PALAVRA_CHAVE);}
"||"|"&&"|"=="|"!="|"<"|"<="|">"|">="|"+"|"-"|"*"|"/"|"%"|"!" 
{ return symbolFactory.newSymbol("OPERADOR",OPERADOR);}
{LITINTEGER}    
{ return symbolFactory.newSymbol("LITERAL_INTEIRO",LITERAL_INTEIRO);}	
{LITFLOAT}      
{ return symbolFactory.newSymbol("LITERAL_FLUTUANTE",LITERAL_FLUTUANTE);}
{ID}       
{ return symbolFactory.newSymbol("IDENTIFICADOR",IDENTIFICADOR);}
{COMMENT}       
{ return symbolFactory.newSymbol("COMENTARIO",COMENTARIO); }
{WHITESPACE}    
{ /*Ignorado*/ }
.				
{ throw new Error("Token nao identificado: <"+yytext()+">");}