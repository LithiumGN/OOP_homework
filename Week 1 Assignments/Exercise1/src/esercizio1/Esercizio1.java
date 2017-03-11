
package esercizio1;
import java.io.*;

public class Esercizio1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        String first=r.readLine();
        BufferedReader s= new BufferedReader(new InputStreamReader(System.in));
        String second=s.readLine();
        Boolean final1=second.contains(first);
        Boolean final2=first.contains(second);
        if (final1==true||final2==true){
            System.out.println("Una delle due è sottostringa");
        }
        else {
            System.out.println("No sottostringhe");
        }
           
      
    }
    
}
