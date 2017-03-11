package esercitazione7;

//import java.util.*;



public class TestFigure {


public static Confrontabile massimo(Confrontabile[] c){
	Confrontabile max=null;
	for (int i=0; i<c.length; i++) {
		if (max==null){
			max=c[i];
		}
		else {
			boolean result= c[i].maggiore(max);
			if (result){
				max=c[i];
			}
		}
	}
		return max;
	
}
public static void main(String[] args){
	/*
	///////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n1= new Cerchio(3);
	String test=n1.toString();
	System.out.println(test);
	System.out.println("L'area della figura è "+n1.area());
	

	///////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n2= new Ellisse(3,4);
	test=n2.toString();
	System.out.println(test);
	System.out.println("L'area della figura è "+n2.area());

	/////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n3= new Quadrato(4);
	test=n3.toString();
	System.out.println(test);
	System.out.println("L'area della figura  è "+n3.area());
	System.out.println("L'area della figura quadrato � "+n3.area()+"\n");
	/////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n4= new Triangolo(3,6,5);
	test=n4.toString();
	System.out.println(test);
	System.out.println("L'area della figura è "+n4.area());
	System.out.println("L'area della figura quadrato è "+n3.area()+"\n");
	//////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n5= new Rettangolo(3,10);
	test=n5.toString();
	System.out.println(test);
	System.out.println("L'area della figura è "+n5.area()+"\n");
	System.out.println("L'area della figura quadrato è "+n3.area()+"\n");
	boolean risultato=n1.maggiore(n5);
	System.out.println("area cerchio "+n1.area()+" area rettangolo "+n5.area()+" rettangolo  è più grande del quadrato. Il risultato del metodo � "+risultato);
	
	FigureGeometriche n6=new Quadrato(5);
	System.out.println("L'area della figura è "+n6.area());
	System.out.println("L'area della figura quadrato è "+n6.area()+"\n");
	FigureGeometriche n7=FigureGeometriche.scala(n6,3);
	System.out.println("L'area della figura è "+n7.area());
	System.out.println("L'area della figura quadrato è "+n7.area()+"\n");
	*/
	
}
}
