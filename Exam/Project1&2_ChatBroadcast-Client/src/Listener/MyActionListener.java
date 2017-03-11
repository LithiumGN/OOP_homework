package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientConnect.ClientConnect;
import CoreUI.ClientFrame;

public class MyActionListener implements ActionListener {
	private ClientFrame cf;
	private String dainviare;
	private ClientConnect cc;
	
	public MyActionListener(ClientFrame cf,ClientConnect cc){
		this.cf=cf;
		this.cc=cc;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Invia")){
			dainviare=cf.msg.getText();
			System.out.println("You wrote: "+dainviare);
			if (!dainviare.equals("")){
				cc.send(dainviare);
				cf.msg.setText("");
				
			}

			
			
			
			
		}
		
	}

}
