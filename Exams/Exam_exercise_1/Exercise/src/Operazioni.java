import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operazioni {
	static Logger log= Logger.getLogger("in.operazioni");
	public static double numeroMedioStudenti(Docente d){
		log.setLevel(Level.ALL);
		Set<Corso> corsidoq=d.getCorsi();
		int num=0;
		int numstudenti=0;
		Iterator<Corso> it=corsidoq.iterator();
		while(it.hasNext()){
			Corso subject=it.next();
			numstudenti+=subject.getNumero();
			num++;
			log.log(Level.INFO,"I numeri degli studenti è \n"+numstudenti);
		}

		if (num==0){throw new DivisionePerZeroException();}
		int result=numstudenti/num;
		return result;
		
	}


}
