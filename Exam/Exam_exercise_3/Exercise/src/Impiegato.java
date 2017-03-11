
public class Impiegato {
	private String nome;
	private String cognome;
	private String city;
	private Sede sede;
	
	public Impiegato(String nome, String cognome,String city) {
		this.nome=nome;
		this.cognome=cognome;
		this.city=city;
		
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
