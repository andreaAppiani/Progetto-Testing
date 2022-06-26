import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_Decisioni {

	@Test
	void testInsert() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.insert(-1, 5));		// [TEST CASE 1]
		
		assertFalse(M.insert(0, 0));		// [TEST CASE 2]
		
		assertTrue(M.insert(0, 5));			// [TEST CASE 3]
		
		// Test per avere Falsa la decisione prodotti[productIndex]+addQuantity > 100
		for(int i=0; i<10; i++) M.insert(0, 10);	
		assertFalse(M.insert(0, 10));
	}
	
	@Test
	void testIsFull() {
		
		Magazzino M = new Magazzino();
		
		assertFalse(M.isFull()); //testo la decisione Falsa
		
		for(int i=0; i<M.prodotti.length; i++) {
			for(int j=0; j<10; j++)	
				M.insert(i, 10);
		}
		
		assertTrue(M.isFull());	//testo la decisione Vera
		
		
	}

}
