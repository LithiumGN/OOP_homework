package CoreUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import CoreServer.DBTeatro;
import MyListener.MyListener;
import MyListener.WListener;

public class ServerUI extends JFrame {
	public JButton start= new JButton("START");
	public JButton stop= new JButton("STOP");
	private DBTeatro db;

	public ServerUI() {
		super("Server Teatro");
		db=new DBTeatro();
		this.setLayout(new FlowLayout());
		start.setActionCommand("Start");
		stop.setActionCommand("Stop");
		this.add(start);
		this.add(stop);
		this.setSize(200,100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		MyListener ml= new MyListener(this,db);
		start.addActionListener(ml);
		stop.addActionListener(ml);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WListener());
	}

}
