package com.esercitazione;

public class TestFigure {
public static void main(String[] args){
	
	///////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n1= new FigureGeometriche();
	Cerchio t1= new Cerchio(3);
	n1=t1;
	n1.stampa(System.out);
	System.out.println("Area: "+n1.area());
	System.out.println("Perimetro: "+n1.perimetro());
	System.out.println("");
	///////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n2= new FigureGeometriche();
	Ellisse t2= new Ellisse(3,4);
	n2=t2;
	n2.stampa(System.out);
	System.out.println("Area: "+n2.area());
	System.out.println("Perimetro: "+n2.perimetro());
	System.out.println("");
	/////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n3= new FigureGeometriche();
	Quadrato t3= new Quadrato(3);
	n3=t3;
	n3.stampa(System.out);
	System.out.println("Area: "+n3.area());
	System.out.println("Perimetro: "+n3.perimetro());
	System.out.println("");
	/////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n4= new FigureGeometriche();
	Triangolo t4= new Triangolo(3,6,5);
	n4=t4;
	n4.stampa(System.out);
	System.out.println("Area: "+n4.area());
	System.out.println("Perimetro: "+n4.perimetro());
	System.out.println("");
	//////////////////////////////////////////////
	System.out.println("");
	FigureGeometriche n5= new FigureGeometriche();
	Rettangolo t5= new Rettangolo(3,6);
	n5=t5;
	n5.stampa(System.out);
	System.out.println("Area: "+n5.area());
	System.out.println("Perimetro: "+n5.perimetro());
	System.out.println("");
	
}
}
