package com.esercitazione;

import java.io.PrintStream;

public class Rettangolo extends FigureGeometriche {
	private static int lato1,lato2;
	private static String description = "In geometria, il rettangolo è un quadrilatero che ha tutti gli angoli interni congruenti tra loro (e, di conseguenza, retti).";
	
	public Rettangolo(int lato1,int lato2){
		Rettangolo.lato1=lato1;
		Rettangolo.lato2=lato2;
	}
	public int area(){
		int result=lato1*lato2;
		return result;
	}
	int perimetro(){
		int result=(lato1+lato2)*2;
		return result;
	}
	
	void stampa(PrintStream out){
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lati hanno lunghezza"+lato1 +" e " +lato2);
		out.flush();
	}
}

