/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione3;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author biar
 */
public class Scuola {
    private final String nome;
    private final String indirizzo;
    private final String provveditorato;
    
    public Scuola(String nome,String indirizzo, String provveditorato){ //COSTRUTTORE
        this.nome=nome;
        this.indirizzo=indirizzo;
        this.provveditorato=provveditorato;
    }
    public String legginome(){
        return nome;
    }
    public String leggiIndirizzo(){
        return indirizzo;
        
    }
    public String leggiProvveditorato(){
        return provveditorato;
    }
    public void stampaScuola(PrintStream out){
        out.println("La Scuola è "+nome+ " attualmente locata a "+indirizzo+" del Provveditorato n."+provveditorato);
        out.flush();
}
    
           
    
}
