package CoreClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CoreClient implements Runnable {
	private String nome;
	private String cognome;
	private String posto;
	private Socket sock;
	private Scanner sn;
	private PrintWriter pw;
	
	public CoreClient(String nome,String cognome,String posto){
		this.nome=nome;
		this.cognome=cognome;
		this.posto=posto;
		
		
	}

	@Override
	public void run() {
		try {
			sock= new Socket("127.0.0.1",3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Server non disponibile",null,0);
			System.exit(1);
		}
		try {
			sn= new Scanner(sock.getInputStream());
			pw= new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.write(nome+"\n");
		pw.write(cognome+"\n");
		pw.write(posto+"\n");
		pw.flush();
		JOptionPane.showMessageDialog(null,"RISPOSTA: "+sn.nextLine());
		System.exit(0);
		
		
		
		
		
		
	}
	
	
	

}
