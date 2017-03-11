package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Listener.ButtonListener;

public class ServerFrame {
	private JFrame frame;
	private JPanel pnl;
	private JButton start=new JButton ("Start");
	private JButton stop=new JButton ("Stop");
	
public ServerFrame(){
	frame = new JFrame("Server di Leonardo");
	pnl= new JPanel(new FlowLayout());
	frame.add(pnl);
	pnl.add(start);
	pnl.add(stop);
	frame.setVisible(true);
	frame.setSize(300, 80);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	start.setActionCommand("start");
	stop.setActionCommand("stop");
	frame.setLocationRelativeTo(null);
	start.addActionListener(new ButtonListener(start,stop,frame));
	stop.addActionListener(new ButtonListener(start,stop,frame));
	stop.setEnabled(false);
	frame.setResizable(false);


}
	

}
