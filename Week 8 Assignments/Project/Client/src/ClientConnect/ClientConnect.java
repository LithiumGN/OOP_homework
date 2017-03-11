package ClientConnect;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.Socket;

import javax.swing.JOptionPane;

import Gui.clientFrame;

public class ClientConnect implements Runnable{
	private clientFrame frm=new clientFrame();
	private Socket socket;
	private static int check=0;

	public  ClientConnect(){
		
	}
		
	
	public void run() {
			
		try{
			System.out.println("Buondì! Il client si sta per collegare al Server di chat");
			socket = new Socket("127.0.0.1",3000);
			System.out.println("Connessione Stabilita");
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter socketOut=new PrintWriter(socket.getOutputStream());
			socketOut.write("~ "+frm.name+" si è unito alla chat~ \n");
			socketOut.flush();
			
			while(true){
				if (frm.dainviare!=""){
					socketOut.write(frm.name+": "+frm.dainviare+"\n");
					socketOut.flush();
					frm.dainviare="";
					}
	        	 
				if(streamIn.ready()){
					String ricevuti=streamIn.readLine();
					if (ricevuti.contains("HALT")){
						
						socket.close();
						socketOut.close();
						streamIn.close();
						check = 1;
						JOptionPane.showMessageDialog(null,"Il server è stato spento","Server non disponibile",JOptionPane.WARNING_MESSAGE);}  
					else{
						frm.Testo.append(ricevuti+"\n");
					}
					
					
				}

				Thread.sleep(2000);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,"Server non disponibile.","Server non disponibile",JOptionPane.ERROR_MESSAGE);
				}
			}  
			
		}

	