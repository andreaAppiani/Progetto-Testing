import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Test_Parametrico {
	
	int index; int quantity;
	boolean outputAtteso;
	private Magazzino M;
	
	@Before
	public void initialize() {
		M = new Magazzino();
	}
	
	public Test_Parametrico(int i1, int i2, boolean o){
		index = i1; quantity = i2; outputAtteso = o;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> creaParametri(){
		return Arrays.asList(new Object[][] { 
			{ -1, 5, false }, 
			{ 0, 0, false }, 
			{ 0, 5, true }});
	}
	
	@ParameterizedTest
	public void Test_Insert() {
		boolean outputEffettivo = M.insert(index, quantity);
		System.out.println("input: " + index + "|"+quantity +"  --> res=" + outputEffettivo);
		assertEquals(outputAtteso, outputEffettivo);
	}
}
