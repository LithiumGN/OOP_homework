
public class Scientifico extends Facolta {
	private int lab;
	
	public Scientifico(String n,int num){
		super(n);
		lab=num;
		
	}

	public int getLab() {
		return lab;
	}

	public void setLab(int lab) {
		this.lab = lab;
	}
	

}
