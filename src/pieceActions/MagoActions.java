package pieceActions;

import DataStructures.Pieza;

public class MagoActions extends Actions{


    @Override
    void specialEffect(Pieza enemigo, Pieza it) {
        System.out.println("Efecto pasivo!");
        System.out.println("Se ha \033[34mparalizado\033[37m al enemigo y a ti mismo! debes curarlos para \033[36mdesparalizarlos\033[37m");
        enemigo.setState(enemigo._PARALIZADO);
        it.setState(it._PARALIZADO);
    }
}
