package CoreServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import CoreUI.ServerUI;

public class ServerManager implements Runnable {
	private ServerSocket ssock;
	private boolean first=true;
	private boolean running=true;
	private Socket sock;
	private List<ServerConnect> lis;
	private DBTeatro db;
	private ServerUI su;
	public ServerManager(DBTeatro db, ServerUI su) {
		this.db=db;
		this.su=su;
	}



		
	
	@Override
	public void run() {
		if(first){
			first=false;
			try {
				ssock=new ServerSocket(3000);
			} catch (IOException e) {
				System.out.println("SERVER GIA' AVVIATO");
				JOptionPane.showMessageDialog(null, "Server già in esecuzione");
				su.start.setEnabled(true);
				running=false;
				
			}
			lis=new LinkedList();
			System.out.println("Server avviato");
		}
		while (running){
			System.out.println("In attesa client");
			try {
				sock = ssock.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Server chiuso");
			}
			ServerConnect sc= new ServerConnect(this,sock,db);
			Thread t1=new Thread(sc);
			t1.start();
		}
		
		
	}
	
	public void removeList(ServerConnect sc){
		System.out.println("Rimuovo: "+sc);
		lis.remove(sc);
	}
	
	public void stop(){
		running=false;
		Iterator<ServerConnect> it= lis.iterator();
		while (it.hasNext()){
			ServerConnect sc2=it.next();
			sc2.stop();
		}
		try {
			ssock.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
