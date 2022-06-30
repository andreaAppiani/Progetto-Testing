
public class MagazzinoJML {

	public int prodotti[];
	
	//@ public invariant prodotti!=null;
	//@ public invariant prodotti.length==5;
	//@ public invariant (\forall int i; i>=0 && i<prodotti.length; prodotti[i]>=0 && prodotti[i]<=100);
	
	//@ requires true;
	//@ ensures prodotti.length==5;
	public MagazzinoJML() {
		prodotti = new int[5]; 
		//prodotti = new int[10];	violazione della postcondizione
	}
	
	//@ requires productIndex>=0 && productIndex<prodotti.length;
	//@ requires addQuantity>=1 && addQuantity<=10;
	
	//@ requires (\exists int i; i>=0 && i<prodotti.length; prodotti[i]<=100);
	
	//@ ensures !(productIndex>=0 && productIndex<prodotti.length) 	==> \result==false;
	//@ ensures !(addQuantity>=1 && addQuantity<=10) 				==> \result==false;
	//@ ensures (prodotti[productIndex]+addQuantity > 100) 			==> \result==false;
	//@ ensures \result==true <==> (prodotti[productIndex]+addQuantity)<=100;
	//@ ensures \result==true <==> prodotti[productIndex] == \old(prodotti[productIndex])+addQuantity;
	
	//@ ensures (\sum int i; i>=0 && i<prodotti.length; prodotti[i])/prodotti.length <= 100;
	//@ ensures (\forall int i; i>=0 && i<prodotti.length && i!=productIndex; prodotti[i]==\old(prodotti[i]));
	public boolean insert(int productIndex, int addQuantity) {

		//ho spostato i primi "IF" nelle prime due Precondizioni.
		
		if(prodotti[productIndex]+addQuantity > 100) return false;
		
		else {
			prodotti[productIndex]+=addQuantity; return true;
			// prodotti[productIndex]+= 5;		violerebbe la postcondizione
		}
	}
	
	//@ requires productIndex>=0 && productIndex<prodotti.length;
	//@ ensures \result==true ==> (prodotti[productIndex] == 100); 
	//@ ensures \result==false ==> (prodotti[productIndex] != 100);
	//@ pure
	public boolean isFull(int productIndex) {
		if(prodotti[productIndex] == 100) return true;
		// if(false) return true;		violazione della Postcondizione solo se il prodotto è pieno
		else return false;
	}
	
	//@ requires true;
	//@ ensures \result==true <==> (\forall int i; i>=0 && i<prodotti.length; prodotti[i]==100);
	//@ ensures \result==false <==> (\exists int i; i>=0 && i<prodotti.length; prodotti[i]<100);
	//@ diverges true;
	//@ pure
	public boolean isFull() {
		//@ loop_invariant i>=0 && i<=prodotti.length;
		//@ loop_invariant (\forall int j;j>=0 && j<i; prodotti[j]==100);
		for(int i=0; i<prodotti.length;i++) {
			if(prodotti[i] < 100) return false;
			// if(true) return false;	violazione della Postcondizione (ma solo se i prodotti sono tutti pieni)
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	MagazzinoJML M = new MagazzinoJML();
	
	M.insert(0, 10);	//inserimento corretto
	System.out.println(M.prodotti[0]);
	
	M.insert(0, 20);	//violazione della precondizione
	System.out.println(M.prodotti[0]);
	
	M.insert(-1, 5);	//violazione della precondizione
	System.out.println(M.prodotti[0]);
		
	M.isFull(-1);		//violazione della precondizione di isFull(int)
		
	}
}
