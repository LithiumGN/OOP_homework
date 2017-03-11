import javax.swing.JOptionPane;

public class E1_4 {

	public static void main(String[] args) {

		/*
		 * Scrivere un programma Java che calcoli l'area di un triangolo. Il
		 * programma deve chiedere in input all'utente due interi rappresentanti
		 * la base e l'altezza del triangolo e deve scrivere il risultato in una
		 * finestra di output.
		 */
		
		int base = Integer.parseInt(JOptionPane.showInputDialog("Inserire il valore della base: "));
		int altezza = Integer.parseInt(JOptionPane.showInputDialog("Inserire il valore dell'altezza: "));
		
		double area = ((double)base) * altezza / 2;
		
		JOptionPane.showMessageDialog(null, "Il valore dell'area è: \n"+area);

	}

}
