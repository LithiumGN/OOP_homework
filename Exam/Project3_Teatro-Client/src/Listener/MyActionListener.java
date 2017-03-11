package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientUI.ClientFrame;
import CoreClient.CoreClient;


public class MyActionListener implements ActionListener {
	private ClientFrame cf;
	private CoreClient cc;
	
	public MyActionListener(ClientFrame cf){
		this.cf=cf;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Start")){
			cc=new CoreClient(cf.nome.getText(),cf.cognome.getText(),cf.posto.getText());
			Thread t1= new Thread(cc);
			t1.start();
			
			
			
			
			
		}
		
	}

}
