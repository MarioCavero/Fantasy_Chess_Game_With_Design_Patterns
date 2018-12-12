package States;

import DataStructures.Pieza;
import DataStructures.SuperPieza;
import Movement.Movement;
import PieceCreator.PjeAbstractFactory;
import pieceActions.Actions;

public class Furious implements State {

    @Override
    public void heal(Pieza aliado) {
        if(aliado != null) {
            int nuevaVida = (aliado.getVidaActual() + aliado.getVida() / 10);
            if (nuevaVida < aliado.getVida()) {
                aliado.setVidaActual(nuevaVida);
            } else {
                aliado.setVidaActual(aliado.getVida());
            }
            if (nuevaVida < aliado.getVida() / 2) {
                System.out.println("Has curado a tu aliado \033[35m" + (nuevaVida - aliado.getVidaActual()) + "\033[37m pero sigue \033[31mfurioso\033[37m");
                aliado.setState(aliado._FURIOSO);
            } else {
                System.out.println("Has curado a tu aliado \033[35m" + (nuevaVida - aliado.getVidaActual()) + "\033[37m y esta normal");
                aliado.setState(aliado._NORMAL);
            }
        }
        else
            System.out.println("Error State: curar aliado null");
    }

    @Override
    public void attack(Pieza enemigo, Actions attackAct, Pieza it) {
        if(enemigo != null && it != null) {
            attackAct.attack(enemigo, it);
            attackAct.attack(enemigo, it);
        }
        else
            System.out.println("Error state: piezas null al atacar");
    }

    @Override
    public void move(Pieza me, int x, int y) {
        me.setX(x);
        me.setY(y);
    }

    @Override
    public Pieza combine(Pieza aliado, Pieza me) {

        SuperPieza newSuper = new SuperPieza(aliado, me);
        return newSuper;
    }

    @Override
    public Movement changeMovement(Movement newMovement) {
        return newMovement;
    }

    @Override
    public Pieza breed(int id, PjeAbstractFactory Fabric) {
        System.out.println("Estas demasiado furioso para tener hijos");
        return null;
    }
}
