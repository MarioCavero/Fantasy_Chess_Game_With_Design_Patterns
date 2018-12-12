package States;

import DataStructures.Pieza;
import Movement.Movement;
import PieceCreator.PjeAbstractFactory;
import pieceActions.Actions;

public class immobilized implements State {

    @Override
    public void heal(Pieza aliado) {
        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");
    }

    @Override
    public void attack(Pieza enemigo, Actions attackAct, Pieza it) {
        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");    }

    @Override
    public void move(Pieza me, int x, int y) {
        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");    }

    @Override
    public Pieza combine(Pieza aliado, Pieza me) {
        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");
        return null;
    }

    @Override
    public Movement changeMovement(Movement newMovement) {
        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");
        return null;
    }

    @Override
    public Pieza breed(int id, PjeAbstractFactory Fabric) {

        System.out.println("\033[34mEstas inmovilizado!\033[37m Dejaras de estarlo en cuanto un aliado te cure");
        return null;
    }
}
