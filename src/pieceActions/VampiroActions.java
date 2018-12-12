package pieceActions;

import DataStructures.Pieza;

public class VampiroActions extends Actions {


    @Override
    void specialEffect(Pieza enemigo, Pieza it) {
        int drenaje = it.getAtaque()/2;
        System.out.println("Efecto pasivo!");
        System.out.println("Has drenado \033[35m" + drenaje + "\033[37m puntos a tu vida");
        int nuevaVida = (it.getVidaActual()+drenaje);
        if(nuevaVida < it.getVida()) {
            it.setVidaActual(nuevaVida);
        }
        else
        {
            it.setVidaActual(it.getVida());
        }
    }
}
