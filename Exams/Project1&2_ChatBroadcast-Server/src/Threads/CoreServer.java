package Threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class CoreServer implements Runnable {
	private Socket sock;
	private ServerConnect sc;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private boolean running=true;
	private List<String> lstr;
	public CoreServer(Socket sock, ServerConnect sc) {
		this.sock=sock;
		this.sc=sc;
	}
	private FileWriter fw;

	@Override
	public void run() {
		lstr=new LinkedList<String>();
		try {
			oos= new ObjectOutputStream(sock.getOutputStream());
			ois=new ObjectInputStream(sock.getInputStream());

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (running){
			Object o=null;
			try {
				o= ois.readObject();

			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Tento di chiudere una istanza terminata");
				sc.remove(this);
				stop();
			}
			if (Integer.class.isInstance(o)){
				try {
					int num= (Integer) o;
					if(num==0){
						sendMsg();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			else if (String.class.isInstance(o)){
				String ss= (String) o;
				if (ss.contains(":")){
					String nome= ss.substring(0, ss.indexOf(":"));
					File fl= new File(nome+".txt");
					if (!fl.exists()){
							try {
								fw= new FileWriter(fl,false);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
					}
					else{
						try {
							fw=new FileWriter(fl,true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}
				try {
					if(fw!=null){
					fw.write(ss+"\r\n");
					fw.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc.readyToSend(ss);
				
			}
			
			
		}
	}
	


	public void sendMsg() throws IOException{
		try {
			System.out.println("I'm going to send: "+lstr);
			oos.writeObject((Object)lstr);
			oos.flush();
			lstr=new LinkedList<String>();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addMsg(String text){
		System.out.println("I will add -"+text+"- to the list");
			lstr.add(text);
		
	}
	
	public void stop(){
		running=false;
		
		try {
			oos.close();
			ois.close();
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
