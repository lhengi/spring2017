import java.lang.String;
import java.io.*;
import java.util.*;

public class Ant extends Creature
{
    public Ant(int row, int col,int birthday)
    {

        super("Ant",row,col,3,birthday);
    }

    public void wander(Creature[][] creatures)
    {
        int row = getRow();
        int col = getCol();

        if (!checkSpaceAround(creatures))
        {
            return;
        }

        boolean moved = false;
        while (!moved)
        {
            int row_change = rand.nextInt(1);
            boolean row_sign = rand.nextBoolean();
            int col_change = rand.nextInt(1);
            boolean col_sign = rand.nextBoolean();

            // set signs
            if (!row_sign)
            {
                row_change *= -1;
            }

            if (!col_sign)
            {
                col_change *= -1;
            }

            // handle boundry cases
            if (row + row_change < 0 || row + row_change >= 20 || col + col_change < 0 || col + col_change >= 20)
            {
                continue;
            }

            if (creatures[row + row_change][col + col_change] == null)
            {
                creatures[row + row_change][col + col_change] = creatures[row][col];
                creatures[row][col] = null;
                return;
            }

        }
    }

}