package uebung2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortiertTest {

	SortiertIF s,transitivSortiert;
	
	
	@BeforeEach
	protected void setUp() {
		String [][] p = {{ "A" , "C" },{ "C", "D" },{ "B", "C" }};
		s = new Sortiert(p);
		String [][] t = {{"A","B"},{"B","C"},{"C","D"}};
		transitivSortiert = new Sortiert(t);
	}
	
	@Test
	@DisplayName("Richtige Sequenz wird angenommen")
	void testSequenzIsWellSorted() {
		String [] sequence = {"A","B","C","D"};
		assertEquals(true,s.isWellSorted(sequence));
	}
	
	@Test
	@DisplayName("Falsche Sequenz wird abgelehnt")
	void testSeQuenzIsNotWellSorted() {
		String [] sequence = {"C","B","A","D"};
		assertEquals(false,s.isWellSorted(sequence));
	}
	
	@Test
	@DisplayName("Transitivitaet wird korrekt aufgeloest")
	void testTransitivitaet() {
		String [][] sequence = {{"A","B"},{"B","C"},{"C","D"},{"A","C"},{"B","D"},{"A","D"}};
		assertEquals(true,sequence.equals(transitivSortiert.transitivitaetAufloesen(transitivSortiert.getAbhaengigkeiten())));
	}
	
	@Test
	@DisplayName("Sequenz wird aufgrund von Transitivitaet abgelehnt")
	void testSequenzIsNotWellSortedBecauseOfTransitivitaet() {
		SortiertIF u  = new Sortiert({{"A","B"},{"B","C"}});
		String [] sequence = {"C","A"};
 		assertEquals(false,u.isWellSorted(sequence));
	}
	
	@Test
	@DisplayName("Dopplung wird erkannt")
	void testDopplungen() {
		String [] sequence = {"C","A","C"};
 		assertEquals(true,s.doppelteAufgabe(sequence));
	}
	
	@Test
	@DisplayName("Sequenz mit Dopplung wird abgelehnt")
	void testIsWellSortedDopplungen() {
		SortiertIF u  = new Sortiert({{"A","B"},{"C","D"}});
		String [] sequence = {"C","C","A"};
 		assertEquals(false,u.isWellSorted(sequence));
	}
	
}
