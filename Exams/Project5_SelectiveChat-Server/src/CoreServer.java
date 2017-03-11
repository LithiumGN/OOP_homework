import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class CoreServer implements Runnable {
	
	private Socket sock;
	private ServerManager sm;
	private boolean first=true;
	private boolean running=true;
	private String channel;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<String> messaggi;
	private Object o;
	public CoreServer(Socket sock,ServerManager sm){
		this.sock=sock;

		this.sm=sm;
	}
	@Override
	public void run() {
		if (first){
			try {
				oos=new ObjectOutputStream(sock.getOutputStream());
				ois=new ObjectInputStream(sock.getInputStream());
				messaggi=new LinkedList<String>();
				String o= (String)ois.readObject();
				channel=o;
				sm.addSelective(o, this);
			} catch (IOException e) {
				running=false;
				if (channel!=null){
					sm.remove(this,channel);
				}
				else{
					sm.remove(this);
				}
			} catch (ClassNotFoundException e) {
				running=false;
				if (channel!=null){
					sm.remove(this,channel);
				}
				else{
					sm.remove(this);
				}
			}
			catch (NullPointerException e) {
				running=false;
				if (channel!=null){
					sm.remove(this,channel);
				}
				else{
					sm.remove(this);
				}

			}
			
			
			
		}
		while (running){
			System.out.println("Leggo object");
			try {
				o=ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				running=false;
				sm.remove(this, channel);
				e.printStackTrace();
			}
			if(Integer.class.isInstance(o)){
				try {
					oos.writeObject(messaggi);
					System.out.println("Sto inviando: "+messaggi);
					oos.flush();
				} catch (IOException e) {
					running=false;
					sm.remove(this, channel);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				messaggi=new LinkedList<String>();
			}
			if (String.class.isInstance(o)){
				sm.readyToSend((String)o,channel);
				
			}
			
			
			
		}
		
	}
	
	public void addMsg(String txt){
		messaggi.add(txt);
		
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
