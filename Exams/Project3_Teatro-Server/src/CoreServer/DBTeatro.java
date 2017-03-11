package CoreServer;

import java.util.HashMap;
import java.util.Map;

public class DBTeatro {
	private Map<String,String> mp;
	
	public DBTeatro(){
		mp= new HashMap<String,String>();
		
	}
	
	public synchronized int prenota(String posto, String nomecognome){
		char c= posto.charAt(0);
		int n= Integer.parseInt(posto.substring(1));
		if (c>='A' && c<='F' && n>=1 && n<=20){
			if (mp.containsKey(posto)){
				return -1;
				}
			mp.put(posto, nomecognome);
			return 0;
		}
		return -1;
		
	}
	
	public void remove(String posto){
		mp.remove(posto);
	}

}
