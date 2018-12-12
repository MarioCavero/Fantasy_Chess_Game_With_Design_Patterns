package PieceCreator.PieceType.NormalVersion;

import PieceCreator.PieceType.Vampiro;

public class VampiroN extends Vampiro {

	public VampiroN(int ident){
		super();
		this.vida=100;
		this.ataque=20;
		this.vidaActual = 100;
		this.defensa = 8;
		this.x = -1;
		this.y = -1;
		this.nombre = "Vampiro Normal";
		this.id = ident;
	}
	
}
