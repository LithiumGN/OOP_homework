package Start;
import Gui.serverFrame;

public class StartServer {
	
	public static void main(String[] args) {
		Thread n1= new Thread(new serverFrame());
		n1.start();
		
	}


}
