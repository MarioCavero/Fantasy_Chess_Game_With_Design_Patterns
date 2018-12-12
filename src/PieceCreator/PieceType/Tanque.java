package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.TanqueActions;

public abstract class Tanque extends Pieza {

public Tanque(){
		this.movement = new RookMovement();
		this.AttackAct = new TanqueActions();
	}
	
}
