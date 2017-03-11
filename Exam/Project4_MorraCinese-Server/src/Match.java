import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match implements Runnable {
	private Socket sock1;
	private Socket sock2;
	private Scanner sc1;
	private Scanner sc2;
	private PrintWriter pw1;
	private PrintWriter pw2;
	private boolean running=true;
	private boolean first=true;
	private boolean stop=false;
	private ServerThread st;
	private String mossa1;
	private String mossa2;
	
	public Match(ServerThread st,Socket sock1,Socket sock2) {
		this.sock1=sock1;
		this.sock2=sock2;
		this.st=st;
		
	}

	@Override
	public void run() {
		if (first){
			try {
				first=false;
				sc1=new Scanner(sock1.getInputStream());
				sc2=new Scanner(sock2.getInputStream());
				pw1= new PrintWriter(sock1.getOutputStream());
				pw2= new PrintWriter(sock2.getOutputStream());
				pw1.write("1"+"\n");
				pw2.write("2"+"\n");
				pw1.flush();
				pw2.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		while (running){
			try{
			mossa1=sc1.nextLine();
			System.out.println("Mossa giocatore 1: "+mossa1);
			if (mossa1.equals("bye")){
				System.out.println("Ho ricevuto bye da giocatore 1");
				pw1.write("ok"+"\n");
				pw2.write("bye"+"\n");
				pw1.flush();
				pw2.flush();
				stop=true;
			}
			mossa2=sc2.nextLine();
			System.out.println("Mossa giocatore 2: "+mossa2);
			if (mossa2.equals("bye")){
				System.out.println("Ho ricevuto bye da giocatore 2");
				pw1.write("bye");
				pw2.write("ok");
				pw1.flush();
				pw2.flush();
				stop=true;
				
			}
			if(!stop){
				int risultato= controllo(mossa1,mossa2);
				if (risultato==-1){
					pw1.write("lost"+"\n");
					pw2.write("won"+"\n");
				}
				if (risultato==1){
					pw1.write("won"+"\n");
					pw2.write("lost"+"\n");
				}
				if (risultato==0){
					pw1.write("draw"+"\n");
					pw2.write("draw"+"\n");
				}
				pw1.flush();
				pw2.flush();
			}
			}catch (NoSuchElementException e){
				running=false;
				st.remove(this);
			}
		
		}
		
		
	}
	
	public int controllo(String str1, String str2){
		if (str1.equals("sasso")){
			if (str2.equals("forbici")){
				return 1;
			}
			if (str2.equals("carta")){
				return 1;
			}
			if (str2.equals("sasso")){
				return 0;
			}
		}
		
		if (str1.equals("forbici")){
			if (str2.equals("forbici")){
				return 0;
			}
			if (str2.equals("carta")){
				return 1;
			}
			if (str2.equals("sasso")){
				return -1;
			}
		}
		
		if (str1.equals("carta")){
			if (str2.equals("forbici")){
				return -1;
			}
			if (str2.equals("carta")){
				return 0;
			}
			if (str2.equals("sasso")){
				return 1;
			}
			
		}
		return 2;
	}
	
	public void stop(){
		running=false;
		try {
			sock1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sock2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.remove(this);
	}

}
