package Movement;

import DataStructures.Pieza;

import java.util.ArrayList;
//Patron strategy implementado para gestionar el tipo de movimiento que se escoge para la pieza. 
//Tiene los distintos movimientos que usara en subclases
public abstract class Movement {

    String name = "";

    public abstract ArrayList<String> moveOptions(int x, int y);

    public boolean canMoveTo(int x, int y, Pieza it)
    {

        ArrayList<String> options = moveOptions(it.getX(), it.getY());
        for(int i = 0; i < options.size(); i++)
        {
            int tempX = Integer.parseInt(options.get(i))/10;
            int tempY = Integer.parseInt(options.get(i))-tempX*10;
            if(tempX == x && tempY == y) return true;
        }
        return false;
    }

    public String getMovName(){
        return name;
    }
}
