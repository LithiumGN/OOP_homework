import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ClientUI extends JFrame implements ActionListener{
	private JButton sasso;
	private JButton carta;
	private JButton forbici;
	private JButton connect;
	JButton disconnect;
	private Socket sock;
	private CoreClient cc;
	public JLabel jl= new JLabel("Sei il giocatore: NON PERVENUTO");
	private Set<JButton> but= new HashSet<JButton>();
	public ClientUI() {
		super("Sasso carta forbici");
		sasso=new JButton("Sasso");
		carta=new JButton("Carta");
		forbici=new JButton("Forbici");
		connect=new JButton("Connect");
		sasso.setActionCommand("sasso");
		carta.setActionCommand("carta");
		forbici.setActionCommand("forbici");
		connect.setActionCommand("connect");
		sasso.addActionListener(this);
		carta.addActionListener(this);
		forbici.addActionListener(this);
		connect.addActionListener(this);
		but.add(sasso);
		but.add(carta);
		but.add(forbici);
		disconnect= new JButton("Disconnect");
		disconnect.setActionCommand("disconnect");
		disconnect.addActionListener(this);
		
		sasso.setEnabled(false);
		forbici.setEnabled(false);
		carta.setEnabled(false);
		disconnect.setEnabled(false);
		this.setLayout(new FlowLayout());
		this.add(sasso);
		this.add(carta);
		this.add(forbici);
		this.add(connect);
		this.add(disconnect);
		this.add(jl);
		this.setSize(300,110);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("connect")){
			try {
				System.out.println("Hai premuto:" +arg0.getActionCommand());
				sock=new Socket("127.0.0.1",3000);
				cc= new CoreClient(sock,this);
				connect.setEnabled(false);
				Thread t1= new Thread(cc);
				t1.start();
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Server non disponibile");
				e.printStackTrace();
			}
			
			
		}
		else if(arg0.getActionCommand().equals("disconnect")){
			System.out.println("Hai premuto:" +arg0.getActionCommand());
			disconnect.setEnabled(false);
			connect.setEnabled(true);
			
			cc.invia("bye"+"\n");
			disableAll();
			
			
		}
		
		
		else {
			System.out.println("Hai premuto:" +arg0.getActionCommand());
			JButton premuto=(JButton)arg0.getSource();
			Iterator<JButton> it= but.iterator();
			while(it.hasNext()){
				JButton jb= it.next();
				jb.setEnabled(false);
			}
			String dainviare=arg0.getActionCommand();
			cc.invia(dainviare+"\n");
		}
		
	}
	
	public void enableAll(){
		Iterator<JButton> it= but.iterator();
		while(it.hasNext()){
			JButton jb= it.next();
			jb.setEnabled(true);
		}
		
	}
	public void disableAll(){
		Iterator<JButton> it= but.iterator();
		while(it.hasNext()){
			JButton jb= it.next();
			jb.setEnabled(false);
		}
		
	}


}
