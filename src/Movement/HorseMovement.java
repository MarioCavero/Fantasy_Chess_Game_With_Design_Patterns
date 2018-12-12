package Movement;

import java.util.ArrayList;

public class HorseMovement extends Movement {

    private String name;

    public HorseMovement(){
        name = "horse";
    }

    @Override
    public ArrayList<String> moveOptions(int x, int y) {
        ArrayList<String> coordToGo = new ArrayList<>();
        if(x+1 < 8 && y+2 < 8)
            coordToGo.add(String.valueOf(x+1) + String.valueOf(y+2));
        if(x+1 < 8 && y-2 >= 0)
            coordToGo.add(String.valueOf(x+1) + String.valueOf(y-2));
        if(x-1 >= 0 && y+2 < 8)
            coordToGo.add(String.valueOf(x-1) + String.valueOf(y+2));
        if(x-1 >= 0 && y-2 >= 0)
            coordToGo.add(String.valueOf(x-1) + String.valueOf(y-2));
        return coordToGo;
    }
}
