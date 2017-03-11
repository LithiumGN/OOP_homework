package esercitazione6;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Ellisse extends FigureGeometriche implements Confrontabile {
	protected int semiasseMaggiore,semiasseMinore;
	private static String description = "In geometria, un'ellisse è una curva piana ottenuta intersecando un cono con un piano in modo da produrre una curva chiusa.";
	public Ellisse(int smax,int smin) {
		semiasseMaggiore=smax;
		semiasseMinore=smin;
	}
	public double area(){
		double result=(int) (semiasseMaggiore*semiasseMinore*(Math.PI));
		return result;
	}
	public double perimetro(){
		double result=(int) ((2*Math.PI)*Math.sqrt((semiasseMaggiore^2*semiasseMinore^2)/2));
		return result;
	}
	
	void stampa(PrintStream out){

	}
	@Override
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println(description);
		out.flush();
		out.println("Il semiasse maggiore minore e maggiore hanno lunghezza "+semiasseMaggiore+" e "+semiasseMinore);
		out.flush();
		return output.toString();
				
	}

}
