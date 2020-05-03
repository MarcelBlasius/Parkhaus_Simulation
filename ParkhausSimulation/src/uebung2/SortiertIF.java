package uebung2;

public interface SortiertIF {
	
	boolean isWellSorted(String[] sequence);
	
	String[][] transitivitaetAufloesen(String[][] s);
	
	String[][] getAbhaengigkeiten();
	
	boolean doppelteAufgabe(String[] s);
}
