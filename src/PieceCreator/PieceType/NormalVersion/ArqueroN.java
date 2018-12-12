package PieceCreator.PieceType.NormalVersion;

import PieceCreator.PieceType.Arquero;

public class ArqueroN extends Arquero {
	
	public ArqueroN(int ident){
	
		super();
		this.vida=60;
		this.ataque=40;
		this.vidaActual = 60;
		this.defensa = 7;
		this.x = -1;
		this.y = -1;
		this.nombre = "Arquero Normal";
		this.id = ident;
	}

	
}
