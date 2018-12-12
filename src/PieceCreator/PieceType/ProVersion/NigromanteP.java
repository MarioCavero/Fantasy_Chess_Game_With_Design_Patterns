package PieceCreator.PieceType.ProVersion;

import DataStructures.Pieza;
import PieceCreator.PieceType.Nigromante;
import PieceCreator.PjeAbstractFactory;

public class NigromanteP extends Nigromante {

	public NigromanteP(int ident){
		super();
		this.vida=80;
		this.ataque=40;
		this.vidaActual = 80;
		this.defensa = 12;
		this.x = -1;
		this.y = -1;
		this.nombre = "Nigromante Pro";
		this.id = ident+400;
	}
	

	@Override
	public Pieza reproducirse(PjeAbstractFactory Fabric) {
		return this.state.breed(this.id, Fabric);
	}
}
