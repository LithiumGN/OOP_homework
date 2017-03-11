package esercitazione7;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Cerchio extends Ellisse implements Confrontabile {
	private static double raggio;
	private static String description = "In geometria piana, il cerchio è la parte di piano delimitata da una circonferenza, ed � costituito dall'insieme infinito dei punti che distano da un punto dato, detto centro, non pi� di una distanza fissata detta raggio.";
	public Cerchio(double d) {
		super(d,d);
		Cerchio.raggio=d;
	}
    protected FigureGeometriche factor(int fattore) {
		Cerchio nuova=new Cerchio(raggio*fattore);
		return nuova;
	}
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione � un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I raggio è "+raggio);
		out.flush();
		return output.toString();

	}
	
	

}
