package CoreServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientConnect implements Runnable {
	
	
	@SuppressWarnings("unused")
	private Socket sock;
	private OutputStream os;
	private InputStream is;
	private String matricola;
	private FileWriter fwrite;
	private Scanner sn;
	private PrintWriter pw;
	public boolean running=true;
	public boolean first=true;
	
	public ClientConnect(Socket sock,String matricola){
		try {
			this.sock= sock;
			this.matricola=matricola;
			os=sock.getOutputStream();
			is=sock.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void run() {

		pw= new PrintWriter(os);
		pw.write("start"+"\n");
		pw.flush();
		sn=new Scanner(is);
		while(running){
			File fw=new File(matricola+".txt");
			if (fw.exists()&& !first){
				try {
					String dastampare=sn.nextLine();
					System.out.println("Ho ricevuto: "+dastampare);
					fwrite = new FileWriter(fw,true);
					if(!dastampare.equals("*")){
					fwrite.write(dastampare);
					}
					fwrite.flush();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Connessione con il server interrotta",null,0);
					System.exit(1);
				}
				catch (NoSuchElementException e){
					JOptionPane.showMessageDialog(null, "Connessione con il server interrotta",null,0);
					System.exit(1);
					
				}

			}
			
			else {
				try {
					String dastampare=sn.nextLine();
					System.out.println("Ho ricevuto: "+dastampare);
					fwrite = new FileWriter(fw,false);
					if(!dastampare.equals("*")){
						fwrite.write(dastampare);
						}
					fwrite.flush();
					first=false;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Connessione con il server interrotta",null,0);
					System.exit(1);
				}
				catch (NoSuchElementException e){
					JOptionPane.showMessageDialog(null, "Connessione con il server interrotta",null,0);
					System.exit(1);
					
				}

			}

		}
		if (running==false){
			System.out.println("Finisco" +sn.nextLine());
			System.out.println("Finisco" +sn.nextLine());

			try {
				fwrite.write("\r\n");
				fwrite.write(sn.nextLine());
				fwrite.flush();
				sn.nextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void stop() throws InterruptedException{
		running=false;
		first=true;
		pw.write("stop"+"\n");
		pw.flush();
	}
	
	public void disconnect(){
		pw.write("disconnect");
		
	}
	

}


