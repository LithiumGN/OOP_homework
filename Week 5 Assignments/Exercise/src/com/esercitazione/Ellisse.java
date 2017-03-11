package com.esercitazione;

import java.io.PrintStream;

public class Ellisse extends FigureGeometriche {
	private static int semiasseMaggiore,semiasseMinore;
	private static String description = "In geometria, un'ellisse è una curva piana ottenuta intersecando un cono con un piano in modo da produrre una curva chiusa.";
	public Ellisse(int smax,int smin) {
		Ellisse.semiasseMaggiore=smax;
		Ellisse.semiasseMinore=smin;
	}
	public int area(){
		int result=(int) (semiasseMaggiore*semiasseMinore*(Math.PI));
		return result;
	}
	int perimetro(){
		int result=(int) ((2*Math.PI)*Math.sqrt((semiasseMaggiore^2*semiasseMinore^2)/2));
		return result;
	}
	
	void stampa(PrintStream out){
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println(description);
		out.flush();
		out.println("Il semiasse maggiore minore e maggiore hanno lunghezza "+semiasseMaggiore+" e "+semiasseMinore);
		out.flush();
	}

}
