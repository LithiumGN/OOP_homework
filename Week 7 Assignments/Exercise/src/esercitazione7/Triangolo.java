package esercitazione7;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Triangolo extends FigureGeometriche implements Confrontabile {
	protected double base;
	protected double altezza;
	protected double cateto;
	private static String description = "";
			//Figura piana limitata da tre segmenti (lati) che congiungono a due a due tre punti non allineati (vertici).";
	public Triangolo(double l,double d, double e){
		this.base=l;
		this.altezza=d;
		this.cateto=e;
	}
	public double area(){
		double result=(base*altezza)/2;
		return result;
	}
	public double perimetro(){
		double result=cateto+altezza+base;
		return result;
	}
	protected FigureGeometriche factor(int fattore) {
		Triangolo nuova=new Triangolo(this.base*fattore,this.altezza*fattore,this.cateto*fattore);
		return nuova;
	}
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
