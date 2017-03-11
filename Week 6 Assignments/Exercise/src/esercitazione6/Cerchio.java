package esercitazione6;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Cerchio extends Ellisse implements Confrontabile {
	private static int raggio;
	private static String description = "In geometria piana, il cerchio è la parte di piano delimitata da una circonferenza, ed è costituito dall'insieme infinito dei punti che distano da un punto dato, detto centro, non più di una distanza fissata detta raggio.";
	public Cerchio(int raggio) {
		super(raggio,raggio);
		Cerchio.raggio=raggio;
	}
	
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I raggio è "+raggio);
		out.flush();
		return output.toString();

	}
	
	

}
