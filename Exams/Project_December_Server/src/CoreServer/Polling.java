package CoreServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Polling implements Runnable {
	private Socket sock;
	private PrintWriter pos;
	private boolean running=true;
	private String tot="";
	private boolean codice=false;
	
	public Polling(Socket sock, PrintWriter pos){
		this.sock=sock;
		this.pos=pos;
	}
	
	@Override
	public void run() {
		
		while (running){
			System.out.println("AVVIATO POLLING");
			int num= (int) (Math.random()*2);
			StringBuilder sb= new StringBuilder();
			sb.append(num);
			String dainviare=sb.toString();
			System.out.println("Sto per inviare: "+dainviare);
			tot=tot.concat(dainviare);
			pos.write(dainviare+"\n");
			pos.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (running==false && codice){
			int dainviare2=tot.hashCode();
			System.out.println("HASHCODE DI: "+tot);
			pos.write("*"+"\n");
			pos.write("*"+"\n");
			pos.write("*"+"\n");
			pos.write(dainviare2+"\n");
			pos.write("stop"+"\n");
			pos.flush();
		}
		
		
		
	}
	
	public void stop(){
		running=false;
		codice=true;
	}
	public void softstop(){
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running=false;
	}

}
