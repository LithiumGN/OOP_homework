package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CoreUI.CoreUI;
import Threads.ServerConnect;

public class AListener implements ActionListener{
	private CoreUI cu;
	private ServerConnect sc;
	
	public AListener(CoreUI cu){
		this.cu=cu;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Start")){
			sc= new ServerConnect();
			Thread t1= new Thread(sc);
			t1.start();
			cu.start.setEnabled(false);
			cu.stop.setEnabled(true);

		}
		
		if (arg0.getActionCommand().equals("Stop")){
			sc.stop();
			cu.start.setEnabled(true);
			cu.stop.setEnabled(false);
		}
		
	}

}
