package pieceActions;

import DataStructures.Pieza;

import java.util.Random;

public class ArqueroActions extends Actions {


    @Override
    void specialEffect(Pieza enemigo, Pieza it) {
        Random random = new Random();
        int prob = random.nextInt(10);
        if(prob < 4)
        {
            int daño = it.getAtaque() - enemigo.getDefensa();
            System.out.println("Efecto pasivo!");
            System.out.println("Has hecho \033[31m" + daño + "\033[37m puntos de ataque al enemigo");
            if(daño > 0){
                enemigo.setVidaActual(enemigo.getVidaActual()-daño);
                if(enemigo.getVidaActual() < enemigo.getVida()/2)
                {
                    System.out.println("El enemigo se ha puesto \033[31mfurioso\033[37m");
                    enemigo.setState(enemigo._FURIOSO);
                }
            }
        }
    }
}
