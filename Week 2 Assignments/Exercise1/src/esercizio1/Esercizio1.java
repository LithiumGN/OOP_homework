
package esercizio1;
import java.io.*;

public class Esercizio1 {

    public static void inverti(String word,StringBuilder result, int n){
         if (n==0){
            result.append(word.substring(n,n+1));
            System.out.println("Evoluzione finale: "+result);
        }
        else {
            result.append(word.substring(n,n+1));
            System.out.println("Evoluzione in run-time è:  "+result);
            inverti(word,result,n-1);
            
        }
         
   }
    
    public static void concatena(String parola1,int n1,String parola2, int n2,StringBuilder result) {
        if (n1!=parola1.length() && n2!=parola2.length()){
            result.append(parola1.substring(n1,n1+1));
            System.out.println("Il flusso varia 1 "+result);
            concatena(parola1,n1+1,parola2,n2,result);
            
        }
        else if (n1==parola1.length() && n2!=parola2.length()  ){
            result.append(parola2.substring(n2,n2+1));
            System.out.println("Il flusso varia 2 "+result);
            concatena(parola1,n1,parola2,n2+1,result);
            
        }
        else if (n1==parola1.length() && n2==parola2.length()){
            System.out.println("Finito");
        }
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader n1=new BufferedReader(new InputStreamReader(System.in));
        String stringa1=n1.readLine();
        BufferedReader n2=new BufferedReader(new InputStreamReader(System.in));
        String stringa2=n2.readLine();
        StringBuilder risultato= new StringBuilder();
        inverti(stringa1,risultato,stringa1.length()-1);
        String finale=risultato.toString();
        System.out.println("La stringa finale è "+finale);
        StringBuilder risultato2= new StringBuilder();
        concatena(stringa1,0,stringa2,0,risultato2);
        String finale2=risultato2.toString();
        System.out.println("La stringa finale2 è "+finale2);

    }
    
}
