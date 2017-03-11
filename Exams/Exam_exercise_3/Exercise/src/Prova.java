import java.util.*;

public class Prova {

	static String[] nomi = { "Mario", "Carla", "Giuseppe", "Alberto", "Anna", "Giulia" };
	static String[] cognomi = { "Rossi", "Verdi", "Neri", "Bianchi", "Gialli", "Rosa" };
	static String[] citta = { "Roma", "Venezia", "Firenze", "Milano"};
	
	static Impiegato nuovoImpiegato() {
		int kno = (int)(Math.random()*nomi.length);
		int kco = (int)(Math.random()*cognomi.length);
		int kci = (int)(Math.random()*citta.length);
		return new Impiegato(nomi[kno],cognomi[kco],citta[kci]);
	}

	static Direttore nuovoDirettore() {
		int kno = (int)(Math.random()*nomi.length);
		int kco = (int)(Math.random()*cognomi.length);
		int kci = (int)(Math.random()*citta.length);
		int anno = 2016;
		return new Direttore(nomi[kno],cognomi[kco],citta[kci],anno);
	}

	static Sede nuovaSede() {
		int cod = (int)(Math.random()*10000);
		int kci = (int)(Math.random()*citta.length);
		return new Sede(""+cod,citta[kci]);
	}

	static Progetto nuovoProgetto() {
		int cod = (int)(Math.random()*10000);
		return new Progetto(""+cod,"Il progetto con codice "+cod);
	}

	static Set<Impiegato> dbImpiegati;
	static Set<Sede> dbSedi;	
	static Set<Progetto> dbProgetti;
	
	// sceglie un impiegato random (non un direttore)
	static Impiegato randomImpiegato() {
		Impiegato r=null;
		while (r==null) {
			int k = (int)(1+Math.random()*dbImpiegati.size());
			Iterator<Impiegato> it = dbImpiegati.iterator();
			for (int i=0; i<k; i++) {
				Impiegato imp = it.next();
				if (imp.getClass().equals(Impiegato.class))
					r = imp;
			}
		}
		return r;
	}
	
	static Sede randomSede() {
		int k = (int)(1+Math.random()*dbSedi.size());
		Iterator<Sede> it = dbSedi.iterator();
		Sede r=null;
		for (int i=0; i<k; i++) {
			r=it.next();
		}
		return r;
	}
	
	static Progetto randomProgetto() {
		int k = (int)(1+Math.random()*dbProgetti.size());
		Iterator<Progetto> it = dbProgetti.iterator();
		Progetto r=null;
		for (int i=0; i<k; i++) {
			r=it.next();
		}
		return r;
	}
	
	
	static void creaDB() {
		dbImpiegati = new HashSet<Impiegato>();
		dbSedi = new HashSet<Sede>();
		dbProgetti = new HashSet<Progetto>();
		
		// crea impiegati
		for (int i=0; i<20; i++) {
			Impiegato imp = nuovoImpiegato();
			dbImpiegati.add(imp);
		}
		// crea sedi e direttori
		for (int i=0; i<5; i++) {
			Sede s = nuovaSede();
			Direttore d = nuovoDirettore();
			s.setDirettore(d); d.setSede(s);
			dbSedi.add(s);
			dbImpiegati.add(d);
		}
		// crea progetti
		for (int i=0; i<10; i++) {
			Progetto p = nuovoProgetto();
			dbProgetti.add(p);
		}
		// assegna impiegati a sedi (eccetto direttori)
		Iterator<Impiegato> it = dbImpiegati.iterator();
		while (it.hasNext()) {
			Impiegato imp = it.next();
			if (imp.getClass().equals(Impiegato.class)) {
				imp.setSede(randomSede());
			}
		}
		// assegna impiegati a progetti (eccetto direttori)
		Iterator<Progetto> ip = dbProgetti.iterator();
		while (ip.hasNext()) {
			Progetto p = ip.next();
			int ni = (int)(2+Math.random()*3); // numero di impiegati da aggiungere
			for (int i=0; i<ni; i++) {
				p.addImpiegato(randomImpiegato()); 
				// non controlla se già presente, 
				// quindi numero effettivo può essere minore di ni
			}
		}
		
	}
	
	static void stampaDB() {
		System.out.println("=== Impiegati ===");
		Iterator<Impiegato> ii = dbImpiegati.iterator();
		while (ii.hasNext()) {
			System.out.println(ii.next());
		}
		System.out.println("=== Sedi ===");
		Iterator<Sede> is = dbSedi.iterator();
		while (is.hasNext()) {
			System.out.println(is.next());
		}
		System.out.println("=== Progetti ===");
		Iterator<Progetto> ip = dbProgetti.iterator();
		while (ip.hasNext()) {
			System.out.println(ip.next());
		}
		System.out.println("----------------------------");
	}
	
	
	public static void main(String[] args) {
		
		creaDB(); stampaDB();
		
		System.out.println("=== DATI TEST ===");
		
		Impiegato i1 = randomImpiegato(); System.out.println(i1);
		Impiegato i2 = randomImpiegato(); System.out.println(i2);
		Impiegato i3 = randomImpiegato(); System.out.println(i3);
		Impiegato i4 = randomImpiegato(); System.out.println(i4);
		
		Progetto p1 = randomProgetto(); System.out.println(p1);
		Progetto p2 = randomProgetto(); System.out.println(p2);
		Progetto p3 = randomProgetto(); System.out.println(p3);
		
		Set<Impiegato> si = new HashSet<Impiegato>();
		si.add(i1); si.add(i2); si.add(i3); si.add(i4);

		Set<Progetto> sp = new HashSet<Progetto>();
		sp.add(p1); sp.add(p2); sp.add(p3); 
		System.out.println("----------------------------");
		
		System.out.println("Operazione fuoriSede");
		Set<Impiegato> res = Operazioni.fuoriSede(si);
		System.out.println("Risultato:");
		System.out.println(res);
		System.out.println("----------------------------");
		
		System.out.println("Operazione stessaSede");
		boolean r = Operazioni.stessaSede(sp);
		System.out.println("Risultato: "+r);
		System.out.println("----------------------------");
		
		System.out.println("Operazione spostaImpiegato");
		Operazioni.spostaImpiegato(i1,p1,p2);
		System.out.println(i1);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("----------------------------");
	}
}
