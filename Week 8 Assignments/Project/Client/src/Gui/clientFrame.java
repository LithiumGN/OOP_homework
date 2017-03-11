package Gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Listener.MyActionListener;


public class clientFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String titolo = "Client Chat";
	private static final JButton uno = new JButton ("Invia");
	public JTextArea Scrittura=new JTextArea(3,50);
	public JTextArea Testo=new JTextArea();
	private static final JPanel southPnl =new JPanel(new FlowLayout());
	private JScrollPane sp = new JScrollPane(Testo);
	private JScrollPane mp = new JScrollPane(this.Scrittura);
	public String dainviare="";
	public final String name;


	
	
public clientFrame(){	
	
	name=JOptionPane.showInputDialog ( "Insert your name" ); 
	super.setTitle(titolo);
	Scrittura.setText("Ciao");
	this.setResizable(false);
	Container frmContentPane = this.getContentPane();
	
	//Configuro gli AC
	uno.setActionCommand("Invia");
	
	//Aggiungo elementi a ContentPane
	frmContentPane.setLayout(new BorderLayout());

	southPnl.add(mp);
	southPnl.add(uno);
	frmContentPane.add(southPnl, BorderLayout.SOUTH);
	frmContentPane.add(sp, BorderLayout.CENTER);
	
	
	
	//Aggiungo ActionListener
	uno.addActionListener(new MyActionListener(this));
	
	
	//Proprietà
	Testo.setPreferredSize( new Dimension( 500, 300 ) );
	Scrittura.setSize(new Dimension(500,100));
	Scrittura.setLineWrap(true);
	Scrittura.setWrapStyleWord(true);
	Testo.setLineWrap(true);
	Testo.setEditable(false);
	Testo.setWrapStyleWord(true);

	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(500,600);
	this.setLocationRelativeTo(null);
	this.pack();
	

}
}