package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Arquero;
import PieceCreator.PjeAbstractFactory;

public class ArqueroP extends Arquero {

	public ArqueroP(int ident){
		super();
		this.vida=60;
		this.ataque=50;
		this.vidaActual = 60;
		this.defensa = 12;
		this.x = -1;
		this.y = -1;
		this.nombre = "Arquero Pro";
		this.id = ident+100;
	}

	
	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
	return this.state.breed(this.id, Fabric);
	}
}
