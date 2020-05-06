package uebung2;

public class Sortiert implements SortiertIF{
	private String[][] abhaengigkeiten ;
	
	Sortiert(String[][] abhaengigkeiten){
		this.abhaengigkeiten = abhaengigkeiten;
		transitivitaetAufloesen();
		
	}
	
	
	
	public String[][] getAbhaengigkeiten() {
		return abhaengigkeiten;
	}
	
	public boolean isWellSorted(String[] sequence) {
		int pointer = 0;
		
		
		
		if(doppelteAufgabe(sequence) == true) {
			return false;
		}
		
		
		
		
		for (int i = 0; i < sequence.length; i++) {
			pointer = i;
			for (int j = (pointer + 1) ; j < sequence.length; j++) {
				for (int m = 0; m < abhaengigkeiten.length; m++) {
					for (int n = 0; n < abhaengigkeiten[0].length; n++) {
						if(sequence[i].equals(abhaengigkeiten[n][1]) && sequence[j].equals(abhaengigkeiten[m][0])) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

	
	
	public boolean doppelteAufgabe(String[] s) {
		String tmp="";
		for(int i= 0; i<s.length;i++) {
			if(tmp.contains(s[i])) {
				return true;
			}
			tmp += s[i];
		}
		return false;
	}
	
	public void transitivitaetAufloesen() {
		String[][] ergebnis;
		int anzahl = 0;
		
		
		//nach Transitivitaeten suchen und anzahl dieser betimmen
		for (int i = 0; i < abhaengigkeiten.length; i++) {
			for (int j = 0; j < abhaengigkeiten.length; j++) {
				
				if(abhaengigkeiten[i][0] == abhaengigkeiten[j][1]) {
					
					anzahl+= 1;
				}
			}
		}
		
		// alten Array-Inhalt kopieren
			
		ergebnis = new String[abhaengigkeiten.length + anzahl][2];
		
		for (int x = 0; x < abhaengigkeiten.length; x++) {
			for (int y = 0; y < abhaengigkeiten[0].length; y++) {
				ergebnis[x][y] = abhaengigkeiten[x][y];
			}
		}
			
		// neue Elemente bestimmen
						
		String[][] tmp = new String[anzahl][2];	
			
		int counter = 0;
					
		for (int m = 0; m < abhaengigkeiten.length; m++) {
			for (int n = 0; n < abhaengigkeiten.length; n++) {
				if(abhaengigkeiten[m][0] == abhaengigkeiten[n][1]) {
					tmp[counter][0] = abhaengigkeiten[n][0];
					tmp[counter][1] = abhaengigkeiten[m][1];
					counter++;
				}
			}
		}
		
		// neue Elemente hinzufügen
		
		for (int k = 0; k < tmp.length; k++) {
			ergebnis[abhaengigkeiten.length + k][0] = tmp[k][0];
			ergebnis[abhaengigkeiten.length + k][1] = tmp[k][1];
			
		}
		
		abhaengigkeiten =  ergebnis;
		
	}
}