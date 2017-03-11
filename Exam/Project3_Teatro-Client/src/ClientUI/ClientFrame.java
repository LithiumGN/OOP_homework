package ClientUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listener.MyActionListener;

public class ClientFrame extends JFrame{
	public JTextField nome=new JTextField();
	public JTextField cognome=new JTextField();
	public JTextField posto=new JTextField();
	public JButton invia= new JButton("INVIA");
	
	
	public ClientFrame(){
		super("Progetto: Client Teatro");
		this.setLayout(new BorderLayout());
		JPanel pnl= new JPanel(new GridLayout(6,1));
		this.setVisible(true);
		pnl.add(new JLabel("NOME:"));
		pnl.add(nome);
		pnl.add(new JLabel("COGNOME:"));
		pnl.add(cognome);
		pnl.add(new JLabel("POSTO:"));
		pnl.add(posto);
		this.add(pnl,BorderLayout.CENTER);
		this.add(invia, BorderLayout.SOUTH);
		this.setSize(300,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		MyActionListener mal= new MyActionListener(this);
		invia.setActionCommand("Start");
		invia.addActionListener(mal);
		
		
		
		
		
	}
	
	

}
