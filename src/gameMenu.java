import DataStructures.BoardClass;
import DataStructures.Pieza;
import DataStructures.PlayerClass;
import Movement.Movement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class gameMenu {
	
    public static Pieza searchEnemy(PlayerClass playerTurn, int pieza, PlayerClass enemie) {
		Pieza enemigo;
        int xTemp=playerTurn.getPiecesToUse().get(pieza-1).getX();
        int yTemp=playerTurn.getPiecesToUse().get(pieza-1).getY();

        for(int i=0;i<enemie.getPiesas().size();i++) {
            if(xTemp-1==enemie.getPiesas().get(i).getX()&&yTemp==enemie.getPiesas().get(i).getY()) {

                enemigo=enemie.getPiesas().get(i);
                return enemigo;
            }
            else if(xTemp+1==enemie.getPiesas().get(i).getX()&&yTemp==enemie.getPiesas().get(i).getY()){
                enemigo=enemie.getPiesas().get(i);
                return enemigo;
            }
            else if(xTemp==enemie.getPiesas().get(i).getX()&&yTemp+1==enemie.getPiesas().get(i).getY()){
                enemigo=enemie.getPiesas().get(i);
                return enemigo;
            }
            else if(xTemp==enemie.getPiesas().get(i).getX()&&yTemp-1==enemie.getPiesas().get(i).getY()){
                enemigo=enemie.getPiesas().get(i);
                return enemigo;

            }


        }

        return (null);
	}
    public static Pieza searchAlly(PlayerClass playerTurn, int pieza ) {
       Pieza ally;
	   int xTemp=playerTurn.getPiecesToUse().get(pieza-1).getX();
	   int yTemp=playerTurn.getPiecesToUse().get(pieza-1).getY();
   
        for(int i=0;i<playerTurn.getPiesas().size();i++) {
            if(xTemp-1==playerTurn.getPiesas().get(i).getX()&&yTemp==playerTurn.getPiesas().get(i).getY()) {

                ally=playerTurn.getPiesas().get(i);
                return ally;
            }
            else if(xTemp+1==playerTurn.getPiesas().get(i).getX()&&yTemp==playerTurn.getPiesas().get(i).getY()){
                ally=playerTurn.getPiesas().get(i);
                return ally;
            }
            else if(xTemp==playerTurn.getPiesas().get(i).getX()&&yTemp+1==playerTurn.getPiesas().get(i).getY()){
                ally=playerTurn.getPiesas().get(i);
                return ally;
            }
            else if(xTemp==playerTurn.getPiesas().get(i).getX()&&yTemp-1==playerTurn.getPiesas().get(i).getY()){
                ally=playerTurn.getPiesas().get(i);
                return ally;

            }


        }
	   
	  return (null);
   }
    public static String whereToMove(PlayerClass player, int pieza, BoardClass tablero){

        Pieza actualPz = player.getPiecesToUse().get(pieza-1);
        ArrayList<String> moves = null;
        Movement move;
        move = actualPz.getMovement();
        if(move != null)
            moves = move.moveOptions(actualPz.getX(), actualPz.getY());
        else
            System.out.println("Error calcular movimientos: Movement es null");

        if(moves == null) {
            System.out.println("Error calcular movimientos: no hay movimientos");
            return null;
        }

        Scanner reader = new Scanner(System.in);
        int option = -1;
        System.out.println("Destinos disponibles: ");
        for(int i = 0; i< moves.size(); i++)
        {
            int tempX = Integer.parseInt(moves.get(i))/10;
            int tempY = (Integer.parseInt(moves.get(i))- (tempX*10));
            if(tablero.isEmpty(tempX, tempY))
                System.out.println(i+1 + ". " + "[ " + tempX + ", " + tempY + " ]");
            else {
                moves.remove(i);
                i--;
            }
        }

        while(option==-1) {
            try {
                System.out.println("Elija una opcion introduciendo su numero: ");
                option = reader.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("¡Cuidado! Solo puedes insertar números. ");
                reader.next();
            }
            if(option < 1 || option > moves.size())
            {
                System.out.println("Esa opcion no es valida...");
                option = -1;
            }
        }

        return moves.get(option-1);
    }

    public static void main (String [ ] args) {

        boolean exit = false;

        Scanner reader = new Scanner(System.in);

        BoardClass tablero = new BoardClass();
        PlayerClass playerTurn;
        System.out.println("COMIENZA EL JUEGO!!");
        while(!exit)
        {
            System.out.println("El juego continuará en 5 segundos");
            try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e ){
                System.out.println("Thread Interrupted");
            }
            int option = -1;
            int pieza = -1;
            tablero.showBoard();
            playerTurn = tablero.nextTurn();
            if(playerTurn == null){
                tablero.newRound();
                playerTurn = tablero.nextTurn();
            }
            System.out.println("Turno del jugador " + playerTurn.getnPlayer());
            tablero.showOptions();

            while(option==-1) {
                try {
                    System.out.println("Elija una opcion introduciendo su numero: ");
                    option = reader.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("¡Cuidado! Solo puedes insertar números. ");
                    reader.next();
                }
                if(option < 0 || option > 6)
                {
                    System.out.println("Esa opcion no es valida...");
                    option = -1;
                }
            }
            tablero.showPiezasToUse(playerTurn);
            while(pieza==-1) {
                try {
                    System.out.println("Elija una pieza introduciendo su numero: ");
                    pieza = reader.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("¡Cuidado! Solo puedes insertar números. ");
                    reader.next();
                }
                if(pieza < 1 || pieza > playerTurn.getPiecesToUse().size())
                {
                    System.out.println("Esa opcion no es valida...");
                    pieza = -1;
                }
            }

            switch (option)
            {
                case 0:
                    exit = true;
                    break;
                case 1:
                    String codiCoord = whereToMove(playerTurn, pieza, tablero);
                    if(codiCoord != null) {
                        int tempX = Integer.parseInt(codiCoord) / 10;
                        int tempY = (Integer.parseInt(codiCoord) - (tempX * 10));
                        playerTurn.getPiecesToUse().get(pieza - 1).moverse(tempX, tempY);
                    }
                    else
                        System.out.println("Error al moverse (main): no hay coordenadas seleccionadas");
                    break;
                case 2:
                    Pieza enemigo = searchEnemy(playerTurn, pieza, tablero.getEnemie());
                    if(enemigo != null)
                    {
                        playerTurn.getPiecesToUse().get(pieza-1).ataque(enemigo);
                        if(enemigo.getVidaActual() <= 0)
                        {
                            enemigo.notifyObservers();
                            tablero.getEnemie().removePiece(enemigo.getId());
                        }
                    }
                    else {
                        System.out.println("No hay enemigos cerca");
                    }
                    break;
                case 3:
                	Pieza aliado;
                	aliado=searchAlly(playerTurn, pieza);
                	if(aliado!=null) {
                        System.out.println("vamos a curar a " + aliado.getId() + aliado.getNombre());
                        playerTurn.getPiecesToUse().get(pieza-1).curar(aliado);
                	}
                	else System.out.println("No hay pieza a la que curar.");
                    break;
                case 4:
                	Pieza combinado;
                	combinado=searchAlly(playerTurn,pieza);
                	if(combinado!=null) {
                		Pieza nuevaPieza=playerTurn.getPiecesToUse().get(pieza-1).combinarse(combinado);
                		playerTurn.addPiece(nuevaPieza);
                        playerTurn.removePiece(combinado.getId());
                        playerTurn.removePiece(playerTurn.getPiecesToUse().get(pieza-1).getId());
                	}
                	else System.out.println("No hay pieza con la que combinarse");
                    break;
                case 5:
                    playerTurn.getPiecesToUse().get(pieza-1).cambiarMovimiento(tablero.selectMovement());
                    break;
                case 6:
                    Pieza nuevaPieza = playerTurn.getPiecesToUse().get(pieza-1).reproducirse(playerTurn.getFabric());
                    if(nuevaPieza != null)
                    {
                        nuevaPieza.setX(playerTurn.getPiecesToUse().get(pieza-1).getX());
                        nuevaPieza.setY(playerTurn.getPiecesToUse().get(pieza-1).getY());
                        playerTurn.addPiece(nuevaPieza);
                        playerTurn.usePiece(nuevaPieza);
                    }
                    break;
                default:
                    System.out.println("Error en Menu: opcion incorrecta");
            }
            playerTurn.usePiece(playerTurn.getPiecesToUse().get(pieza-1));

        }
    }
}
