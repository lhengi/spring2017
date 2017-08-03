import java.lang.String;
import java.io.*;
import java.util.*;


public abstract class Creature
{
    private String type;
    private int row;
    private int col;
    private int spawn_days;
    private boolean alive;
    private int birthday;
    private boolean shouldSpawn;

    public Creature(String type,int row, int col,int spawn_days,int birthday)
    {
        this.type = new String(type);
        this.row = row;
        this.col = col;
        this.spawn_days = spawn_days;
        this.alive = true;
        this.days_havent_eat = 0;
        this.birthday = birthday;
        this.shouldSpawn = false;
    }

    public String getType()
    {
        return this.type;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getCol()
    {
        return this.col;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public boolean isAlive()
    {
        return this.alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public abstract void wander(Creature[][] creatures);

    public boolean checkSpaceAround(Creature[][] creatures)
    {
        int spot_not_avilable = 0;
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(this.row + i < 0 || this.row + i >= 20 || this.col + j < 0 || this.col + j >= 20)
                {
                    spot_not_avilable++;
                }
                else if( creatures[this.row+i][this.col+j] != null)
                {
                    spot_not_avilable++;
                }
            }
        }

        if(spot_not_avilable >= 9)
        {
            return false;
        }
        return true;
    }

    public void setBirthday(int newBirthday)
    {
        this.birthday = newBirthday;
    }

    public int getBirthday()
    {
        return this.birthday;
    }

    public int getSpawn_days()
    {
        return this.spawn_days;
    }

    public boolean getShouldSpawn()
    {
        return this.shouldSpawn;
    }

    public void setShouldSpawn(boolean shouldSpawn)
    {
        this.shouldSpawn = shouldSpawn;
    }

    public spawn(Creature[][] creatures)
    {
        Random rand = new Random();
        boolean spawned = false;

        //handle if all spots are taken, so no infinte loop
        if(!checkSpaceAround(creatures))
        {
            this.shouldSpawn = true;
            return;
        }


        while(!spawned)
        {
            int row_change = rand.nextInt(1);
            boolean row_sign = rand.nextBoolean();
            int col_change = rand.nextInt(1);
            boolean col_sign = rand.nextBoolean();

            // set signs
            if(!row_sign)
            {
                row_change *= -1;
            }

            if(!col_sign)
            {
                col_change *= -1;
            }

            // handle boundry cases
            if(this.row + row_change < 0 || this.row + row_change >= 20 || this.col + col_change < 0 || this.col + col_change >= 20)
            {
                continue;
            }

            if(creatures[this.row + row_change][this.col + col_change] == null)
            {
                if(this.type.equals("Doodlebug") == 0)
                {
                    creatures[this.row + row_change][this.col + col_change] = new Doodlebug(this.row + row_change,this.col + col_change);

                }
                else
                {
                    creatures[this.row + row_change][this.col + col_change] = new Ant(this.row + row_change,this.col + col_change);

                }

                this.shouldSpawn = false;
                return;

            }



        }

    }


}
