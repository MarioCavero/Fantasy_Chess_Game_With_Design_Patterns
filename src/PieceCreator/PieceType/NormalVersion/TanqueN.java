package PieceCreator.PieceType.NormalVersion;

import PieceCreator.PieceType.Tanque;

public class TanqueN extends Tanque {

	public TanqueN(int ident) {
		super();
		this.vida=200;
		this.ataque=10;
		this.vidaActual = 200;
		this.defensa = 15;
		this.x = -1;
		this.y = -1;
		this.nombre = "Tanque Normal";
		this.id = ident;
	}
	
	
	
}

