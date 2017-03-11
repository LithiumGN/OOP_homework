package CoreUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listener.MyActionListener;

public class ClientFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3336803060750482797L;
	public  JButton start=new JButton("Start");
	public JButton stop=new JButton("Stop");
	public JButton connect=new JButton("Connect!");
	public JButton disconnect=new JButton("Disconnect");
	public JTextField matricola= new JTextField("99999");
	public JTextField IP= new JTextField("127.0.0.1");
	public JTextField port= new JTextField("3000");
	
public ClientFrame(){
	super("Project Core-Client");
	this.setVisible(true);
	MyActionListener listener = new MyActionListener(this);
	this.setLayout(new BorderLayout());
	JPanel testi=new JPanel(new GridLayout(4,4));
	testi.add(new JLabel("Matricola"));
	testi.add(new JLabel("IP Address"));
	testi.add(matricola);
	testi.add(IP);
	testi.add(new JLabel("Porta")); 
	testi.add(new JLabel()); //BLANK SPACE
	testi.add(port);
	
	JPanel buttons= new JPanel(new FlowLayout());
	buttons.add(connect);
	buttons.add(disconnect);
	buttons.add(start);
	buttons.add(stop);
	connect.setActionCommand("Connect");
	start.setActionCommand("Start");
	stop.setActionCommand("Stop");
	disconnect.setActionCommand("Disconnect");
	connect.addActionListener(listener);
	start.addActionListener(listener);
	stop.addActionListener(listener);
	disconnect.addActionListener(listener);
	
	this.add(testi,BorderLayout.CENTER);
	this.add(buttons,BorderLayout.SOUTH);
	this.setSize(400,150);
	this.setResizable(false);
	stop.setEnabled(false);
	disconnect.setEnabled(false);
	start.setEnabled(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
}
}
