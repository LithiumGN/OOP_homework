import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CoreClient implements Runnable {
	private Socket sock;
	private Scanner sc;
	private PrintWriter pw;
	private boolean first=true;
	private boolean running=true;
	private ClientUI cu;
	
	public CoreClient(Socket sock, ClientUI cu) {
		this.sock=sock;
		this.cu=cu;
	}

	@Override
	public void run() {
		if (first){
			first=false;
			try {
				sc=new Scanner(sock.getInputStream());
				pw=new PrintWriter(sock.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		while (running){
			try{
				String ricevuto=sc.nextLine();
				System.out.println(ricevuto);
				if (ricevuto.equals("1")){
					System.out.println("SONO IL GIOCATORE 1");
					cu.disconnect.setEnabled(true);
					cu.enableAll();
					cu.jl.setText("Sei il giocatore: n.1");
				}
				if (ricevuto.equals("2")){
					System.out.println("SONO IL GIOCATORE 2");
					cu.disconnect.setEnabled(true);
					cu.enableAll();
					cu.jl.setText("Sei il giocatore: n.2");
				}
				
				if (ricevuto.equals("won")){
					JOptionPane.showMessageDialog(null,"HAI VINTO");
				}
				
				if (ricevuto.equals("lost"))
					JOptionPane.showMessageDialog(null,"HAI PERSO");
				if (ricevuto.equals("draw"))
					JOptionPane.showMessageDialog(null,"PAREGGIO");
				if (ricevuto.equals("ok")){
					System.out.println("ricevuto ok");
					JOptionPane.showMessageDialog(null,"Disconnessione avvenuta con successo");
					stop();
				}
				if (ricevuto.equals("bye")){
					System.out.println("ricevuto bye");
					JOptionPane.showMessageDialog(null,"L'altro giocatore ha abbandonato la sessione");
					stop();
					}
				cu.enableAll();
			}
			catch(NoSuchElementException e){
				JOptionPane.showMessageDialog(null, "Il server si è disconnesso, l'applicazione verrà dismessa");
				System.exit(1);
			}
			
		}
		
		
		
	}
	
	public void invia(String text){
		pw.write(text);
		pw.flush();
	}
	
	public void stop(){
		running=false;
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		pw.close();
	}

}
