package CoreUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Listener.MyActionListener;
import Listener.WListener;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton start=new JButton("START");
	public JButton stop=new JButton("STOP");
	public MyActionListener mal;
	
	
	public Frame(){
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.add(start);
		start.setActionCommand("Start");
		stop.setActionCommand("Stop");
		mal= new MyActionListener(this);
		start.addActionListener(mal);
		stop.addActionListener(mal);
		this.add(stop);
		this.setSize(200, 100);
		stop.setEnabled(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		WListener wl= new WListener(mal);
		this.addWindowListener(wl);

		
	}
	

}
