package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.ArqueroActions;

public abstract class Arquero extends Pieza {

	public Arquero(){
		this.movement = new RookMovement();
		this.AttackAct = new ArqueroActions();
	}
	
	
	
}
