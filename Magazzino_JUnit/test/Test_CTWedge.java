import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test_CTWedge {

	@Test
	void test() {
		Magazzino M = new Magazzino();
		
		assertFalse(M.insert(0, 0));
	}

}
