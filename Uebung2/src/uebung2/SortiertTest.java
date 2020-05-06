package uebung2;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortiertTest {

	SortiertIF s, t;
	
	
	@BeforeEach
	protected void setUp() {
		String [][] p = {{ "A" , "C" },{ "C", "D" },{ "B", "C" }};
		s = new Sortiert(p);
	
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
	@DisplayName("Dopplung wird erkannt")
	void testDopplungen() {
		String [] sequence = {"C","A","C"};
 		assertEquals(true,s.doppelteAufgabe(sequence));
	}
	
	@Test
	@DisplayName("Dopplung wird nicht fälschlicherweise erkannt")
	void testKeineDopplungen() {
		String [] sequence = {"A","B","C","D"};
 		assertEquals(false,s.doppelteAufgabe(sequence));
	}
	
	@Test
	@DisplayName("Sequenz mit Dopplung wird abgelehnt")
	void testIsWellSortedDopplungen() {
		String[][] tmp = {{"A","B"},{"C","D"}};
		SortiertIF u  = new Sortiert(tmp);
		String [] sequence = {"C","C","A"};
 		assertEquals(false,u.isWellSorted(sequence));
	}
	
	@Test
	@DisplayName("Transitivitaet wird korrekt aufgeloest")
	void testTransitivitaet() {
		String [][] sequence = {{"A","B"},{"B","C"},{"D","E"},{"E", "F"},{"A","C"},{"D","F"}};
		String [][] x = {{"A","B"},{"B","C"},{"D","E"},{"E", "F"}};
		t = new Sortiert(x);
		assertEquals(true,Arrays.deepEquals(sequence,t.getAbhaengigkeiten()));
	}	
	
	@Test
	@DisplayName("Sequenz wird aufgrund von Transitivitaet abgelehnt")
	void testSequenzIsNotWellSortedBecauseOfTransitivitaet() {
		String[][] tmp = {{"A","B"},{"B","C"}};
		SortiertIF u  = new Sortiert(tmp);
		String [] sequence = {"C","A"};
 		assertEquals(false,u.isWellSorted(sequence));
	}
}
