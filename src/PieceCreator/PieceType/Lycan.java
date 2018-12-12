package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.LycanActions;

public abstract class Lycan extends Pieza {

public Lycan(){
		this.movement = new RookMovement();
		this.AttackAct = new LycanActions();
	}
	

}
