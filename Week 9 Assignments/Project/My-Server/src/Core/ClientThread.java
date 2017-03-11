package Core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;



public class ClientThread implements Runnable {
	private CoreServer mainThread;
	private Socket sock;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private boolean running=true;
	private boolean fired=false;
	private LinkedList<String> privateMessages;
	private OutputStream os;
	private InputStream is;
	private String nome=null;
	
	public ClientThread(CoreServer main, Socket sock)throws IOException{
		this.sock=sock;
		try{
		os=sock.getOutputStream();
		is = sock.getInputStream();
		oos=new ObjectOutputStream(os);
		ois=new ObjectInputStream(is);
		mainThread=main;
		}
		catch(NullPointerException e){running=false;}
		
	}
	@Override
	public void run() {
		if (fired) return;
		while (running){
			Object o;
			try {
				o = ois.readObject();
				if (Integer.class.isInstance(o)){
					Integer cmd = (Integer) o;
					if (cmd==0){inviaMessaggi();}
					else {running=false;}
				}
				
				
				else if (String.class.isInstance(o)) {
					String msg = (String) o;
					if (nome==null){nome=msg;}
					else{
					File fil=new File(nome+".txt");
					if(fil.exists()){
						PrintWriter pw = new PrintWriter(new FileOutputStream(fil,true));
						pw.write(msg);
						pw.flush();
						pw.close();}
					else{
						fil.createNewFile();
						PrintWriter pw = new PrintWriter(new FileOutputStream(fil,true));
						pw.write(msg);
						pw.flush();
						pw.close();
					}
					System.out.println(msg);
					mainThread.newMessage(msg);
					}
				}
				
			} catch (ClassNotFoundException | SocketException e2 ) {
				try {
					sock.close();
					oos.close();
					ois.close();
				} catch (IOException e) {
					running=false;
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CoreServer.control(this);
				System.out.println("Qualcuno si è disconnesso");
				running=false;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	private void inviaMessaggi() {
		sendObject(privateMessages);
		privateMessages = new LinkedList<String>();
	}
	
	private void sendObject(Object o){
		try {
			oos.writeObject(o);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isClosed() {

		return sock.isClosed();
	}
	
	public void sendMsg(String msg) {
		privateMessages.add(msg);
	}
	
	public void spegni(){
		try {
			sock.close();
			oos.close();
			ois.close();
			running=false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto mentre spegnevo il server");
		}
		
		
	}
	

}
