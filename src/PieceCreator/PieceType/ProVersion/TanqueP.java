package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Tanque;
import PieceCreator.PjeAbstractFactory;

public class TanqueP extends Tanque {

	public TanqueP(int ident) {
		super();
		this.vida=200;
		this.ataque=20;
		this.vidaActual = 200;
		this.defensa = 20;
		this.x = -1;
		this.y = -1;
		this.nombre = "Tanque Pro";
		this.id = ident+500;
	}

	
	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		return this.state.breed(this.id, Fabric);
	}
	
}
