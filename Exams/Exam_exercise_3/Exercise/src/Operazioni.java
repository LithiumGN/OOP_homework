import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Operazioni {
	
	public static Set<Impiegato> fuoriSede(Set<Impiegato> si){
		Set<Impiegato> fuorisede=new HashSet<Impiegato>();
		Iterator<Impiegato> it=si.iterator();
		while(it.hasNext()){
			Impiegato imp=it.next();
			String city_imp=imp.getCity();
			Sede sd_imp=imp.getSede();
			if(!city_imp.equals(sd_imp.getCity())){
				fuorisede.add(imp);
			}
			
		}
		return fuorisede;
		
		
		
	}
	
	private static boolean stessaSedeImpiegati(Set<Impiegato> si) {
		boolean r = true;
		Iterator<Impiegato> it = si.iterator();
		Impiegato imp = it.next();
		Sede sede = imp.getSede();
		while (it.hasNext()) {
			imp = it.next();
			if (imp.getSede()==null) {
				System.out.println("***HERE*** "+imp);
			}
			r = r && (imp.getSede().equals(sede));
		}
		return r;
	}
	
	public static boolean stessaSede(Set<Progetto> sp){
		Iterator<Progetto> it=sp.iterator();
		while(it.hasNext()){
			Progetto project=it.next();
			Set<Impiegato> insieme=project.getImpiegati();
			if(!stessaSedeImpiegati(insieme)){
				return false;
				}
			}
		return true;
	}
	
	public static void spostaImpiegato(Impiegato i, Progetto pv, Progetto pn){
		pv.removeImpiegato(i);
		pn.addImpiegato(i);
	}



}
