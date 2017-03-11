
public class TestEx {
	public static void main(String[] args) {
		Docente max = new Docente("Massimo", "Mecella");
		Facolta i3s = new Scientifico("Ingegneria Informazione",3);
		max.setFaq(i3s);
		Corso oop = new Corso("Prog OO",340);
		max.addCorso(oop);
		Corso lab = new Corso("Laboratorio",120);
		max.addCorso(lab);
		System.out.println(Operazioni.numeroMedioStudenti(max));
			
		}

	}



