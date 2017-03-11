package CoreServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnect implements Runnable{
	
	private ServerManager sm;
	private Socket sock;
	private Scanner sc;
	private PrintWriter pw;
	private DBTeatro db;
	private String nome,cognome,posto;
	private boolean running=true;
	
	public ServerConnect(ServerManager sm, Socket sock, DBTeatro db){
		this.sm=sm;
		this.sock=sock;
		this.db=db;
	}

	@Override
	public void run() {
		try {
			sc=new Scanner(sock.getInputStream());
			pw=new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			sm.removeList(this);
			running=false;
		}
		catch(NullPointerException e1){
			running=false;
		}
		if(running){
		nome=sc.nextLine();
		cognome=sc.nextLine();
		posto=sc.nextLine();
		
		int ris=db.prenota(posto,nome+" "+cognome);
		if (ris==-1){
			pw.write("Posto già prenotato o posto non in elenco"
					+ "\n");
			pw.flush();
		}
		else {
			pw.write("Prenotazione avvenuta con successo"+ "\n");
			pw.flush();
		}
		try {
			sock.close();
		} catch (IOException e) {
			sm.removeList(this);
			e.printStackTrace();
		}
		sm.removeList(this);
		}
		
		
	}
	
	public void stop(){
		try {
			sock.close();
		} catch (IOException e) {
			sm.removeList(this);
			e.printStackTrace();
		}
		sm.removeList(this);
		
	}

}
