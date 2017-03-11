package CoreServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class ServerConnect implements Runnable {
	
	private ServerSocket ssock;
	private boolean flag = false;
	private List<ClientThread> l = null;
	
	public ServerConnect() throws IOException{
		
	}

	@Override
	public void run() {
		if(!flag){
			flag = true;
			l=new LinkedList<ClientThread>();
			try {
				ssock = new ServerSocket(3000);
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Errore nella creazione del ServerSocket, applicazione dismessa",null,0);
				System.exit(1);
			}
			System.out.println("Server Avviato");
		}
		
		while(true){
			Socket sock;
			try {
				System.out.println("In attesa di utente");
				sock = ssock.accept();
				System.out.println("Trovato utente");
				ClientThread ct= new ClientThread(sock,this);
				Thread tr = new Thread(ct);
				tr.start();
				l.add(ct);
			} catch (IOException e) {
				break;

				
			}

			

		}
	}
	public void remove(ClientThread ct){
		l.remove(ct);
	}
	
	public void stop(){
		Iterator<ClientThread> it=l.iterator();
		while(it.hasNext()){
			ClientThread ct2=it.next();
			ct2.stop();
		}
		try {
			ssock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
