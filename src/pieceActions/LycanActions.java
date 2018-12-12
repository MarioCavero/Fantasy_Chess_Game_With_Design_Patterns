package pieceActions;

import DataStructures.Pieza;

public class LycanActions extends Actions {


    @Override
    void specialEffect(Pieza enemigo, Pieza it) {
        System.out.println("Efecto pasivo!");
        System.out.println("Has aumentado tu ataque a \033[32m" + it.getAtaque()+3 + "\033[37m puntos");
        it.setAtaque(it.getAtaque()+3);
    }
}
