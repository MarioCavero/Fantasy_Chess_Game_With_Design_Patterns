package PieceCreator.PieceType;
import DataStructures.Pieza;
import Movement.RookMovement;
import pieceActions.NigromanteActions;

public abstract class Nigromante extends Pieza {

public Nigromante(){
		this.movement = new RookMovement();
		this.AttackAct = new NigromanteActions();
	}

}
