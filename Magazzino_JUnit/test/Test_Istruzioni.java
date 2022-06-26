import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_Istruzioni {

	@Test
	void testInsert() {
		Magazzino M = new Magazzino();
			
		assertFalse(M.insert(-1, 5));		// [TEST CASE 1]
		
		assertFalse(M.insert(0, 0));		// [TEST CASE 2]
		
		assertTrue(M.insert(0, 5));			// [TEST CASE 3]
		
		for(int i=0; i<10; i++) M.insert(0, 10);
		
		assertFalse(M.insert(0, 10));//testa il return False di prodotti[i]+quantity>100
		
	}
	
	@Test
	void testIsFull_prodotto() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.isFull(0));	//testa return False
		
		for(int i=0; i<10; i++) M.insert(0, 10);
		
		assertTrue(M.isFull(0));	//testa return True
		
	}

	@Test
	void testIsFull() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.isFull());
		
		for(int i=0; i<M.prodotti.length; i++) {
			for(int j=0; j<10; j++)	
				M.insert(i, 10);
		}
		
		assertTrue(M.isFull());
	}
}
