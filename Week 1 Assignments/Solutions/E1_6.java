import javax.swing.JOptionPane;

public class E1_6 {

	public static void main(String[] args) {
		
		/* Scrivere un programma Java che chieda in input all'utente due stringhe, 
         * e stampi la stringa che abbia la somma
		 * dei codici ASCII delle proprie lettere maggiore e il valore di tale somma.
		 * Esempio: se le stringhe passate sono "aaa" e "aab" il programma deve stampare "aab 292"*/
		
        String s1  = JOptionPane.showInputDialog("Inserire la prima stringa:");
		String s2 = JOptionPane.showInputDialog("Inserire la seconda stringa:");
		
		int v1 = 0;
		
		for(int i = 0; i < s1.length();i++){
			v1 = v1 + s1.charAt(i);
		}
		
		int v2 = 0;
		
		for(int i = 0; i < s2.length();i++){
			v2 = v2 + s2.charAt(i);
		}
		
		if(v1 > v2){
			JOptionPane.showMessageDialog(null, s1+" "+v1);
		}else{
			JOptionPane.showMessageDialog(null, s2+" "+v2);
		}
	}

}
