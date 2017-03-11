package esercitazione6;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Rettangolo extends FigureGeometriche implements Confrontabile {
	private int lato1;
	private int lato2;
	private static String description = "In geometria, il rettangolo è un quadrilatero che ha tutti gli angoli interni congruenti tra loro (e, di conseguenza, retti).";
	
	public Rettangolo(int lato12,int lato22){
		lato1=lato12;
		lato2=lato22;
	}
	public double area(){
		int result=lato1*lato2;
		return result;
	}
	public double perimetro(){
		int result=(lato1+lato2)*2;
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
		out.println("Ovvero una"+description);
		out.flush();
		out.println("I lati hanno lunghezza: "+lato1 +" cm e " +lato2+" cm ");
		out.flush();
		return output.toString();
	}
}

