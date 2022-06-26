asm Magazzino

import StandardLibrary

signature:

	enum domain Prodotti = {LAMPADA | BICICLETTA}
	
	domain Quantita subsetof Integer
	domain Aggiunta subsetof Integer
	
	monitored prod_scelto : Prodotti
	monitored agg_scelta : Aggiunta
	
	controlled quantita : Prodotti -> Quantita

definitions:

	domain Quantita = {0,1,2,3,4,5}
	domain Aggiunta = {1,2}
	
	macro rule r_add1($p in Prodotti)=
		if quantita($p)<5 then quantita($p) := quantita($p)+1 endif
	
	rule r_add2($p in Prodotti)=
		if quantita($p)<4 then quantita($p) := quantita($p)+2 endif
	
	
	main rule r_main =
		if prod_scelto = LAMPADA then
			if agg_scelta=1 then r_add1[LAMPADA] else r_add2[LAMPADA]
			endif
					
		else if agg_scelta=1 then r_add1[BICICLETTA] else r_add2[BICICLETTA] 
			 endif		
			
		endif
	
	
	
default init s0:
	function quantita($p in Prodotti) = 0