package ClientConnect;


import java.io.IOException;

public class StartClientFrame {

	public static void main(String[] args) throws IOException, InterruptedException {
		ClientConnect e=new ClientConnect();
		Thread mioThread= new Thread(e);
		mioThread.start();	
	}
}