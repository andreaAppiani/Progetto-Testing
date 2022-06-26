
public class Magazzino {

public int prodotti[];
	
	public Magazzino() {
		prodotti = new int[5]; //5 prodotti
		int i;
		if(prodotti == null) i = prodotti.length;
	}
	
	public boolean insert(int productIndex, int addQuantity) {
		if(!(productIndex>=0 && productIndex<prodotti.length)) return false;
		
		if(!(addQuantity>=1 && addQuantity<=10)) return false;
		
		if(prodotti[productIndex]+addQuantity > 100) return false;
		
		else {
			prodotti[productIndex]+=addQuantity; return true;
		}
	}
	
	public boolean isFull(int productIndex) {
		if(prodotti[productIndex] == 100) return true;
		else return false;
	}
	
	public boolean isFull() {
		for(int i=0; i<prodotti.length;i++) {
			if(prodotti[i] < 100) return false;
		}
		return true;
	}
}
