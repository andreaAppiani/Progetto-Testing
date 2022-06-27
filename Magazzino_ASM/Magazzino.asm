asm Magazzino

import StandardLibrary
//import CTLlibrary

signature:

	enum domain Prodotti = {LAMPADA | BICICLETTA}
	
	domain Quantita subsetof Integer
	domain Aggiunta subsetof Integer
	
	monitored prod_scelto : Prodotti
	monitored agg_scelta : Aggiunta
	
	controlled quantita : Prodotti -> Quantita
	
	derived tuttoPieno : Boolean

definitions:

	domain Quantita = {0,1,2,3,4,5}
	domain Aggiunta = {1,2}
	
	function tuttoPieno = (forall $p in Prodotti with quantita($p)=5)
	
	macro rule r_add1($p in Prodotti)=
		if quantita($p)<5 then quantita($p) := quantita($p)+1 endif
	
	rule r_add2($p in Prodotti)=
		if quantita($p)<4 then quantita($p) := quantita($p)+2 endif
	
	
	//Proprietà
	CTLSPEC (exist $p in Prodotti with ef(quantita($p)=5))
	CTLSPEC (forall $p in Prodotti with ag(quantita($p)=5 implies ag(quantita($p)=5)))
	//CTLSPEC ag(not tuttoPieno)
	CTLSPEC af(quantita(LAMPADA)>0 or quantita(BICICLETTA)>0)
	CTLSPEC ag(quantita(LAMPADA)>=0 and quantita(BICICLETTA)>=0)
	
	main rule r_main =
		
		if prod_scelto = LAMPADA and agg_scelta=1 then r_add1[LAMPADA]	
		else if prod_scelto = LAMPADA and agg_scelta=2 then r_add2[LAMPADA]
			else if prod_scelto = BICICLETTA and agg_scelta=1 then r_add1[BICICLETTA]
				else r_add2[BICICLETTA]
				endif
			endif
		endif
		
		
default init s0:
	function quantita($p in Prodotti) = 0
