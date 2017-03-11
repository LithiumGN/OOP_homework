package esercitazione7;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Rettangolo extends FigureGeometriche implements Confrontabile {
	private double lato1;
	private double lato2;
	private static String description = "";
			//In geometria, il rettangolo è un quadrilatero che ha tutti gli angoli interni congruenti tra loro (e, di conseguenza, retti).";
	
	public Rettangolo(double d,double d2){
		lato1=d;
		lato2=d2;
	}
	public double area(){
		double result=lato1*lato2;
		return result;
	}
	public double perimetro(){
		double result=(lato1+lato2)*2;
		return result;
	}
	
	void stampa(PrintStream out){

	}
	protected FigureGeometriche factor(int fattore) {
		Rettangolo nuova=new Rettangolo(lato1*fattore,lato2*fattore);
		return nuova;
	}
	@Override
	public String toString() {
		StringWriter output= new StringWriter();
		PrintWriter out = new PrintWriter(output);
		out.println("La figura in questione è un:"+ this.getClass().getSimpleName() );
		out.flush();
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lati hanno lunghezza: "+lato1 +" cm e " +lato2+" cm ");
		out.flush();
		return output.toString();
	}
}

