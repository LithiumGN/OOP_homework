
package esercizio3;


import java.io.*;


public class Esercizio3 {
    
     public static void stampaMatrice(double[][] matrix){
        for (int i=0;i<matrix.length;i++){
            System.out.println("");
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
     
    public static double[][] generaMatrice(int n,int m){
        double[][] finale=new double[n][m];
        for (int i=0;i<finale.length;i++){
            for (int j=0;j<finale[0].length;j++){
                finale[i][j]=Math.random()*10;
            }
        }
        return finale;
    }
    
    
    public static double diff(int row, int col, double [][] matrix, double value){
    int r_min=row-1;
    if (r_min<0)
        r_min=0;
    int r_max=row+1;
    if (r_max>=matrix.length){
        r_max=matrix.length-1;}
    int c_min=col-1;
    if (c_min<0)
        c_min=0;
    int c_max=col+1;
    if (c_max>=matrix[0].length){
        c_max=matrix[0].length-1;}
    
    double diff=0;
    double maxdiff=0;
    for (int r=r_min; r<=r_max; r++){
        for (int c=c_min; c<=c_max; c++){
            diff=Math.abs(matrix[r][c]-value);
            if (diff>maxdiff){
                maxdiff=diff;
            }
		}
	}
        return maxdiff;  
}

 public static void main(String[] args) throws IOException {
     System.out.println("Inizio il test");
     double[][] matrice= generaMatrice(10,10);
     stampaMatrice(matrice);
     System.out.println("FIINITO GENERAZIONE");
     for (int i=0; i<matrice.length; i++){
        for (int c=0; c<matrice[0].length; c++){
            matrice[i][c]=diff(i,c,matrice,matrice[i][c]);
        }
     }
     stampaMatrice(matrice);
 }
}
