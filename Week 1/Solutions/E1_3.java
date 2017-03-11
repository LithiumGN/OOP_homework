
public class E1_3 {

	public static void main(String[] args) {
		
		/* Scrivere un programma Java che dato un intero rappresentante un anno, indichi se questo è bisestile.
		 * Un anno è bisestile se è divisibile per 4 ma non per 100 oppure per 400.
         */
		
		int annoBis = 2016;
		int annoNBis = 1900;
		
		if((annoBis % 4 == 0 && annoBis % 100 != 0)||annoBis %400 == 0){
			System.out.println(annoBis + " è bisestile!");
		}else{
			System.out.println(annoBis + "non è bisestile!");
		}
		
		if((annoNBis % 4 == 0 && annoNBis % 100 != 0)||annoNBis %400 == 0){
			System.out.println(annoNBis + " è bisestile!");
		}else{
			System.out.println(annoNBis + " non è bisestile!");
		}
	}

}
