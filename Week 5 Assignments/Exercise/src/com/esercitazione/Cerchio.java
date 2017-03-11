package com.esercitazione;

import java.io.PrintStream;

public class Cerchio extends FigureGeometriche {
	private static int raggio;
	private static String description = "In geometria piana, il cerchio è la parte di piano delimitata da una circonferenza, ed è costituito dall'insieme infinito dei punti che distano da un punto dato, detto centro, non più di una distanza fissata detta raggio.";
	public Cerchio(int raggio) {
		Cerchio.raggio=raggio;
	}
	public int area(){
		int result=(int) (raggio*raggio*(Math.PI));
		return result;
	}
	int perimetro(){
		int result=(int) ((raggio)*2*Math.PI);
		return result;
	}
	
	void stampa(PrintStream out){
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I raggio è "+raggio);
		out.flush();
	}

}
