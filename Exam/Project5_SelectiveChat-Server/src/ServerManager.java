import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ServerManager implements Runnable {
	private Socket sock;
	private ServerSocket ssock;
	private boolean first=true;
	private boolean running=true;
	private List<CoreServer> lis;
	private Map<String,List<CoreServer>> selective;
	@SuppressWarnings("unused")
	private Scanner sc;
	

	public ServerManager() {
		
	}

	@Override
	public void run() {
		if (first){
			first=false;
			try {
				ssock= new ServerSocket(3000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lis=new LinkedList<CoreServer>();
			selective=new HashMap<String,List<CoreServer>>();
		}
		
		while (running){
			System.out.println("Aspetto client");
			try {
				sock=ssock.accept();
				System.out.println("Trovato client");
			} catch (IOException e) {
				running=false;

			}
			CoreServer cs= new CoreServer(sock,this);
			Thread t1= new Thread(cs);
			t1.start();
			lis.add(cs);
			
		}
		
	}

	public void readyToSend(String o, String channel) {
		System.out.println("trovato msg di client appartenente a: "+channel);
		List<CoreServer> lista_selective= selective.get(channel);
		Iterator<CoreServer> it=lista_selective.iterator();
		while(it.hasNext()){
			CoreServer cs1=it.next();
			cs1.addMsg(o);
		}
		
	}
	
	public void addSelective(String channel,CoreServer core){
		System.out.println("Aggiungo... "+channel);
		if(selective.containsKey(channel)){
			List<CoreServer> lista=selective.get(channel);
			lista.add(core);
		}
		else{
			List<CoreServer> lista= new LinkedList<CoreServer>();
			lista.add(core);
			selective.put(channel, lista);
		}
	}
	
	public void stop(){
		Iterator<CoreServer> it= lis.iterator();
		while (it.hasNext()){
			CoreServer core1=it.next();
			core1.stop();
			
		}
		try {
			ssock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lis.clear();
		selective.clear();
	}
	
	public void remove(CoreServer cs, String channel){
		lis.remove(cs);
		List<CoreServer> lis2=selective.get(channel);
		lis2.remove(cs);
	}
	public void remove(CoreServer cs){
		lis.remove(cs);
		
	}
	

}

