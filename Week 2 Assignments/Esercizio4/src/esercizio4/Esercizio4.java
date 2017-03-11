package esercizio4;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author leona
 */
public class Esercizio4 {
    public static double[][] generaMatrice(int n,int m){
        double[][] finale=new double[n][m];
        for (int i=0;i<finale.length;i++){
            for (int j=0;j<finale[0].length;j++){
                finale[i][j]=Math.random()*10;
            }
        }
        return finale;
    }
    public static void stampaMatrice(double[][] matrix){
        for (int i=0;i<matrix.length;i++){
            System.out.println("");
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fileinput= new File("input4.txt"); //Altrimenti... BufferedReader n1= new BufferedReader(new FileReader(fileinput));
        Scanner n1= new Scanner (new FileReader(fileinput));  
        int row=n1.nextInt(); //Integer.parseInt(n1.readLine());
        int col=n1.nextInt();  //Integer.parseInt(n1.readLine());
        double[][] matrix=generaMatrice(row,col);
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j]=n1.nextDouble();
            }
        }
        stampaMatrice(matrix);
    }
}
