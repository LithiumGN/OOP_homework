package CoreUI;
import java.awt.FlowLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Listener.AListener;

public class CoreUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton start= new JButton("START");
	public JButton stop= new JButton("STOP");
	
	
	public CoreUI(){
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.add(start);
		this.add(stop);
		AListener al= new AListener(this);
		start.addActionListener(al);
		stop.addActionListener(al);
		start.setActionCommand("Start");
		stop.setActionCommand("Stop");
		this.setSize(200, 100);
		this.setLocationRelativeTo(null);
		stop.setEnabled(false);
		try {
			System.out.println(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
