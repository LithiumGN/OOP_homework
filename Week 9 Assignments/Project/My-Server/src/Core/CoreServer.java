package Core;

import java.io.IOException;
import java.net.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class CoreServer implements Runnable {
	private boolean flag=true;
	private static ServerSocket ssock;
	private static List<ClientThread> elenco=null;
	private Socket sock;
	
	public CoreServer(){}
	@Override
	public void run() {
	if (flag==true){
		try {
			elenco=new LinkedList<ClientThread>();
			ssock=new ServerSocket(3000);
			System.out.println("Il server è stato avviato hurray!");
			flag=false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Errore nella creazione del ServerSocket, applicazione dismessa",null,0);
			e.printStackTrace();
		}
		while(true){
			try {
				sock=ssock.accept();
				System.out.println("Abbiamo un nuovo socket"+sock);
			} catch (SocketException e) {
				break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ClientThread cl1 = null;
			try {
				cl1 = new ClientThread(this,sock);
			} catch (IOException e) {
				System.out.println("Errore in ClientThread");
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread t1= new Thread(cl1);
			t1.start();
			addList(cl1);
			System.out.println(elenco);
		}
		
		
	}
		
	}
	
	private void addList(ClientThread ct){
		elenco.add(ct);
		
	}
	static void control(ClientThread e){
		elenco.remove(e);
	}

	
	public synchronized boolean newMessage(String msg){
		Iterator<ClientThread> it = elenco.iterator();
		while(it.hasNext()){
			ClientThread client = it.next();
			client.sendMsg(msg);
		}
		return true;
	}
	
	public void spegniTutto(){
		try {
			if(ssock!=null) ssock.close();
			Iterator<ClientThread> it = elenco.iterator();
			while (it.hasNext()){
				ClientThread client=it.next();
				client.spegni();
			}
		} catch (IOException e ) {
			System.out.println("Chiusare Server Socket fallita");
			e.printStackTrace();
		}
		
	}
}



