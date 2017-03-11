import java.util.HashSet;
import java.util.Set;

public class Utente {


	private String nome;
	private String cognome;
	private String city;
	private Set<Biglietto> biglietti;
	
	public Utente(String nome, String cognome, String city){
		this.nome=nome;
		this.city=city;
		this.cognome=cognome;
		biglietti= new HashSet<Biglietto>();
		
	}
	
	public Set<Biglietto> getBiglietti() {
		return biglietti;
	}

	public void setBiglietti(Set<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}

	public void addBiglietto(Biglietto c){
		biglietti.add(c);
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", city=" + city + ", biglietti=" + biglietti + "]";
	}

	
	
}
