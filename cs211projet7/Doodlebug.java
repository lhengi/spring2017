import java.lang.String;
import java.io.*;
import java.util.*;

public class Doodlebug extends Creature
{
    private int starve_days;
    private int days_no_food;
    public Doodlebug(int row,int col,int birthday)
    {
        super("Doodlebug",row,col,8,birthday);
        this.starve_days = 3;
        this.days_no_food = 0;
    }

    public int getDays_no_food()
    {
        return this.days_no_food;
    }
    public void setDays_no_food(int days)
    {
        this.days_no_food = days;
    }

    public void wander(Creature[][] creatures)
    {
        int row = getRow();
        int col = getCol();
        // check if it can hunt ant
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                // check if out of bound
                if(row + i < 0 || row + i >= 20 || col + j < 0 || col + j >= 20)
                {
                    continue;
                }
                else if(creatures[row + i][col + j] != null && creatures[row + i][col + j].getType().equals("Ant") == 0)
                {

                    setRow(row + i);
                    setCol(col + j);
                    creatures[row + i][col + j] = null;
                    creatures[row + i][col + j] = creatures[row][col];
                    creatures[row][col] = null;
                    setDays_no_food(0);
                    return;
                }
            }
        }

        if(!checkSpaceAround(creatures))
        {
            return;
        }

        boolean moved = false;
        while(!moved)
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

            if(creatures[row + row_change][col + col_change] == null)
            {
                creatures[row + row_change][col + col_change] = creatures[row][col];
                creatures[row][col] = null;
                return;
            }

        }



    }




}