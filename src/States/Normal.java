package States;

import DataStructures.Pieza;
import DataStructures.SuperPieza;
import Movement.Movement;
import PieceCreator.PjeAbstractFactory;
import pieceActions.Actions;

public class Normal implements State {

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
                System.out.println("Has curado a tu aliado \033[35m" + (nuevaVida - aliado.getVidaActual()) + " puntos\033[37m y esta normal");
                aliado.setState(aliado._NORMAL);
            }
        }
        else
            System.out.println("Error State: curar aliado null");
    }

    @Override
    public void attack(Pieza enemigo, Actions attackAct, Pieza it) {
        if(enemigo != null && it != null)
            attackAct.attack(enemigo, it);
        else
            System.out.println("Error state: piezas null al atacar");
    }

    @Override
    public void move(Pieza me,int x, int y) {
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
        int type = id/100;
        Pieza nuevaPieza;
        switch (type)
        {
            case 1:
                nuevaPieza = Fabric.crearArquero();
                break;
            case 2:
                nuevaPieza = Fabric.crearLycan();
                break;
            case 3:
                nuevaPieza = Fabric.crearMago();
                break;
            case 4:
                nuevaPieza = Fabric.crearNigromante();
                break;
            case 5:
                nuevaPieza = Fabric.crearTanque();
                break;
            case 6:
                nuevaPieza = Fabric.crearVampiro();
                break;
            default:
                nuevaPieza = null;
                break;
        }
        return nuevaPieza;
    }
}
