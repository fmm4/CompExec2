package visitor;

import ast.And;
import symboltable.*;
import symboltable.Class;
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

public class TypeCheckVisitor implements TypeVisitor {

	//MUDE PARA FALSO CASO QUEIRA QUE NAO APARECA
	private boolean displayDebug = false;
	private boolean displayError = true;

	private SymbolTable symbolTable;
	
	private Method currMethod;
	private Class currClass;

	public TypeCheckVisitor(SymbolTable st) {
		symbolTable = st;
	}

	// MainClass m;
	// ClassDeclList cl;
	public Type visit(Program n) {
		if(displayDebug)
			db("[INICIO CHECAGEM DE TIPO] (de agora em diante, so troca de env e erros serao impressos)");
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
		if(displayDebug)
			db("[FIM CHECAGEM DE TIPO]");
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Type visit(MainClass n) {
		n.i1.accept(this);
		currClass = symbolTable.getClass(n.i1.s);
		if(displayDebug)
			db("[EnvChange]New:"+currClass.getId()+", Method: null");
		n.i2.accept(this);
		n.s.accept(this);
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclSimple n) {
		n.i.accept(this);
		currClass = symbolTable.getClass(n.i.s);
		if(displayDebug)
			db("[EnvChange]New:"+currClass.getId()+", Method: null");
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
		if(displayDebug)
			db("[EnvChange]New:null, Method:null");
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclExtends n) {
		n.i.accept(this);
		n.j.accept(this);
		currClass = symbolTable.getClass(n.i.s);
		if(displayDebug)
			db("[EnvChange]New:"+currClass.getId()+", Method: null");
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}		
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}
		currClass = null;
		if(displayDebug)
			db("[EnvChange]New:null, Method: null");
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(VarDecl n) {
		Type vt1 = n.t.accept(this);
		n.i.accept(this);
		return vt1;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public Type visit(MethodDecl n) {
		Type vt1 = n.t.accept(this);
		n.i.accept(this);
		currMethod = currClass.getMethod(n.i.s);
		if(displayDebug)
			db("	[EnvChange]New:"+currClass.getId()+", Method:"+currMethod.getId());
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
		if(displayDebug)
			db("	[EnvChange]New:"+currClass.getId()+", Method: null");
		return vt1;
	}

	// Type t;
	// Identifier i;
	public Type visit(Formal n) {
		Type vt1 = n.t.accept(this);
		n.i.accept(this);
		return vt1;
	}

	public Type visit(IntArrayType n) {
		return new IntArrayType();
	}

	public Type visit(BooleanType n) {
		return new BooleanType();
	}

	public Type visit(IntegerType n) {
		return new IntegerType();
	}

	// String s;
	public Type visit(IdentifierType n) {
		return new IdentifierType(n.s);
	}

	// StatementList sl;
	public Type visit(Block n) {
		Type returnType = null;
		for (int i = 0; i < n.sl.size(); i++) {
			returnType = n.sl.elementAt(i).accept(this);
		}
		return returnType;
	}

	// Exp e;
	// Statement s1,s2;
	public Type visit(If n) {
		Type vt1 = n.e.accept(this);
		if(!(vt1 instanceof BooleanType)){
			if(displayError)
				db("[ERRO]	If cuja condicao nao e booleana");
			return null;
		}
		Type vt2 = n.s1.accept(this);
		Type vt3 = n.s2.accept(this);
		return new BooleanType();
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		Type vt1 = n.e.accept(this);
		Type vt2 = null;
		if(vt1 instanceof BooleanType){
			vt2 = n.s.accept(this);
			return new BooleanType();
		}else{
			if(displayError)
				db("[ERRO]	While com condicao nao booleana");
			return null;
		}
	}

	// Exp e;
	public Type visit(Print n) {
		return n.e.accept(this);
	}

	// Identifier i;
	// Exp e;
	public Type visit(Assign n) {
		Type vt1 = n.i.accept(this);
		Type vt2 = n.e.accept(this);
		if(symbolTable.compareTypes(vt1,vt2)){
			return n.e.accept(this);
		}else if(vt1 instanceof IdentifierType && vt2 instanceof IdentifierType){
			Class type1 = symbolTable.getClass(((IdentifierType) vt1).s);
			Class type2 = symbolTable.getClass(((IdentifierType) vt2).s);
			if(type1.equals(type2)){
				return vt1;
			}else if(type1.parent().equals(type2)){
				return vt1;
			}
			if(displayError)
				db("[ERRO]	Associando objetos de classes nao iguais ou que nao sao subtipo.\n("+type1.getId()+"(Parent:"+getClass(type1.parent()).getId()+") and "+type2.getId()+")");
			return null;
		}else{
			if(displayError)
				db("[ERRO]	Tentando associar valor do tipo \n("+n.e+" - "+vt2.toString()+" sendo inserido em "+vt1.toString()+" "+n.i.s+")");
			return null;
		}
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		Type vt1 = n.i.accept(this);
		Type vt2 = n.e1.accept(this);
		Type vt3 = n.e2.accept(this);
		if(vt2 instanceof IntegerType){
			if(vt1 instanceof IntArrayType && vt3 instanceof IntegerType){
				return vt1;
			}else{
				if(displayError)
					db("[ERRO]	Tentando colocar algo de tipos diferentes em um array ("+vt1+" "+n.i.s+" inserido no tipo "+vt3+")");
				return null;
			}
		}else{
			if(displayError)
				db("[ERRO]	Usando algo sem ser um inteiro para especificar uma posicao em um array.");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(And n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e2.accept(this);
		if(symbolTable.compareTypes(vt1, vt2) && vt1 instanceof BooleanType){
			return new BooleanType();
		}else{
			if(displayError)
				db("[ERRO]	Comparacao AND com tipos diferentes!");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e2.accept(this);
		if(vt1 instanceof IntegerType && vt2 instanceof IntegerType){
			return new BooleanType();
		}else{
			if(displayError)
				db("[ERRO]	Comparacao LT com tipos diferentes! ("+vt1+" < "+vt2+")");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e1.accept(this);
		if(vt1 instanceof IntegerType && vt2 instanceof IntegerType){
			return new IntegerType();
		}else{
			if(displayError)
				db("[ERRO]	Adicao com tipos nao inteiro! ("+vt1.toString()+" + "+vt2.toString()+")");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e1.accept(this);
		if(vt1 instanceof IntegerType && vt2 instanceof IntegerType){
			return new IntegerType();
		}else{
			if(displayError)
				db("[ERRO]	Subtracao com tipos nao inteiro! ("+vt1+" - "+vt2+")");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e1.accept(this);
		if(vt1 instanceof IntegerType && vt2 instanceof IntegerType){
			return new IntegerType();
		}else{
			if(displayError)
				db("[ERRO]	Multiplicacao com tipos nao inteiro! ("+vt1+"+"+vt2+")");
			return null;
		}
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		Type vt1 = n.e1.accept(this);
		Type vt2 = n.e2.accept(this);
		if(vt2 instanceof IntegerType){
			return new IntegerType();
		}else{
			if(displayError)
				db("[ERRO]	Tentando usar algo que nao e inteiro para procurar um valor de um array!");
			return null;
		}
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		return new IntegerType();
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Type visit(Call n) {
		Type callerType = n.e.accept(this);
		Type vt1 = null;
		if(callerType instanceof IdentifierType){
			if(symbolTable.containsClass(((IdentifierType) callerType).s)){
				Class objectClass = symbolTable.getClass(((IdentifierType) callerType).s);
				if(objectClass.containsMethod(n.i.s)){
					Class tempClass = currClass;
					this.currClass = objectClass;
					Method tempMethod = currMethod;
					currMethod = null;					
					n.i.accept(this);				
					this.currMethod = currClass.getMethod(n.i.s);
					vt1 =currClass.getMethod(n.i.s).type();				
					this.currClass = tempClass;
					this.currMethod = tempMethod;
					for (int i = 0; i < n.el.size(); i++) {
						n.el.elementAt(i).accept(this);
					}	
				}else{
					if(displayError)
						db("[ERRO]Nenhum metodo "+n.i.s+"encontrado na classe "+((IdentifierType) callerType).s+".");
				}
			}else{
				if(displayError)
					db("[ERRO]Nenhuma classe "+((IdentifierType) callerType).s+" encontrada.");
			}
		}
		return vt1;
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return new IntegerType();
	}

	public Type visit(True n) {
		return new BooleanType();
	}

	public Type visit(False n) {
		return new BooleanType();
	}

	// String s;
	public Type visit(IdentifierExp n) {
		return getVarType(n.s);
	}

	public Type visit(This n) {
		return getVarType(currClass.getId());
	}

	// Exp e;
	public Type visit(NewArray n) {
		return new IntArrayType();
	}

	// Identifier i;
	public Type visit(NewObject n) {
		if(getClass(n.i.s)!=null){
			return getClass(n.i.s).type();
		}else{
			if(displayError)
				db("[ERRO]		Nao achada tipo de classe "+n.i.s+".");
			return null;
		}
	}

	// Exp e;
	public Type visit(Not n) {
		Type vt1 = n.e.accept(this);
		if(vt1 instanceof BooleanType){
			return new BooleanType();
		}else{
			if(displayError)
				db("[ERRO]	Booleano NOT sendo usado em algo nao booleano");
			return null;
		}
	}

	// String s;
	public Type visit(Identifier n) {
		return getVarType(n.s);
	}
	
	//////////////////////
	//Novos metodos		//
	//////////////////////
	public boolean insideMethod(){
		if(currMethod==null){
			return false;
		}else{
			return true;
		}
	}
	
	public Type getVarType(String vN){
		if(insideMethod()){
			if(currMethod.containsVar(vN)){
				return currMethod.getVar(vN).type();
			}else if(currMethod.containsParam(vN)){
				return currMethod.getParam(vN).type();
			}
		}
		if((currClass!=null)){
			if(currClass.containsVar(vN)){
				return currClass.getVar(vN).type();
			}
			if(currClass.containsMethod(vN)){
				return currClass.getMethod(vN).type();
			}
		}
		if(symbolTable.containsClass(vN)){
			return symbolTable.getClass(vN).type();
		}
		if(displayError)
			db("[ERRO]		Nao foi encontrado identifier "+vN+" (Current env Method:"+currMethod.getId()+", Class:"+currClass.getId()+")");
		return null;

	}
	
	public Class getClass(String cN){
		if(symbolTable.containsClass(cN)){
			return symbolTable.getClass(cN);
		}else{
			if(displayError)
				db("[ERRO]Nao foi encontrada classe com nome "+cN);
			return null;
		}
	}
	
	public void db(String k){
		System.out.println(k);
	}
}
