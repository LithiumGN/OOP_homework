import java.util.HashSet;
import java.util.Set;

public class Docente {
	private String nome;
	private String cognome;
	private Facolta faq=null;
	private Set<Corso> corsi;
	

	public Docente(String nome,String cognome) {
		this.nome=nome;
		this.cognome=cognome;
		corsi= new HashSet<Corso>();
	}


	public Facolta getFaq() {
		return faq;
	}


	public void setFaq(Facolta faq) {
		this.faq = faq;
	}


	public Set<Corso> getCorsi() {
		return corsi;
	}


	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}
	
	public void addCorso(Corso obj){
		corsi.add(obj);
	}

}
