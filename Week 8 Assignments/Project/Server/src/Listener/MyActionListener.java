package Listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Gui.serverFrame;
import Server.ServerChat;


public class MyActionListener implements ActionListener{
	private static serverFrame sfrm;
	public final String INVIA = "Invia";
	public final String START = "Start";
	public final String STOP = "Stop";
	
	

	public MyActionListener(serverFrame frame){
		this.sfrm=frame;
	}
	MyActionListener(){
		
		
	}
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand(); 
		if (com == START){
			try {

				Thread nuovo= new Thread(new ServerChat());
				nuovo.start();
				sfrm.uno.setEnabled(false); 
				sfrm.due.setEnabled(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
					}
		else{
			try {
				serverFrame.uno.setEnabled(true); 
				ServerChat.sendtoAll("HALT");
				ServerChat.close();
				serverFrame.due.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		}
}

