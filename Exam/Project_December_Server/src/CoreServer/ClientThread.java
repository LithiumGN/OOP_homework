package CoreServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientThread implements Runnable {
	private Socket sock;
	private ServerConnect sc;
	private InputStream is;
	private OutputStream os;
	private Scanner sis;
	private PrintWriter pos;
	private boolean running=true;
	@SuppressWarnings("unused")
	private String tot;
	private Polling pg;
	private String ricevuto;
	
	public ClientThread(Socket s, ServerConnect sc){
		sock=s;
		this.sc=sc;
	}

	public void run() {
		tot="";
		try {
			is=sock.getInputStream();
			os=sock.getOutputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		sis=new Scanner(is);
		pos= new PrintWriter(os);
		
		while(running){
			System.out.println("Entro dentro il ciclo");
			try{
				ricevuto=sis.nextLine();
				if (ricevuto.equals("start")){
					System.out.println("trovato start");
					pg= new Polling(sock,pos);
					Thread t2= new Thread(pg);
					t2.start();
				}
				if (ricevuto.equals("stop")){
					System.out.println("trovato stop");
					pg.stop();
				}
			}
			catch (NoSuchElementException e){
				pg.softstop();
				running=false;
				sc.remove(this);
			}
			
			
			if (ricevuto.equals("disconnect")){
				System.out.println("trovato disconnect");
				running=false;
				try {
					sock.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc.remove(this);
			}
		}
		
		
		
		
	}

	public void stop() {
		pg.softstop();
		
	}
}
