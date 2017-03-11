package Gui;

import Listener.*;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Listener.MyActionListener;

public class serverFrame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String titolo = "Sever Chat";
	public static final JButton uno = new JButton ("Start");
	public static final JButton due = new JButton ("Stop");

	
	
public serverFrame(){	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		super.setTitle(titolo);
		Container frmContentPane = this.getContentPane();
		frmContentPane.setLayout(new FlowLayout());
		
		//Configuro gli AC
		uno.setActionCommand("Start");
		due.setActionCommand("Stop");
		
		//Aggiungo elementi a ContentPane
		frmContentPane.setLayout(new FlowLayout());
		frmContentPane.add(uno);
		frmContentPane.add(due);
		
		//Aggiungo ActionListener
		uno.addActionListener(new MyActionListener(this));
		due.addActionListener(new MyActionListener(this));
		
		
		//Proprietà
		serverFrame.due.setEnabled(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,100);
		this.setLocationRelativeTo(null);
		

	}


		
	}
	

