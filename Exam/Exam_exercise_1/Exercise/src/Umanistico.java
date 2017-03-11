
public class Umanistico extends Facolta {
	private int biblioteche;
	
	public Umanistico(String n,int num){
		super(n);
		biblioteche=num;
		
	}

	public int getBiblioteche() {
		return biblioteche;
	}

	public void setBiblioteche(int biblioteche) {
		this.biblioteche = biblioteche;
	}

}
