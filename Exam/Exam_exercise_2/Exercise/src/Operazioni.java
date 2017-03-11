import java.util.Iterator;
import java.util.Set;

public class Operazioni {
	
	
	public static Utente migliorOfferente(Biglietto b) {
		Set<Offerta> offerte=b.getOfferte();
		Iterator<Offerta> it =offerte.iterator();
		double prezzo=0;
		Utente max=null;
		while(it.hasNext()){
			Offerta offer=it.next();
			double pricefound= offer.getPrezzo();
			if (pricefound>prezzo){
				max=offer.getUser();
				prezzo=pricefound;
				
			}
			
		}
		return max;
		
		
	}
	
	public static boolean utenteSbadato(Utente u){
		Set<Biglietto> tickets= u.getBiglietti();
		Iterator<Biglietto> it= tickets.iterator();
		System.out.println("sono dentro il ciclo");
		
		while(it.hasNext()){
			System.out.println("sono dentro il ciclo");
			Biglietto tick=it.next();
			Set<Offerta> offers=tick.getOfferte();
			Iterator<Offerta> it2=offers.iterator();
			while(it2.hasNext()){
				Offerta offer=it2.next();
				Utente seller=offer.getUser();
				System.out.println(seller);
				if(seller==u){
					return true;
				}
				
			}
		}
		
		return false;
		
		
	}

	
	


}
