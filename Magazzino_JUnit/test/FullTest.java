import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FullTest {

	// Scenario in cui il Magazzino si riempie del tutto
	
		@Test
		void test() {
			Magazzino M = new Magazzino();
			
			assertFalse(M.isFull(0));
			
			for(int i=0; i<10;i++)	{
				M.insert(0, 10);
				M.insert(1, 10);
				M.insert(2, 10);
				M.insert(3, 10);
				M.insert(4, 10);
			}	
			
			assertTrue(M.isFull(0));
			
			assertTrue(M.isFull());
		}

}
