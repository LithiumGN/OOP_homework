package CoreUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ClientConnect.ClientConnect;
import Listener.MyActionListener;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {
	
	private JButton invia= new JButton("INVIA");
	public JTextArea history= new JTextArea();
	public JTextField msg = new JTextField(40);
	public Socket sock;
	
	public ClientFrame(){
		super("Progetto: Client Chat");
		String nome=JOptionPane.showInputDialog("Inserisci il tuo nome utente: ");
		this.setLayout(new BorderLayout());
		
		JPanel jpl = new JPanel(new FlowLayout());
		jpl.add(msg);
		jpl.add(invia);
		this.add(jpl, BorderLayout.SOUTH);
		this.setVisible(true);
		JScrollPane scroll = new JScrollPane (history);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll,BorderLayout.CENTER);
		this.setSize(550,400);
		invia.setActionCommand("Invia");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


		try {
			sock= new Socket("127.0.0.1",3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Errore di connessione con il server");
			System.exit(1);
		}
		ClientConnect cc= new ClientConnect(sock,this,nome);
		Thread t1= new Thread (cc);
		t1.start();
		MyActionListener mal= new MyActionListener(this,cc);
		invia.addActionListener(mal);
		this.setLocationRelativeTo(null);
		
		
		
		
		
		
		
		
		
	}
	
}
