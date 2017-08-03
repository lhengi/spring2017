import java.lang.String;
import java.io.*;
import java.util.*;

public class Field
{
    private Creature[][] creatures;
    private int day_num;

    public Field()
    {

        this.creatures = new Creature[20][20];
        this.day_num = 0;
    }

    public void setCreatures(int doodle_total, int ant_total)
    {
        Random rand = new Random();

        int doodle_count = 0;
        while(doodle_count < doodle_total)
        {
            int row = rand.nextInt(20);
            int col = rand.nextInt(20);

            if(this.creatures[row][col] == null)
            {
                this.creatures[row][col] = new Doodlebug(row,col);
                doodle_count++;
            }
        }

        int ant_count = 0;

        while(ant_count < ant_total)
        {
            int row = rand.nextInt(this.creatures.length);
            int col = rand.nextInt(this.creatures[0].length);

            if(this.creatures[row][col] == null)
            {
                this.creatures[row][col] = new Ant(row,col);
                ant_count++;
            }
        }

    }


    public Creature[][] getArray()
    {
        return this.creatures;
    }

    public Creature getCreature(int row, int col)
    {
        return this.creatures[row][col];
    }

    public void killCreature(int row, int col)
    {
        this.creatures[row][col] = null;
    }

    public void spawnCratures()
    {
        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null)
                {
                    if(this.creatures[row][col].getShouldSpawn() || (this.day_num - this.creatures[row][col].getBirthday())%this.creatures[row][col].getSpawn_days() == 0)
                    {
                        this.creatures[row][col].spawn();
                        this.creatures[row][col].setBirthday(this.day_num);
                        this.creatures[row][col].setShouldSpawn(false);
                    }
                }
            }
        }


    }

    public void starvingBug()
    {
        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; row++)
            {
                if(this.creatures[row][col] != null && this.creatures[row][col].getType().equals("Doodlebug") == 0)
                {
                    this.creatures[row][col].setDays_no_food(this.creatures[row][col].getDays_no_food() + 1);
                    if(this.creatures[row][col].getDays_no_food() >= 3)
                    {
                        this.creatures[row][col] = null;
                        continue;
                    }

                }

            }
        }

    }

    public void incrementDay()
    {
        this.day_num++;
    }



}