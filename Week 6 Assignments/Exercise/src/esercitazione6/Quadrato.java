package esercitazione6;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Quadrato extends Rettangolo implements Confrontabile {
	private static int lato;
	private static String description = "In geometria, il quadrato è un quadrilatero regolare, cioè un poligono con quattro lati e quattro angoli congruenti (tutti retti).";
	public Quadrato(int lato){
		super(lato,lato);
		Quadrato.lato=lato;
	}
	
	
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lato ha lunghezza"+lato);
		out.flush();
		return output.toString();
	}
	
}


