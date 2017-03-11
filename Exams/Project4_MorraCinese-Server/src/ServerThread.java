import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServerThread implements Runnable {
	private Socket sock1;
	private Socket sock2;
	private ServerSocket ssock;
	private boolean first=true;
	private boolean running=true;
	private List<Match> lis;
	

	public ServerThread() {
		
			
	}


	@Override
	public void run() {
	if (first){
		first=false;
		try {
			ssock=new ServerSocket(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lis=new LinkedList<Match>();
		
	}	
	while (running){

		try {
			System.out.println("Attendo giocatori");
			sock1=ssock.accept();
			System.out.println("Trovato giocatore 1");
			sock2=ssock.accept();
			System.out.println("Trovato giocatore 2");
			Match mt=new Match(this,sock1,sock2);
			lis.add(mt);
			Thread t1=new Thread(mt);
			t1.start();
		} catch (IOException e) {
			running=false;
		}
		
	}
	}


	public void stop() {
		Iterator<Match> it=lis.iterator();
		while(it.hasNext()){
			Match mt2= it.next();
			mt2.stop();
		}
		try {
			ssock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void remove(Match mt){
		System.out.println("Rimuovo :"+mt);
		lis.remove(mt);
	}
}
