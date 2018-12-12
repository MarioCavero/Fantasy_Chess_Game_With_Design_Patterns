package pieceActions;

import DataStructures.Pieza;

public class NigromanteActions extends Actions {


    @Override
    void specialEffect(Pieza enemigo, Pieza it) {
        if(enemigo.getVidaActual() <=0) {
            System.out.println("Efecto pasivo!");
            System.out.println("Obtienes el alma de tu enemigo... aumentas\033[31m 5 puntos \037[31mde daño a tu ataque");
            it.setAtaque(it.getAtaque() + 5);
        }
    }
}
