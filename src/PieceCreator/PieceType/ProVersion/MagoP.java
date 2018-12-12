package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Mago;
import PieceCreator.PjeAbstractFactory;

public class MagoP extends Mago {

	public MagoP(int ident) {
		super();
		this.vida=50;
		this.ataque=80;
		this.vidaActual = 50;
		this.defensa = 12;
		this.x = -1;
		this.y = -1;
		this.nombre = "Mago Pro";
		this.id = ident+300;
	}
	
	
	
	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		return this.state.breed(this.id, Fabric);
	}
}
