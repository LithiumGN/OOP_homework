
public class E1_2 {

	public static void main(String[] args) {
		
		/* Scrivere un programma Java che data una stringa interamente in minuscolo, 
         * stampi la stringa stessa con le lettere nelle posizioni pari in maiuscolo.
		 * Esempio: input = programmazione ; output= PrOgRaMmAzIoNe*/
		
		String input = "programmazione";
		String output = "";
		for(int i = 0; i < input.length(); i++){
			
			String character = input.substring(i, i+1);
			
			if(i%2 == 0){
				
				character = character.toUpperCase();
				
			}
			
			output = output + character;
		}
		
		System.out.println(output);
	}

}
