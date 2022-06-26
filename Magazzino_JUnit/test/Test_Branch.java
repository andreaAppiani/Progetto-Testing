import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_Branch {

	@Test
	void testInsert() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.insert(-1, 5));		// [TEST CASE 1]
		
		assertFalse(M.insert(0, 0));		// [TEST CASE 2]
		
		assertTrue(M.insert(0, 5));			// [TEST CASE 3]
		
		for(int i=0; i<10; i++) M.insert(0, 10);	
		assertFalse(M.insert(0, 10));		// per il Branch return False finale
	}

	@Test
	void testIsFull_prodotto() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.isFull(0));		// per il Branch return False di isFull(index)
		
		for(int i=0; i<10; i++) M.insert(0, 10);	
		assertTrue(M.isFull(0));		// per il Branch return True di isFull(index)
	}
	
	@Test
	void testIsFull() {
		Magazzino M = new Magazzino();
		
		for(int i=0; i<10; i++) M.insert(0, 10);
		
		assertFalse(M.isFull());	// per i branch del loop "for" e il return false
		
		for(int i=1; i<M.prodotti.length; i++) {
			for(int j=0; j<10; j++)	
				M.insert(i, 10);
		}
		assertTrue(M.isFull());	// per il branch return true rimanente
	}
}
