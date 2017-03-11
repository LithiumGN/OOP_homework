
package esercizio2;


public class Esercizio2 {
    public static double[][] generaMatrice(int n,int m){
        double[][] finale=new double[n][m];
        for (int i=0;i<finale.length;i++){
            for (int j=0;j<finale[0].length;j++){
                finale[i][j]=Math.random()*10;
            }
        }
        return finale;
    }
    
    public static double[] generaArray(int n){
        double[] finale=new double[n];
        for (int i=0;i<finale.length;i++){
                finale[i]=Math.random()*10;
            }
        
        return finale;
    }
    
    
    public static void stampaMatrice(double[][] matrix){
        for (int i=0;i<matrix.length;i++){
            System.out.println("");
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"   ");
            }
        }
    }
    
    
    
    public static void stampaArray(double[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"   ");
        }
    }
    
    public static double[] diagonale(double[][] matrix){
        double[] finale=new double[matrix[0].length];
        int l=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(i==j){
                    finale[l]+=matrix[i][j];
                    l++;
                }
            }
        }
      return finale;
    }
    
    public static double sommaArray(double[] array){
        double finale=0;
        for (int i=0;i<array.length;i++){
            finale+= array[i];
        }
        return finale;
    }
        
      
            
            
    public static void main(String[] args) {
        System.out.println("Inizio il test");
        double[][] matrice= generaMatrice(10,10);
        System.out.println(" ");
        stampaMatrice(matrice);
        System.out.println(" ");
        System.out.println("STAMPO ARRAY MATRICE");
        double[] diagonale=diagonale(matrice);
        stampaArray(diagonale);
        double[] array= generaArray(10);
        stampaArray(array);
        System.out.println("");
        System.out.println("Somma array è"+sommaArray(array));
    }
    
}
