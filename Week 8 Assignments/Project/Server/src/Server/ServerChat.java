package Server;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.JOptionPane;

public class ServerChat implements Runnable {
	   static Socket csocket;
	   static Set<Socket> allclients= new HashSet<Socket>();
	   static ServerSocket ssock;
       static PrintStream out;
       static BufferedReader streamIn;
       static int check=0;
       private static Socket sock;
	   
	   ServerChat(Socket csocket) {
	      ServerChat.csocket = csocket;
	   }
	   
	public ServerChat() {
		
	}
	

	public static void serverChat(){
		
	   }
	   
	   public void run() {
		   if (check==0){
			   try {
				   check=1;
				   ServerChat.ssock= new ServerSocket(3000);
				   }  
			   catch(java.net.BindException e){
		 			JOptionPane.showMessageDialog(null,"Server già avviato","Attenzione",JOptionPane.WARNING_MESSAGE);
		 		} 
			   catch (IOException e) {
				   e.printStackTrace();
				}
			      System.out.println("Listening");
			      while (true) {
			    	 try{
			    		 sock = ServerChat.ssock.accept();
			    		 allclients.add(sock);}
			    	 catch(SocketException e){ 
			    		 break;
			    	 	} 
			    	 catch (IOException e) {
			    		e.printStackTrace();
			    	 	}
			         System.out.println("Connected");
			         new Thread(new ServerChat(sock)).start();
			      }
			   }
		   else 
			   try {
				   out= new PrintStream(csocket.getOutputStream());
				   streamIn= new BufferedReader(new InputStreamReader(csocket.getInputStream()));
				   while(true){
					   if(streamIn.ready()){
						   String line=streamIn.readLine();
						   System.out.println(line+"\n");
						   sendtoAll(line);
					   }

	        	
				   }
	        	
			   }
	      
	      catch (IOException e) {
	    	  System.out.println("SERVER NON DISPONIBILE");
	    	  e.printStackTrace();
	      } 
	      catch(NoSuchElementException e){
	    	  for (Iterator<Socket> i = allclients.iterator(); i.hasNext();) {
	    		    Socket element = i.next();
	    		    if (element==csocket) {
	    		    	try {
							element.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	    		        i.remove();
	    		    }
	    		}
	    	  System.out.println("NoSuchElementException");
	      }
	      
	   }

	  public static synchronized void sendtoAll(String message) throws IOException{
		  Iterator<Socket> iteratore=allclients.iterator();
		  while(iteratore.hasNext()){
			  Socket dausare=iteratore.next();
			  PrintStream out=new PrintStream(dausare.getOutputStream());
			  out.println(message);
			  out.flush();
			  
		  }
	  }
	  public static void close() throws IOException{
		  try{
		  ssock.close();
		  csocket.close();
		  streamIn.close();
		  out.close();
		  }
		  catch(NullPointerException e){}
	  }
	   }


