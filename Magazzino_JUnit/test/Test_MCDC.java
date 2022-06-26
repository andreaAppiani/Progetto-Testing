import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_MCDC {

	/*
	 * Osservo che nella copertura "TERM" è al 100% per il metodo insert()
	 * (questo perchè corrisponde al MCDC)
	 */
	
	@Test
	void test() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.insert(-1, 5));		// [TEST CASE 1]
		
		assertFalse(M.insert(0, 0));		// [TEST CASE 2]
		
		assertTrue(M.insert(0, 5));			// [TEST CASE 3]
		
		assertFalse(M.insert(10, 5));		// [TEST CASE 4]
		
		assertFalse(M.insert(0, 50));		// [TEST CASE 4]
		
		for(int i=0; i<10; i++) M.insert(1, 10);
		
		assertFalse(M.insert(1, 5));		// per coprire l'ultimo caso
		
	}
}
