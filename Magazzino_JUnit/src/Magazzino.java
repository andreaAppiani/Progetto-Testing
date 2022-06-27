
public class Magazzino {

transient public int prodotti[];
	
	public Magazzino() {
		prodotti = new int[5]; //5 prodotti
		assert prodotti.length==5;
	}
	
	public boolean insert(int productIndex, int addQuantity) {
		if(!(productIndex>=0 && productIndex<prodotti.length)) return false;
		
		if(!(addQuantity>=1 && addQuantity<=10)) return false;
		
		if(prodotti[productIndex]+addQuantity > 100) return false;
		
		else {
			assert prodotti[productIndex]+addQuantity <= 100;
			prodotti[productIndex]+=addQuantity;
			return true;
		}
	}
	
	public boolean isFull(final int productIndex) {
		if(prodotti[productIndex] == 100) return true;
		else {
			assert prodotti[productIndex] != 100;
			return false;
		}
	}
	
	public boolean isFull() {
		for(int p : prodotti) {
			if(p < 100) return false;
		}
		
		for(int p : prodotti) {assert p == 100;}
		
		return true;
	}
}
