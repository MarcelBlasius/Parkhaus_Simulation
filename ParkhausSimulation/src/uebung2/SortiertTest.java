package uebung2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortiertTest {

	SortiertIF s;
	
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
}
