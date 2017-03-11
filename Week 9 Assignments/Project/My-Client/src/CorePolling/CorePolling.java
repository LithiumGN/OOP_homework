package CorePolling;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextArea;

public class CorePolling implements Runnable {
	private JTextArea textArea;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private boolean running;
	
	public CorePolling(JTextArea textArea, ObjectOutputStream oos, ObjectInputStream ois){
		this.textArea = textArea;
		this.oos = oos;
		this.ois=ois;
		running = false;
	}
	
	
	@SuppressWarnings("unchecked")
	public void run() {
		running = true;
		while(running){
			Object o = null;
			try {
				oos.writeObject(new Integer(0));
				oos.flush();
				o = ois.readObject();
				
			} catch (SocketException e) {} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			List<String> l = null;
			if(List.class.isInstance(o)){
				l = (List<String>)o;
			}
			String text = textArea.getText();
			if (l!=null){
			Iterator<String> it = l.iterator();
			while(it.hasNext()){
				text += it.next()+"\n\n";
			}
			textArea.setText(text);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}
	
	public void stop(){
		running = false;
	}

}
			
			
	


