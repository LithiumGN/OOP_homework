package Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.clientFrame;

public class MyActionListener implements ActionListener{
	private clientFrame frm;
	public final String INVIA = "Invia";
	public final String START = "Start";
	public final String STOP = "Stop";
	
	
	public MyActionListener(clientFrame frame) {
		this.frm = frame;
		}
	public MyActionListener(){
		
		
	}
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com == INVIA){
			String output= frm.Scrittura.getText();
			frm.dainviare=output;
			frm.Scrittura.setText("");
			}
		
		}
			
			
	}


