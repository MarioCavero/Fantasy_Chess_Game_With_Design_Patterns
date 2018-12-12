package States;

import DataStructures.Pieza;
import PieceCreator.PjeAbstractFactory;
import pieceActions.*;
import Movement.Movement;
//Patron state para ver en que estado estan las piezas y ver si se pueden realizar las distintas
//acciones por pieza que permite el juego
public abstract interface State {

    void heal(Pieza aliado);
    void attack(Pieza enemigo, Actions AttackAct, Pieza it);
    void move(Pieza it, int x, int y);
    Pieza combine(Pieza aliado, Pieza it);
    Movement changeMovement(Movement newMovement);
    Pieza breed(int id, PjeAbstractFactory Fabric);

}
