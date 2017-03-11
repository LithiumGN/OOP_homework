package esercitazione7;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Ellisse extends FigureGeometriche implements Confrontabile {
	protected double semiasseMaggiore,semiasseMinore;
	private static String description = "";
			//"In geometria, un'ellisse è una curva piana ottenuta intersecando un cono con un piano in modo da produrre una curva chiusa.";
	public Ellisse(double d,double d2) {
		semiasseMaggiore=d;
		semiasseMinore=d2;
	}
	public double area(){
		double result=(int) (semiasseMaggiore*semiasseMinore*(Math.PI));
		return result;
	}
	public double perimetro(){
		double result=(int) ((2*Math.PI)*Math.sqrt((semiasseMaggiore*semiasseMaggiore*semiasseMinore*semiasseMinore)/2));
		return result;
	}
	
	void stampa(PrintStream out){

	}

	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione � un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println(description);
		out.flush();
		out.println("Il semiasse maggiore minore e maggiore hanno lunghezza "+semiasseMaggiore+" e "+semiasseMinore);
		out.flush();
		return output.toString();
				
	}
	@Override
	protected FigureGeometriche factor(int fattore) {
		Ellisse nuova=new Ellisse(this.semiasseMaggiore*fattore,this.semiasseMinore*fattore);
		return nuova;
	}

}
