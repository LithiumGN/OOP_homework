
public class E1_5 {

	public static void main(String[] args) {
		
		/* Scrivere un programma Java che date due stringhe, 
           stampi il rapporto tra le lunghezze delle stringhe stesse.
		 * N.B. input1 = "lessie", input2 = "rex" il risultato deve essere 2, 
                input1 = "rex", input2 = "lessie" il risultato deve essere 0.5*/
		
        String num = "tre";
		String den = "cinque";
		
		int lenNum = num.length();
		int lenDen = den.length();
		
		System.out.println((double)lenNum / (double)lenDen);
	}

}
