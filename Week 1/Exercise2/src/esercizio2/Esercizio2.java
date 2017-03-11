package esercizio2;
import java.io.*;
public class Esercizio2 {

    public static void main(String[] args) throws IOException {
        BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
        String input=r.readLine();
        String finale= "";
        if (input==null){
            System.out.println("L'input è vuoto");
        }
        else{
            for (int i=0;i<input.length();i++){
                if (i%2!=0){
                    finale=finale.concat((input.substring(i,i+1)).toUpperCase());
                }
                else{
                  
                    finale=finale.concat(input.substring(i,i+1));
                }
            }
        System.out.println("il risultato è  "+finale);
        }
    }
    
}
