import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void test1() {
		Docente max = new Docente("Massimo", "Mecella");
		Facolta i3s = new Scientifico("Ingegneria Informazione",3);
		max.setFaq(i3s);
		Corso oop = new Corso("Prog OO",340);
		max.addCorso(oop);
		Corso lab = new Corso("Laboratorio",120);
		max.addCorso(lab);
		int res=(int) Operazioni.numeroMedioStudenti(max);
		int expected=230;
		assertEquals(expected,res);
	}
	
	@Test
	public void test2() {
		Docente max = new Docente("Massimo", "Mecella");
		Facolta i3s = new Scientifico("Ingegneria Informazione",3);
		max.setFaq(i3s);
		Corso oop = new Corso("Prog OO",1);
		max.addCorso(oop);
		Corso lab = new Corso("Laboratorio",1);
		max.addCorso(lab);
		int res=(int) Operazioni.numeroMedioStudenti(max);
		int expected=1;
		assertEquals(expected,res);
	}

}
