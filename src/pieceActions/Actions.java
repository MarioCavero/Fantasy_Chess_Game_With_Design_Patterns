package pieceActions;

import DataStructures.Pieza;
//El patron template method se usa para poder implementar las distintas acciones de las piezas
//Tiene unos metodos pre-determinados de acciones que segun la clase, se implementaran de una manera
//o de otra
public abstract class Actions {
    final public void attack(Pieza enemigo, Pieza it)
    {
        hurt(enemigo, it);
        specialEffect(enemigo, it);
    }

    final void hurt(Pieza enemigo, Pieza it)//sobre escribir arquero etc.
    {
        int daño = it.getAtaque() - enemigo.getDefensa();
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
    abstract void specialEffect(Pieza enemigo, Pieza it);
}
