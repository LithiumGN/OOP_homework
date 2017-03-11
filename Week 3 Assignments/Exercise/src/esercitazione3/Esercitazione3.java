/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione3;

public class Esercitazione3 {

    public static void main(String[] args) {
        Scuola Avogadro= new Scuola("Liceo avogadro","Via Brenta", "0000F");
        Avogadro.stampaScuola(System.out);
        System.out.println("FINITO TEST SCUOLA");
        Insegnante Silvestri= new Insegnante("Paolina","Silvestri",1980,Avogadro);
        Silvestri.stampaIns(System.out);
        System.out.println("\nFINITO TEST INSEGNANTE");
        classe VH= new classe (Avogadro,"VH",Silvestri,24);
        VH.stampaClasse(System.out);
        System.out.println("\n FINITO TEST CLASSE");
        
    }
    
}
