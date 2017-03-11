package com.esercitazione;

import java.io.PrintStream;

public class Quadrato extends FigureGeometriche {
	private static int lato;
	private static String description = "In geometria, il quadrato è un quadrilatero regolare, cioè un poligono con quattro lati e quattro angoli congruenti (tutti retti).";
	public Quadrato(int lato){
		Quadrato.lato=lato;
	}
	public int area(){
		int result=lato*lato;
		return result;
	}
	int perimetro(){
		int result=lato*4;
		return result;
	}
	
	void stampa(PrintStream out){
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lato ha lunghezza"+lato);
		out.flush();
	}
}

