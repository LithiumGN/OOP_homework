package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CoreServer.DBTeatro;
import CoreServer.ServerManager;
import CoreUI.ServerUI;

public class MyListener implements ActionListener {
	private ServerUI su;
	private DBTeatro db;
	private ServerManager sm;
	public MyListener(ServerUI su, DBTeatro db) {
		this.su=su;
		this.db=db;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Start")){
			su.start.setEnabled(false);
			su.stop.setEnabled(true);
			sm= new ServerManager(db,su);
			Thread t1= new Thread(sm);
			t1.start();

			
			
		}
		
		if (arg0.getActionCommand().equals("Stop")){
			sm.stop();
			su.start.setEnabled(true);
			su.stop.setEnabled(false);
			
			
		}
		
	}

}
