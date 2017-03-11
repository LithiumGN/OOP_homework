package Threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServerConnect implements Runnable {
	
	private boolean first=true;
	private Socket sock;
	private ServerSocket ssock;
	private boolean running=false;
	private List<CoreServer> lis=null;
	
	
	public ServerConnect(){
		
	}


	@Override
	public void run() {
		if (first){
			try {
				ssock= new ServerSocket(3000);
				first=false;
				running=true;
				lis= new LinkedList<CoreServer>();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		while (running){
			System.out.println("Waiting client");
			try {
				sock=ssock.accept();
			} catch (IOException e) {

				e.printStackTrace();
			}
			System.out.println("Found one client");
			CoreServer cs= new CoreServer(sock,this);
			Thread t1= new Thread(cs);
			t1.start();
			lis.add(cs);

		}
		
	}
	
	public void readyToSend(String text){
		Iterator<CoreServer> it= lis.iterator();
		while (it.hasNext()){
			CoreServer cs1= it.next();
			cs1.addMsg(text);
		}
		
	}
	public void stop(){
		running=false;
		Iterator<CoreServer> it= lis.iterator();
		while (it.hasNext()){
			CoreServer cs1= it.next();
			cs1.stop();
			lis.remove(cs1);
			
		}
		try {
			ssock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void remove(CoreServer cs){
		System.out.println("Removing: "+cs);
		lis.remove(cs);
	}

}
