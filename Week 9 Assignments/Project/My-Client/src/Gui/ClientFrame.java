package Gui;
import Listener.InvioListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import CorePolling.CorePolling;


@SuppressWarnings("serial")
public class ClientFrame extends JFrame{
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket sock = null;
	
	private JScrollPane centralPanel;
	private JPanel southPanel;
	private JTextArea messagesArea;
	private JButton invio; 
	private JTextField textMessage;
	private String name=null;
	
	public ClientFrame(){
		name = JOptionPane.showInputDialog("Username:");
		if(name == null){
			JOptionPane.showMessageDialog(null, "Necessario indicare un username.");
			System.exit(0);
		}
		try {
			setupConnection();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Impossibile stabilire una connessione con il server");
			System.exit(1);
		}
		
		this.setTitle("Messagistica");
		Container mainContainer = this.getContentPane();
		
		
		southPanel = new JPanel();
		
		messagesArea = new JTextArea(25,50);
		messagesArea.setEditable(false);
		
		centralPanel = new JScrollPane(messagesArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textMessage = new JTextField(50);
		invio = new JButton("Invia");
		
		southPanel.add(textMessage);
		southPanel.add(invio);
		invio.addActionListener(new InvioListener(textMessage,oos));
		
		mainContainer.add(centralPanel, BorderLayout.CENTER);
		mainContainer.add(southPanel, BorderLayout.SOUTH);
		
		setLocation(200,100);
		
	    CorePolling p = new CorePolling(messagesArea, oos, ois);
	    Thread t = new Thread(p);
	    t.start();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
		
	}


	private void setupConnection() throws UnknownHostException, IOException {
		sock= new Socket("127.0.0.1",3000);
		InputStream in = sock.getInputStream();
		OutputStream os = sock.getOutputStream();
		oos = new ObjectOutputStream(os);
		ois = new ObjectInputStream(in);
		oos.writeObject(name);
		oos.flush();


	}	
}
