import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ServerUI extends JFrame implements ActionListener {
	private JButton start;
	private JButton stop;
	private ServerThread st;
	public ServerUI() {
		start= new JButton("Start");
		stop=new JButton("Stop");
		start.setActionCommand("Start");
		stop.setActionCommand("Stop");
		start.addActionListener(this);
		stop.addActionListener(this);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(150, 100);
		this.setLayout(new FlowLayout());
		this.add(start);
		this.add(stop);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		stop.setEnabled(false);
		this.setResizable(false);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Start")){
			st= new ServerThread();
			Thread t1= new Thread(st);
			start.setEnabled(false);
			stop.setEnabled(true);
			t1.start();
			}
			
		
		
		if (arg0.getActionCommand().equals("Stop")){
			st.stop();
			start.setEnabled(true);
			stop.setEnabled(false);
			
			
		}
		
	}

}
