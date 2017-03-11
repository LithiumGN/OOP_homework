import java.util.HashSet;
import java.util.Set;

public class Biglietto {
	private String nome;
	private String city;
	private Set<Offerta> offerte;
	
	public Biglietto(String nome,String city){
		this.nome=nome;
		this.city=city;
		offerte=new HashSet<Offerta>();
	}
	


	public void addOfferta(Offerta c){
		offerte.add(c);
	}

	public Set<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(Set<Offerta> offerte) {
		this.offerte = offerte;
	}
	
}
