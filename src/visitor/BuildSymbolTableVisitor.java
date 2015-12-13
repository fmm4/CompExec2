package visitor;


import symboltable.*;
import symboltable.Class;
import ast.And;
import ast.ArrayAssign;
import ast.ArrayLength;
import ast.ArrayLookup;
import ast.Assign;
import ast.Block;
import ast.BooleanType;
import ast.Call;
import ast.ClassDeclExtends;
import ast.ClassDeclSimple;
import ast.False;
import ast.Formal;
import ast.Identifier;
import ast.IdentifierExp;
import ast.IdentifierType;
import ast.If;
import ast.IntArrayType;
import ast.IntegerLiteral;
import ast.IntegerType;
import ast.LessThan;
import ast.MainClass;
import ast.MethodDecl;
import ast.Minus;
import ast.NewArray;
import ast.NewObject;
import ast.Not;
import ast.Plus;
import ast.Print;
import ast.Program;
import ast.This;
import ast.Times;
import ast.True;
import ast.Type;
import ast.VarDecl;
import ast.While;

public class BuildSymbolTableVisitor implements Visitor {

	//MUDE PARA FALSO CASO QUEIRA QUE NAO APARECA
	private boolean displayDebug = false;
	private boolean displayError = true;
	SymbolTable symbolTable;

	public BuildSymbolTableVisitor() {
		symbolTable = new SymbolTable();
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	private Class currClass;
	private Method currMethod;

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		if(displayDebug)
			db("[INICIO CONSTRUCAO DE TABELA DE SIMBOLOS]");
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
		if(displayDebug)
			db("[FIM CONSTRUCAO DE TABELA DE SIMBOLOS]");
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		if(displayDebug)
			db("Add classe principal "+n.i1.s+".");
		symbolTable.addClass(n.i1.s, null);
		currClass = symbolTable.getClass(n.i1.s);
		if(displayDebug)
			db("	Add variavel principal "+n.i2.s+". (Adicionado a global de "+n.i1.s+")");
		currClass.addVar(n.i2.s,new IntegerType());
		n.i1.accept(this);
		n.i2.accept(this);
		n.s.accept(this);
		currClass = null;
	}
	
	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		if(!symbolTable.containsClass(n.i.s)){
			symbolTable.addClass(n.i.s, null);
			currClass = symbolTable.getClass(n.i.s);
			if(displayDebug)
				db("Add classe "+n.i.s+".");
		}else{
			if(displayDebug)
				db("[IGNORED] Classe declarada duas vezes com nome"+n.i.s+".");
			return;
		}
		n.i.accept(this);
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		if(!symbolTable.containsClass(n.i.s)){
			symbolTable.addClass(n.i.s, symbolTable.getClass(n.j.s).getId());
			currClass = symbolTable.getClass(n.i.s);
			if(displayDebug)
				db("Adicionando subclasse "+n.i.s+". (Subtipo de "+n.j.s+")");
		}else{
			if(displayError)
				db("[IGNORED] Classe declarada duas vezes com nome"+n.i.s+".");
			return;
		}
		n.i.accept(this);
		n.j.accept(this);

		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		if(currMethod!=null){
			if(!currMethod.containsVar(n.i.s)){
				if(!currMethod.containsParam(n.i.s)){
					currMethod.addVar(n.i.s,n.t);
					if(displayDebug)
						db("		Add L. variavel "+n.i.s+"(T:"+n.t.toString()+"). (V. Local de "+currMethod.getId()+")");
				}else{
					if(displayError)
						db("[IGNORED]	Variavel "+n.i.s+" possui mesmo nome de parametro de "+currMethod.getId());
					return;
				}
			}else{
				if(displayDebug)
					db("[IGNORED]	Variavel "+n.i.s+" declarada duas vezes em "+currMethod.getId()+".");
				return;
			}
		}else if(currMethod==null){
			if(!currClass.containsVar(n.i.s)){
				currClass.addVar(n.i.s, n.t);
				if(displayDebug)
					db("	Add G. variavel "+n.i.s+"(T:"+n.t.toString()+"). (V. Global de "+currClass.getId()+")");
			}else{
				if(displayError)
					db("[IGNORED]Variavel "+n.i.s+" declarada duas vezes em "+currClass.getId()+".");
				return;
			}
		}
		n.t.accept(this);
		n.i.accept(this);
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		if(currClass!=null){
			if(!currClass.containsMethod(n.i.s)){
				currClass = symbolTable.getClass(getCurrentClass());
				currClass.addMethod(n.i.s,n.t);
				currMethod = currClass.getMethod(n.i.s);
				if(displayDebug)
					db("	Add metodo "+n.i.s+"(T:"+n.t.toString()+"). (Metodo de "+currClass.getId()+")");
			}else{
				if(displayError)
					db("[IGNORED]Metodo "+n.i.s+" declarado duas vezes em "+currClass.getId()+".");
				return;
			}
		}else{
			if(displayError)
				System.out.print("[IGNORED] Metodo "+n.i.s+" declarado fora de classe.");
			return;
		}
		n.t.accept(this);
		n.i.accept(this);
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		n.e.accept(this);
		currMethod = null;
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		n.t.accept(this);
		n.i.accept(this);
		if(!currClass.containsVar(n.i.s)){
			if(!currMethod.containsParam(n.i.s)){
				if(!currMethod.containsVar(n.i.s)){
					currMethod.addParam(n.i.s, n.t);
					if(displayDebug)
						db("		Add parametro "+n.i.s+"(T:"+n.t+"). (Param de "+currMethod.getId()+")");
				}else{
					if(displayError)
						db("[IGNORED]	Metodo ja possui variavel local com nome "+n.i.s);
					return;
				}
			}else{
				if(displayError)
					db("[IGNORED]	Ja foi declarado um parametro "+n.i.s+" no metodo.");
				return;
			}
		}else{
			if(displayError)
				db("[IGNORED]	Classe "+currClass.getId()+" ja possui variavel com nome "+n.i.s+", igual ao parametro.");
			return;
		}
	}

	public void visit(IntArrayType n) {
	}

	public void visit(BooleanType n) {
	}

	public void visit(IntegerType n) {
	}

	// String s;
	public void visit(IdentifierType n) {
	}

	// StatementList sl;
	public void visit(Block n) {
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		n.e.accept(this);
		n.s.accept(this);
	}

	// Exp e;
	public void visit(Print n) {
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.i.accept(this);
		n.e.accept(this);
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(And n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(Times n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.e1.accept(this);
		n.e2.accept(this);
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.e.accept(this);
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.e.accept(this);
		n.i.accept(this);
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).accept(this);
		}
	}

	// int i;
	public void visit(IntegerLiteral n) {
	}

	public void visit(True n) {
	}

	public void visit(False n) {
	}

	// String s;
	public void visit(IdentifierExp n) {
	}

	public void visit(This n) {
	}

	// Exp e;
	public void visit(NewArray n) {
		n.e.accept(this);
	}

	// Identifier i;
	public void visit(NewObject n) {
		
	}

	// Exp e;
	public void visit(Not n) {
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
		
	}
	
	////////
	
	public String getCurrentClass(){
		if(currClass==null){
			return null;
		}else{
			return currClass.getId();
		}
	}
	
	public void db(String s){
		System.out.println(s);
	}
}
