/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione3;

import java.io.*;

public class classe {
    private final Scuola ScuolaClasse;
    private final String nome;
    public Insegnante DocenteClasse;
    public int numAlunni;
    
    public classe(Scuola ScuolaClasse, String nome, Insegnante DocenteClasse, int alunni){
        this.ScuolaClasse=ScuolaClasse;
        this.nome=nome;
        this.DocenteClasse=DocenteClasse;
        this.numAlunni=alunni;
    }
    public Scuola leggiScuola(){
        return ScuolaClasse;
    }
    public String leggiNome(){
        return nome;
    }
    public Insegnante leggiInsegnante(){
        return DocenteClasse;
    }
    public int leggiNumAlunni(){
        return numAlunni;
    }
    public void setInsegnante(Insegnante Docente){
        this.DocenteClasse=Docente;
    }
    public void setNewInsegnante(String nome, String cognome,int anno, Scuola ScuolaIns){
        this.DocenteClasse=new Insegnante(nome,cognome,anno, ScuolaIns);
    }
    public void setNumero(int num){
        this.numAlunni=num;
    }
    public void stampaClasse(PrintStream out){
        out.println("La classe ha "+numAlunni+" alunni ed è locata a:");
        ScuolaClasse.stampaScuola(out);
        out.println("Il nome della classe è: \n"+nome);
        out.println("Il docente è: \n "); DocenteClasse.stampaIns(out);
        out.flush();
    }
}
