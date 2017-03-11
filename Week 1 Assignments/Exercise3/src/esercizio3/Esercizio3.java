/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;
import java.io.*;
import java.util.Scanner;

public class Esercizio3 {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int input=in.nextInt();
            if (input%4==0 && input%100==1){
                System.out.println("E' bisestile");
            }
            else{
                System.out.println("Non è bisestile");
            }
    }
    
}
