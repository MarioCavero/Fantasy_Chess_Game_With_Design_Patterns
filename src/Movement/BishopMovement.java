package Movement;

import java.util.ArrayList;

public class BishopMovement extends Movement {

    private String name;

    public BishopMovement(){
        name = "bishop";
    }


    @Override
    public ArrayList<String> moveOptions(int x, int y) {
        int tempX;
        int tempY;
        ArrayList<String> options = new ArrayList<>();

        for(tempX = x+1, tempY = y+1; tempX < 8 && tempY < 8; tempX++, tempY++)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempX = x+1, tempY = y-1; tempX < 8 && tempY >= 0; tempX++, tempY--)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempX = x-1, tempY = y+1; tempX >= 0 && tempY < 8; tempX--, tempY++)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempX = x-1, tempY = y-1; tempX >= 0 && tempY >= 0; tempX--, tempY--)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        return options;
    }
}

