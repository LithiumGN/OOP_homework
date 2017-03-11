package esercitazione7;

//import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProvaJFC {
	
public static double sommaAree(Set<FigureGeometriche> f){
	double result=0;
	Iterator<FigureGeometriche> iteratore=f.iterator();
	while(iteratore.hasNext()){
		result+=iteratore.next().area();
	}
	return result;
	
}
public static void stampaAree(Set<FigureGeometriche> f){
	Iterator<FigureGeometriche> iteratore=f.iterator();
	while(iteratore.hasNext()){
		System.out.println(iteratore.next().getClass().getName().substring(iteratore.next().getClass().getName().lastIndexOf(".") + 1));
	}
	
}

	public static void main(String[] args) {
		FigureGeometriche[] af = new FigureGeometriche[10];
		for (int i = 0; i < af.length; i++) {
			if (Math.random() < 1.0 / 5.0){
				double l = Math.random()*10;
				af[i] = new Triangolo(l, 5*l/6, 2*l/3);
			}
			else if (Math.random() < 2.0 / 5.0)
				af[i] = new Cerchio(Math.random() * 10);
			else if (Math.random() < 3.0 / 5.0)
				af[i] = new Ellisse(Math.random() * 10, Math.random() * 10);
			else if (Math.random() < 4.0 / 5.0)
				af[i] = new Quadrato(Math.random() * 10);
			else
				af[i] = new Rettangolo(Math.random() * 10, Math.random() * 10);
		}
		Set<FigureGeometriche> set = new HashSet<FigureGeometriche>();
	      try {
	         for(int i = 0; i < 10; i++) {
	            set.add(af[i]);
	         }
	         System.out.println(set);
	         double result=sommaAree(set);
	         stampaAree(set);
	         

	         System.out.println("Area sum: "+ result);
	      }
	      catch(Exception e) {}
		
		

	}

}
