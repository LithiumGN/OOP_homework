
public class Offerta {
	private double prezzo;
	private Utente user;
	
	public Offerta(Utente user,double d){
		this.user=user;
		this.prezzo=d;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}
	

}
