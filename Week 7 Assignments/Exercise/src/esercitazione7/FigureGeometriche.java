
package esercitazione7;

public abstract class FigureGeometriche implements Confrontabile {
    
    public abstract double area(); 
    public abstract double perimetro();
    public abstract String toString(); 
    public boolean maggiore (Confrontabile c){
    	if (this.area()>((FigureGeometriche) c).area()){
    		return true;}
    	else {return false;}
    	
    }
    protected abstract FigureGeometriche factor(int fattore);
    public static FigureGeometriche scala(FigureGeometriche g, int a){
    	FigureGeometriche a1=g.factor(a);
    	return a1;
    }
}
