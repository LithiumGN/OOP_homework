import java.util.HashSet;
import java.util.Set;

public class Progetto {
	private String codice;
	private String descrizione;
	private Set<Impiegato> impiegati;
	
	public Progetto(String codice,String descrizione){
		this.codice=codice;
		this.descrizione=descrizione;
		impiegati=new HashSet<Impiegato>();
	}
	
	public void addImpiegato(Impiegato obj){
		impiegati.add(obj);
	}
	
	public void removeImpiegato(Impiegato obj){
		impiegati.remove(obj);
	}

	public Set<Impiegato> getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(Set<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
	

}
