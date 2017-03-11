package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Core.CoreServer;

public class ButtonListener implements ActionListener {
	private JButton start;
	private JButton stop;
	private CoreServer serverino;
	public ButtonListener(JButton start, JButton stop, JFrame frm){
		this.start=start;
		this.stop=stop;
		serverino=new CoreServer();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="start"){		
			Thread t1=new Thread(serverino);
			t1.start();
			
			start.setEnabled(false);
			stop.setEnabled(true);
			
			
		}
		
		if (e.getActionCommand()=="stop") {
			serverino.spegniTutto();
			start.setEnabled(true);
			stop.setEnabled(false);
			
			
			
		}
		
		
	}
	
	

}
