
package esercizio5;

import java.io.*;

public class Esercizio5 {

    public static void main(String[] args) throws IOException {
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        String input=r.readLine();
        BufferedReader n= new BufferedReader(new InputStreamReader(System.in));
        String input2=n.readLine();
        float len1=input.length();
        float len2=input2.length();
        float risultato=len1/len2;
        System.out.println("Il risultato è "+ risultato);
        
    }
    
}
