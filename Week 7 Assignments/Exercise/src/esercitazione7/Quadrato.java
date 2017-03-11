package esercitazione7;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Quadrato extends Rettangolo implements Confrontabile {
	private static double lato;
	private static String description = "";
			//In geometria, il quadrato è un quadrilatero regolare, cioè un poligono con quattro lati e quattro angoli congruenti (tutti retti).";
	public Quadrato(double d){
		super(d,d);
		Quadrato.lato=d;
	}
	protected FigureGeometriche factor(int fattore) {
		Quadrato nuova=new Quadrato(lato*fattore);
		return nuova;
	}
	
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione � un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lato ha lunghezza"+lato);
		out.flush();
		return output.toString();
	}
	
}


