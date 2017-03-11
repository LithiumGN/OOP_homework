package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import CoreServer.ServerConnect;
import CoreUI.Frame;

public class MyActionListener implements ActionListener{
	public ServerConnect sc;
	private Frame fr;

	public MyActionListener(Frame fr){
		this.fr=fr;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Start")){
			try {
				sc=new ServerConnect();
				Thread t1= new Thread(sc);
				t1.start();
				fr.stop.setEnabled(true);
				fr.start.setEnabled(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		
		if (arg0.getActionCommand().equals("Stop")){
			System.out.println("SPENGO");
			if (sc!=null){
			sc.stop();
			fr.start.setEnabled(true);
			fr.stop.setEnabled(false);
			}
			
			
			
			
		}
		
	}
	

}
