
package esercitazione3;

import java.io.PrintStream;
import java.io.PrintWriter;

public class Insegnante {
    private final String nome;
    private final String cognome;
    private final int AnnoVincita;
    public Scuola ScuolaIns;
    
    
    public Insegnante(String nome,String cognome,int AnnoVincita, Scuola ScuolaIns){
        this.nome=nome;
        this.cognome=cognome;
        this.AnnoVincita=AnnoVincita;
        this.ScuolaIns=ScuolaIns;
    }
    public String leggiNome(){
        return nome;
    }
    public String leggiCognome(){
        return cognome;
    }
    public int leggiAnno(){
        return AnnoVincita;
    }
    public Scuola leggiScuola(){
        return ScuolaIns;
    }
    public void setScuola(Scuola nuovascuola){
        ScuolaIns=nuovascuola;
    }
    public void setNewScuola(String nome,String indirizzo, String provveditorato){
        ScuolaIns= new Scuola(nome,indirizzo,provveditorato);
    }
    
    public void stampaIns(PrintStream out){
        out.println("L'insegnante "+nome+" "+cognome+ " ed ha vinto il bando dell'anno "+AnnoVincita);
        out.print("Attualmente si trova alla scuola: "+ ScuolaIns.legginome() );
    }


    
}
