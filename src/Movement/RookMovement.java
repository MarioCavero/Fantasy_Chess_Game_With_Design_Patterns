package Movement;

import java.util.ArrayList;

public class RookMovement extends Movement{

    private String name;

    public RookMovement(){
        name = "rook";
    }


    @Override
    public ArrayList<String> moveOptions(int x, int y) {
        int tempX;
        int tempY;
        ArrayList<String> options = new ArrayList<>();

        for(tempX = x+1, tempY = y; tempX < 8; tempX++)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempY = y+1, tempX=x;tempY < 8;tempY++)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempX = x-1, tempY = y; tempX >= 0; tempX--)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        for(tempY = y-1, tempX=x; tempY >= 0;tempY--)
        {
            options.add(String.valueOf(tempX) + String.valueOf(tempY));
        }
        return options;
    }
}
