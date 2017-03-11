package esercitazione6;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Triangolo extends FigureGeometriche implements Confrontabile {
	private static int base;
	private static int altezza;
	private static int cateto;
	private static String description = "Figura piana limitata da tre segmenti (lati) che congiungono a due a due tre punti non allineati (vertici).";
	public Triangolo(int base,int altezza, int cateto){
		Triangolo.base=base;
		Triangolo.altezza=altezza;
		Triangolo.cateto=cateto;
	}
	public double area(){
		double result=(base*altezza)/2;
		return result;
	}
	public double perimetro(){
		double result=cateto+altezza+base;
		return result;
	}
	

	@Override
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lati hanno lunghezza di "+base+" cm "+altezza+" cm "+cateto+" cm ");
		out.flush();
		return output.toString();
	}
}
