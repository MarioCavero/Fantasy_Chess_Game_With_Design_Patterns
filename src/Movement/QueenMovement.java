package Movement;

import java.util.ArrayList;

public class QueenMovement extends Movement {

    private String name;

    public QueenMovement(){
        name = "queen";
    }


    @Override
    public ArrayList<String> moveOptions(int x, int y) {
        ArrayList<String> coordToGo = new ArrayList<>();
        if(x+3 < 8 && y+2 < 8)
            coordToGo.add(String.valueOf(x+3) + String.valueOf(y+2));
        if(x+2 < 8 && y-3 >= 0)
            coordToGo.add(String.valueOf(x+2) + String.valueOf(y-3));
        if(x-2 >= 0 && y+3 < 8)
            coordToGo.add(String.valueOf(x-2) + String.valueOf(y+3));
        if(x-3 >= 0 && y-2 >= 0)
            coordToGo.add(String.valueOf(x-3) + String.valueOf(y-2));
        return coordToGo;
    }
}
