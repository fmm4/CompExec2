package main;

import main.parser;
import java_cup.runtime.*;

class Driver {

	public static void main(String[] args) throws Exception {
		parser parser = new parser();
		Symbol x = parser.parse();
		System.out.print(parser.parse());
	}
}