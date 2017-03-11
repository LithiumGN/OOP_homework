
package esercitazione6;

public abstract class FigureGeometriche implements Confrontabile {
    
    public abstract double area(); 
    public abstract double perimetro();
    public abstract String toString(); 
    public boolean maggiore (Confrontabile c){
    	if (this.area()>((FigureGeometriche) c).area()){
    		return true;}
    	else {return false;}
    	
    }
}
