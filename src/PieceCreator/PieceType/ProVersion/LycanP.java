package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Lycan;
import PieceCreator.PjeAbstractFactory;

public class LycanP extends Lycan {

	public LycanP(int ident){
		super();
		this.vida=140;
		this.ataque=30;
		this.vidaActual = 140;
		this.defensa = 15;
		this.x = -1;
		this.y = -1;
		this.nombre = "Licantropo Pro";
		this.id = ident+200;
	}

	
	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		return this.state.breed(this.id, Fabric);
	}
}
