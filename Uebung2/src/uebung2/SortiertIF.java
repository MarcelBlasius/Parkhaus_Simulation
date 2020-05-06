package uebung2;

public interface SortiertIF {
	
	String[][] getAbhaengigkeiten();
	
	public boolean isWellSorted(String[] sequence);
	
	void transitivitaetAufloesen();
	
	boolean doppelteAufgabe(String[] s);
}
