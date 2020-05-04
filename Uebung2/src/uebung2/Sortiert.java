package uebung2;

public class Sortiert implements SortiertIF{
	private String[][] abhaengigkeiten ;
	
	Sortiert(String[][] abhaengigkeiten){
		this.abhaengigkeiten = abhaengigkeiten;
	}
	
	@Override
	public boolean isWellSorted(String[] sequence) {
		return false;
	}

	@Override
	public String[][] transitivitaetAufloesen(String[][] s) {	
		String[][] tmp ;
		String[][] neu;
		int count=0;
		int pointer = s.length;

		
			
		for(int i=1;i<s.length;i++) {
			for(int j=0;j<s[i].length;j++) {
				
				if(s[i][0]==s[j][1]) {
					neu = new String[1][2];
					neu[0][0] = s[i-1][0];
					neu[0][1] = s[j+1][1];
					System.out.println(neu[0][0]);
					System.out.println(neu[0][1]);
					System.out.println("test");

					for(int n=0;n<s.length;n++) {

							if(!(neu[0][0]==s[n][0]&&neu[0][1]==s[n][1])) {
								System.out.println(s[n][0]);
								System.out.println(s[n][1]);
								System.out.println("text");
								count++;
							}
					}
				}
			}
		}
		tmp= new String[count+s.length][2];
		for(int i=1;i<s.length;i++) {
			for(int j=0;j<s[i].length;j++) {
				if(s[i][0]==s[j][1]) {
					neu = new String[1][2];
					neu[0][0] = s[i-1][0];
					neu[0][1] = s[j+1][1];
					for(int n=0;n<s.length;n++) {
							if(!(neu[0][0]==s[n][0]&&neu[0][1]==s[n][1])) {
								tmp[pointer][0]=neu[0][0];
								tmp[pointer][1]=neu[0][1];
							}
					}
				}
			}
		}
		if(count==0) {
			return tmp;

		}else {
			System.out.println(count);
			//tmp =transitivitaetAufloesen(tmp);
			return tmp;
		}
	}

	@Override
	public String[][] getAbhaengigkeiten() {
		return abhaengigkeiten;
	}

	@Override
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
	
}
