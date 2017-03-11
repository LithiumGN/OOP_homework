import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyActionListener implements ActionListener{
	private MyFrame frm;
	public final String MOSTRA = "mostra";
	public final String CANCEL = "cancel";
	
	
	MyActionListener(MyFrame frame) {
		this.frm = frame;
		}
	
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com == MOSTRA){
			//Definisco il caso del trigger "Mostra"
			System.out.println("Va bene");
			char[] in = frm.pass.getPassword();
			String input = new String(in);
			frm.testo.append(input);
			JOptionPane.showMessageDialog(frm, "Huge success! Hai inserito: "+input);
		}
		else if (com==CANCEL){
			//Definisco il trigger "cancel"
			int confirm= JOptionPane.showConfirmDialog(null,"Cancellare il codice inserito?", "Conferma",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (confirm==0){
			MyFrame.pass.setText("");
			frm.testo.setText("");
			}
		}
		
		else {
			//Definisco tutti gli altri trigger per i numeri
			char[] ins=frm.pass.getPassword();
			String input = new String(ins);
			MyFrame.pass.setText(input+com);
		}
	}
}


