package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.VampiroActions;

public abstract class Vampiro extends Pieza {

public Vampiro(){
		this.movement = new RookMovement();
		this.AttackAct = new VampiroActions();
	}
	
}
