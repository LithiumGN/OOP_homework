package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import CoreServer.ClientConnect;
import CoreUI.ClientFrame;

public class MyActionListener implements ActionListener {
	private ClientFrame cf;
	private Socket csock;
	private ClientConnect process;

	public MyActionListener(ClientFrame cf){
		this.cf=cf;
		
	}
	public void actionPerformed(ActionEvent arg0) {
		String AC=arg0.getActionCommand();
		
		if (AC.equals("Start")){
			process= new ClientConnect(csock,cf.matricola.getText());
			Thread t1= new Thread(process);
			t1.start();
			cf.start.setEnabled(false);
			cf.stop.setEnabled(true);
			cf.disconnect.setEnabled(false);
			
			
		}
		
		if(AC.equals("Stop")){
			try {
				process.stop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cf.start.setEnabled(true);
			cf.disconnect.setEnabled(true);
			cf.stop.setEnabled(false);
			
		}
		
		if (AC.equals("Connect")){
			String indirizzo= cf.IP.getText();
			System.out.println("Mi sto per connettere a: "+indirizzo);
			try {
				csock= new Socket("127.0.0.1",Integer.parseInt(cf.port.getText()));
				cf.connect.setEnabled(false);
				cf.disconnect.setEnabled(true);
				cf.start.setEnabled(true);
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Il server non è disponibile");
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "Il server non è disponibile");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Il server non è disponibile");
			}
			
			
		}
		
		if (AC.equals("Disconnect")){
			try {
				process.disconnect();
				csock.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cf.connect.setEnabled(true);
			cf.start.setEnabled(true);
			cf.disconnect.setEnabled(false);
		}
		
		
	}

}
