package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Vampiro;
import PieceCreator.PjeAbstractFactory;

public class VampiroP extends Vampiro {

	public VampiroP(int ident){
		super();
		this.vida=100;
		this.ataque=30;
		this.vidaActual = 100;
		this.defensa = 13;
		this.x = -1;
		this.y = -1;
		this.nombre = "Vampiro Pro";
		this.id = ident+600;
	}
	
	
	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		return this.state.breed(this.id, Fabric);
	}
}
