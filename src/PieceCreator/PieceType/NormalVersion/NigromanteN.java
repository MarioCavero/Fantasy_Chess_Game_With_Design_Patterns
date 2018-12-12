package PieceCreator.PieceType.NormalVersion;

import PieceCreator.PieceType.Nigromante;

public class NigromanteN extends Nigromante {

	public NigromanteN(int ident){
		super();
		this.vida=80;
		this.ataque=30;
		this.vidaActual = 80;
		this.defensa = 7;
		this.x = -1;
		this.y = -1;
		this.nombre = "Nigromante Normal";
		this.id = ident;
	}
	
}
