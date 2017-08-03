package com.company;

import java.lang.String;
import java.io.*;
import java.util.*;


public class Creature
{
    private String type;
    private int row;
    private int col;
    private int spawn_days;
    private boolean alive;
    private int birthday;
    private boolean shouldSpawn;
    private int lastMove;
    //private int days_havent_eat;

    public Creature(String type,int row, int col,int spawn_days,int birthday)
    {
        this.type = new String(type);
        this.row = row;
        this.col = col;
        this.spawn_days = spawn_days;
        this.alive = true;
        //this.days_havent_eat = 0;
        this.birthday = birthday;
        this.shouldSpawn = false;
        lastMove = birthday;
    }

    public int getLastMove()
    {
        return lastMove;
    }

    public void setLastMove(int day)
    {
        this.lastMove = day;
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

    public void wander(Creature[][] creatures)
    {

        int row = getRow();
        int col = getCol();
        Random rand = new Random();


        int row_change = 0;
        boolean row_sign = rand.nextBoolean();
        int col_change = 0;
        boolean col_sign = rand.nextBoolean();

        while(row_change == 0 && col_change == 0)
        {
            row_change = rand.nextInt(2);
            col_change = rand.nextInt(2);
        }

        // set signs
        if (!row_sign)
        {
            row_change *= -1;
        }

        if (!col_sign)
        {
            col_change *= -1;
        }

        row_change += row;
        col_change += col;

        if(row_change < 0 || row_change >= 20 || col_change < 0 || col_change >= 20)
        {
            return;
        }

        if(creatures[row_change][col_change] == null )
        {
            creatures[row_change][col_change] = creatures[row][col];
            if(row_change != row || col_change != col)
            {
                creatures[row][col] = null;
            }
            setRow(row_change);
            setCol(col_change);
        }


    }

    /*
    public void wander(Creature[][] creatures, Creature[][] nextCreatures)
    {

        int row = getRow();
        int col = getCol();
        Random rand = new Random();


        int row_change = 0;
        boolean row_sign = rand.nextBoolean();
        int col_change = 0;
        boolean col_sign = rand.nextBoolean();

        while(row_change == 0 && col_change == 0)
        {
            row_change = rand.nextInt(2);
            col_change = rand.nextInt(2);
        }

        // set signs
        if (!row_sign)
        {
            row_change *= -1;
        }

        if (!col_sign)
        {
            col_change *= -1;
        }

        row_change += row;
        col_change += col;

        if(row_change < 0 || row_change >= 20 || col_change < 0 || col_change >= 20)
        {
            return;
        }

        if(creatures[row_change][col_change] == null && nextCreatures[row_change][col_change] == null)
        {
            nextCreatures[row_change][col_change] = creatures[row][col];
            if(row_change != row || col_change != col)
            {
                nextCreatures[row][col] = null;
            }
            setRow(row_change);
            setCol(col_change);
        }


    }
    */


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

    //public abstract void move(Creature[][] creatures, Creature[][] nextCreatures, int currentDay);

    public void move(Creature[][] creatures,Field grid, int currentDay)
    {

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

    public void spawn(Creature[][] creatures, Field grid, int currentDay)
    {

        //handle if all spots are taken, so no infinte loop
        if (!checkSpaceAround(creatures)) {
            setShouldSpawn(true);
            return;
        }

        int space_avl = 0;
        for (int row_change = -1; row_change < 2; row_change++) {
            for (int col_change = -1; col_change < 2; col_change++)
            {
                if (row_change == 0 && col_change == 0)
                {
                    continue;
                }
                if (this.row + row_change < 0 || this.row + row_change >= 20 || this.col + col_change < 0 || this.col + col_change >= 20) {
                    continue;
                }

                if(creatures[row+ row_change][ col + col_change] == null)
                {
                    grid.addCreature(creatures,row + row_change, col + col_change,currentDay, getType());

                    setShouldSpawn(false);
                    return;
                }

                }
            }
        }
    }
    /*
    public void spawn(Creature[][] creatures, Creature[][] nextCreatures, int currentDay)
    {

        //handle if all spots are taken, so no infinte loop
        if(!checkSpaceAround(nextCreatures))
        {
            setShouldSpawn(true);
            return;
        }

        for(int row_change = -1; row_change < 2; row_change++)
        {
            for(int col_change = -1; col_change < 2; col_change++)
            {
                if(row_change == 0 && col_change == 0)
                {
                    continue;
                }
                if(this.row + row_change < 0 || this.row + row_change >= 20 || this.col + col_change < 0 || this.col + col_change >= 20)
                {
                    continue;
                }

                if(creatures[this.row + row_change][this.col + col_change] == null && nextCreatures[this.row + row_change][this.col + col_change] == null )
                {
                    if(this.type.equals("Doodlebug"))
                    {
                        nextCreatures[this.row + row_change][this.col + col_change] = new Doodlebug(this.row + row_change,this.col + col_change, currentDay);

                    }
                    else
                    {
                        nextCreatures[this.row + row_change][this.col + col_change] = new Ant(this.row + row_change,this.col + col_change,currentDay);

                    }

                    setShouldSpawn(false);
                    return;

                }
            }
        }
        */







