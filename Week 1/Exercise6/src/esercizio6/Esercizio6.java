
package esercizio6;
import java.io.*;

public class Esercizio6 {

    public static void main(String[] args) throws IOException {
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        String input=r.readLine();
        BufferedReader n= new BufferedReader(new InputStreamReader(System.in));
        String input2=n.readLine();
        int somma1=0;
        int somma2=0;
        for (int i=0;i<(input.length());i++){
            somma1+= (int)input.charAt(i);
        }
        for (int j=0;j<(input2.length());j++){
            somma2+= (int)input2.charAt(j);
        }
        if (somma1>somma2){
            System.out.println("Il risultato è "+input+" "+somma1);
        }
        else {
            System.out.println("Il risultato è "+input2+" "+somma2);
        }

    }
    
}
