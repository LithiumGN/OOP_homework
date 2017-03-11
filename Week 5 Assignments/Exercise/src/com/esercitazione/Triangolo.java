package com.esercitazione;

import java.io.PrintStream;

public class Triangolo extends FigureGeometriche {
	private static int base;
	private static int altezza;
	private static int cateto;
	private static String description = "Figura piana limitata da tre segmenti (lati) che congiungono a due a due tre punti non allineati (vertici).";
	public Triangolo(int base,int altezza, int cateto){
		Triangolo.base=base;
		Triangolo.altezza=altezza;
		Triangolo.cateto=cateto;
	}
	public int area(){
		int result=(base*altezza)/2;
		return result;
	}
	int perimetro(){
		int result=cateto+altezza+base;
		return result;
	}
	
	void stampa(PrintStream out){
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lati hanno lunghezza di "+base+altezza+cateto);
		out.flush();
	}
}
