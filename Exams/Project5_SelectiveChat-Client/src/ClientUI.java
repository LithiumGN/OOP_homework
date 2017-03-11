import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientUI extends JFrame implements ActionListener {
	JTextArea msgarea= new JTextArea();
	private JButton invia=new JButton("INVIA");
	private JScrollPane scroll;
	private JTextField msg= new JTextField(30);
	private Socket sock;
	private CoreClient cc;

	public ClientUI() {
		super("Selective Chat Client");
		scroll=new JScrollPane(msgarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		invia.setActionCommand("invia");
		this.setLayout(new BorderLayout());
		JPanel jpl= new JPanel(new FlowLayout());
		jpl.add(msg);
		jpl.add(invia);
		this.add(scroll,BorderLayout.CENTER);
		this.add(jpl, BorderLayout.SOUTH);
		String channel=JOptionPane.showInputDialog("Inserisci il numero del canale");
		msgarea.append("Ti sei unito al canale "+channel+"\n");
		try {
			sock= new Socket("127.0.0.1",3000);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Errore di connessione");
			System.exit(1);
			e.printStackTrace();
		}
		cc= new CoreClient(sock,channel,this);
		Thread t1= new Thread(cc);
		t1.start();
		invia.addActionListener(this);
		this.setVisible(true);
		this.setSize(450,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("invia")){
			cc.invia(msg.getText());
			msg.setText("");
		}
		
	}

}
