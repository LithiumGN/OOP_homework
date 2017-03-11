
public class Sede {
	private String codice;
	private String city;
	private Direttore direttore;
	
	public Sede(String codice,String city){
		this.codice=codice;
		this.city=city;
		
	}

	public String getCity() {
		return city;
	}


	public Direttore getDirettore() {
		return direttore;
	}

	public void setDirettore(Direttore direttore) {
		this.direttore = direttore;
	}

}
