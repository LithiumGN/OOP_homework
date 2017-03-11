
public class E1_1 {

	/*
	 * Scrivere un programma Java che date due stringhe in input stampi true se
	 * una stringa è contenuta nell'altra, false altrimenti
	 */

	public static void main(String[] args) {
		String x = "mare";
		String y = "porto";
		
		System.out.println(x.contains(y) || y.contains(x));
		
    }
}