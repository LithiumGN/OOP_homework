package ClientConnect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import CoreUI.ClientFrame;

public class ClientConnect implements Runnable {
	private Socket sock;
	private boolean running=true;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private boolean first=true;
	private Object o;
	private ClientFrame cf;
	private String nome;
	
	public ClientConnect(Socket sock, ClientFrame cf,String nome){
		this.sock=sock;
		this.cf=cf;
		this.nome=nome;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void run() {
		if (first){
			try {
				oos= new ObjectOutputStream(sock.getOutputStream());
				ois= new ObjectInputStream(sock.getInputStream());
				first=false;
				oos.writeObject(nome+" si è unito alla chat");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		while (running){
			try {
				oos.writeObject(new Integer(0));
				oos.flush();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Connection error");
				this.stop();
				System.exit(1);
			}
			
			try {
				o=ois.readObject();
				System.out.println("I received o : "+(List)o);
			} catch (ClassNotFoundException | IOException e) {

				JOptionPane.showMessageDialog(null, "Server offline");
				System.exit(1);
			}

				if(List.class.isInstance(o)){
					List<String> l=null;
					l=(List<String>) o;
					Iterator<String> it= l.iterator();
					while (it.hasNext()){
						String s=it.next();
						System.out.println("Adding:"+s);
						cf.history.append(s+ "\n"); //this function will show the received content on a JTextArea
				}
			}
				
			
			
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
		
	
	
	
	public void stop(){
		running=false;
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String text){
		if (!text.equals("")){
			try {
				oos.writeObject(nome+": "+text);
				oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	

}
