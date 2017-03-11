import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ServerUI extends JFrame implements ActionListener {
	private JButton start= new JButton("Start");
	private JButton stop=new JButton("Stop");
	private ServerManager sm;

	public ServerUI() {
		super("Selective Server");
		this.setLayout(new FlowLayout());
		this.add(start);
		this.add(stop);
		start.setActionCommand("start");
		stop.setActionCommand("stop");
		start.addActionListener(this);
		stop.addActionListener(this);
		this.setVisible(true);
		this.setSize(170, 90);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		stop.setEnabled(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("start")){
			sm=new ServerManager();
			Thread t2= new Thread(sm);
			t2.start();
			start.setEnabled(false);
			stop.setEnabled(true);
			}
		
		if (arg0.getActionCommand().equals("stop")){
			sm.stop();
			start.setEnabled(true);
			stop.setEnabled(false);
		}
		
	}

}
