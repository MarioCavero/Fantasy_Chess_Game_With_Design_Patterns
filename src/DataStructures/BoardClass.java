package DataStructures;

import Movement.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardClass {

    PlayerClass player1 = new PlayerClass(1);
    PlayerClass player2 = new PlayerClass(2);

    int turn = 0;

    public BoardClass() {

        for(int i = 0; i < player1.getPiecesToUse().size(); i++)
        {
            player1.getPiecesToUse().get(i).setX(i+1);
            player1.getPiecesToUse().get(i).setY(0);
            player2.getPiecesToUse().get(i).setX(i+1);
            player2.getPiecesToUse().get(i).setY(7);
        }
    }

    public void showBoard()
    {
        System.out.println("Piezas del jugador 1:");
        for(int i = 0; i < player1.getPiesas().size(); i++)
        {
            System.out.println("\033[37m" + (i+1) + ". " + player1.piesas.get(i).getNombre() +"\033[35m Vida: "+ player1.piesas.get(i).getVidaActual()+"\033[34m posicion: [ "+player1.piesas.get(i).getX()+", " +player1.piesas.get(i).getY() + " ]" );
        }
        System.out.println("\033[37m" + "\n\nPiezas del jugador 2:");
        for(int i = 0; i < player2.getPiesas().size(); i++)
        {
            System.out.println("\033[37m" + (i+1) + ". " + player2.piesas.get(i).getNombre() +"\033[35m Vida: "+ player2.piesas.get(i).getVidaActual()+"\033[34m posicion: [ "+player2.piesas.get(i).getX()+", " +player2.piesas.get(i).getY() + " ]" );

        }
        System.out.println("\n\n\n" + "\033[37m");
        /*
        System.out.print("Piezas del jugador 1:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.print("Piezas del jugador 2: ");
        //Hacemos esto para que quede una interfaz de impresion mas o menos bonita a la vez que funcional
        System.out.println(" ");
        if(player1.piesas.size()>player2.piesas.size()) {

            for(int i=0;i<player1.piesas.size();i++) {
                if(i<player2.piesas.size()) {
                    System.out.print((i+1) + ". " + player1.piesas.get(i).getNombre() +" Vida: "+ player1.piesas.get(i).getVidaActual()+" posicion: [ "+player1.piesas.get(i).getX()+", " +player1.piesas.get(i).getY() + " ]\t\t\t\t\t\t\t\t\t\t\t" );
                    System.out.print((i+1) + ". " + player2.piesas.get(i).getNombre() +" Vida: "+ player2.piesas.get(i).getVidaActual()+" posicion: [ "+player2.piesas.get(i).getX()+", " +player2.piesas.get(i).getY() + " ]" );
                    System.out.println("");
                }
                else {
                    System.out.print((i+1) + ". " + player1.piesas.get(i).getNombre() +" Vida: "+ player1.piesas.get(i).getVidaActual()+" posicion: [ "+player1.piesas.get(i).getX()+", " +player1.piesas.get(i).getY() + " ]" );
                    System.out.println("");

                }
            }
        }
        else if(player2.piesas.size()>player1.piesas.size()) {

            for(int i=0;i<player2.piesas.size();i++) {
                if(i<player1.piesas.size()) {
                    System.out.print((i+1) + ". " + player1.piesas.get(i).getNombre() +" Vida: "+ player1.piesas.get(i).getVidaActual()+" posicion: [ "+player1.piesas.get(i).getX()+", " +player1.piesas.get(i).getY() + " ]\t\t\t\t\t\t\t\t\t\t\t" );
                    System.out.print((i+1) + ". " + player2.piesas.get(i).getNombre() +" Vida: "+ player2.piesas.get(i).getVidaActual()+" posicion: [ "+player2.piesas.get(i).getX()+", " +player2.piesas.get(i).getY() + " ]" );
                    System.out.println("");
                }
                else {
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                    System.out.print((i+1) + ". " + player2.piesas.get(i).getNombre() +" Vida: "+ player2.piesas.get(i).getVidaActual()+" posicion: [ "+player2.piesas.get(i).getX()+", " +player2.piesas.get(i).getY() + " ]" );
                    System.out.println("");
                }
            }
        }
        else {
            for(int i=0;i<player1.piesas.size();i++) {

                System.out.print((i+1) + ". " + player1.piesas.get(i).getNombre() +" Vida: "+ player1.piesas.get(i).getVidaActual()+" posicion: [ "+player1.piesas.get(i).getX()+", " +player1.piesas.get(i).getY() + " ]\t\t\t\t\t\t\t\t\t\t\t" );
                System.out.print((i+1) + ". " + player2.piesas.get(i).getNombre() +" Vida: "+ player2.piesas.get(i).getVidaActual()+" posicion: [ "+player2.piesas.get(i).getX()+", " +player2.piesas.get(i).getY() + " ]" );
                System.out.println("");
            }
        }
        */

    }

    public void showOptions() {

        System.out.println("\033[34m" + "1: Moverse");
        System.out.println("\033[31m" + "2: Atacar");
        System.out.println("\033[35m" + "3: Curar");
        System.out.println("\033[32m" + "4: Combinarse");
        System.out.println("\033[33m" + "5: Cambiar de Movimiento");
        System.out.println("\033[36m" + "6. Reproducirse" + "\033[37m");
    }

    public PlayerClass nextTurn()
    {
        if(player1.getPiecesToUse().size() != 0)
        {
            if(turn == 0 || player2.getPiecesToUse().size() == 0) {
                turn = 1;
                return player1;
            }
        }
        if(player2.getPiecesToUse().size() != 0)
        {
            if(turn == 1 || player1.getPiecesToUse().size() == 0) {
                turn = 0;
                return player2;
            }
        }
        return null;
    }

    public PlayerClass getEnemie(){
        if(turn == 0){
            return player1;
        }
        else if(turn == 1){
            return player2;
        }
        else
            return null;
    }

    public void newRound()
    {
        player1.resetRound();
        player2.resetRound();
    }

    public boolean isEmpty(int x, int y){
        for(int i = 0; i < player1.piesas.size(); i++)
        {
            if(player1.piesas.get(i).getX() == x && player1.piesas.get(i).getY() == y)
                return false;
        }
        for(int i = 0; i < player2.piesas.size(); i++)
        {
            if(player2.piesas.get(i).getX() == x && player2.piesas.get(i).getY() == y)
                return false;
        }
        return true;
    }

    public Movement selectMovement() {
        //llamar funcion que printea movimientos. pedirle al usuario que cual quiere
        Movement movimiento=null;;
        showMovements();
        int a=-1;
        Scanner S=new Scanner(System.in);
        while(a<1||a>4) {
            try {
                System.out.println("Que movimiento quiere? (1,2,3 o 4)");

                a=S.nextInt();

            } catch (InputMismatchException ime) {
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                S.next();
            }
        }

        switch (a) {
            case 1:
                movimiento=new BishopMovement();
                break;
            case 2:
                movimiento=new HorseMovement();
                break;
            case 3:
                movimiento=new RookMovement();
                break;
            case 4:
                movimiento=new QueenMovement();
                break;
        }
        return movimiento;
    }

    public void showMovements() {
        System.out.println("Hay los siguientes movimientos: ");
        System.out.println("Movimiento 1. Alfil");
        System.out.println("Movimiento 2. Caballo");
        System.out.println("Movimiento 3. Torre");
        System.out.println("Movimiento 4. Reina Presumida");
    }

    public void showPiezasToUse(PlayerClass player){

        System.out.println("Piezas que se pueden utilizar: ");
        for(int i=0;i<player.getPiecesToUse().size();i++) {
            System.out.println((i+1) + ". " + player.getPiecesToUse().get(i).getNombre());
        }
    }

}
