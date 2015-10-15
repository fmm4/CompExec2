package main;

import java.util.List;

import java_cup.runtime.Symbol;

class Driver {

	public static void main(String[] args) throws Exception {
		ParserCup parser = new ParserCup();
		Symbol x = parser.parse();
		if (x.value instanceof List<?>) {
			System.out.print(x);
		}

	}

}