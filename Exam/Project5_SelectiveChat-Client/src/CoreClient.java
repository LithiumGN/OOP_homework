import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class CoreClient implements Runnable{
	private Socket sock;
	private ObjectInputStream sc;
	private ObjectOutputStream pw;
	private boolean running=true;
	private boolean first=true;
	private String channel;
	private Object o;
	private ClientUI cu;
	

	public CoreClient(Socket sock, String channel,ClientUI cu) {
		this.sock=sock;
		this.channel=channel;
		this.cu=cu;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		if (first){
			try {
				pw=new ObjectOutputStream(sock.getOutputStream());
				sc=new ObjectInputStream(sock.getInputStream());
				pw.writeObject(channel);
				pw.flush();
				System.out.println("Ho scritto il canale: "+channel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(running){
			try {
				pw.writeObject(new Integer(0));
				pw.flush();
				System.out.println("Inviato polling");
			} catch (IOException e) {
				running=false;
				JOptionPane.showMessageDialog(null, "Errore connessione,applicazione dismessa");
				System.exit(1);
				e.printStackTrace();
			}
			try {
				o=sc.readObject();
			} catch (ClassNotFoundException | IOException e) {
				running=false;
				JOptionPane.showMessageDialog(null, "Errore connessione,applicazione dismessa");
				System.exit(1);
				e.printStackTrace();
			}
			List<String> lis=null;
			if (List.class.isInstance(o)){
				lis= (List<String>)o;
				System.out.println("Ricevuto: "+lis);
				Iterator<String> it= lis.iterator();
				while(it.hasNext()){
					String add=it.next();
					cu.msgarea.append(add+"\n");
				}
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}
	
	public void invia(String text){
		try {
			pw.writeObject(text);
			pw.flush();
			System.out.println("Inviato testo: "+text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
