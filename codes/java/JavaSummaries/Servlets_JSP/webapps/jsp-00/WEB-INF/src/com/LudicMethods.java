package com;

public class LudicMethods {
	
	public static int throwDice(int limite) {
		int dice = (int) ( 1 + ( Math.random() * limite ) ) ;
		return dice ;
	}

}