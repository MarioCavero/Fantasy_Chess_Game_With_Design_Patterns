package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.MagoActions;

public abstract class Mago extends Pieza {

public Mago(){
		this.movement = new RookMovement();
		this.AttackAct = new MagoActions();
	}

}
