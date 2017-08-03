package com.company;

import java.lang.String;
import java.io.*;
import java.util.*;

public class Doodlebug extends Creature
{
    private int days_havent_eat;
    //private int days_no_food;
    public Doodlebug(int row,int col,int birthday)
    {
        super("Doodlebug",row,col,8,birthday);
        this.days_havent_eat = 0;

    }

    public Doodlebug copyCreature()
    {
        // Need copy
        Doodlebug newBug = new Doodlebug(getRow(),getCol(),getBirthday());
        newBug.setDays_havent_eat(getDays_havent_eat());
        return newBug;
    }

    public int getDays_havent_eat()
    {
        return this.days_havent_eat;
    }

    public void setDays_havent_eat(int days)
    {
        this.days_havent_eat = days;
    }

    /*
    public int getDays_no_food()
    {
        return this.days_no_food;
    }
    public void setDays_no_food(int days)
    {
        this.days_no_food = days;
    }
    */


    /*
    public boolean hunt(Creature[][] creatures)
    {
        int row = getRow();
        int col = getCol();
        // check if it can hunt ant
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(row + i < 0 || row + i >= 20 || col + j < 0 || col + j >= 20)
                {
                    continue;
                }

                if(creatures[row+i][col+j] != null && creatures[row+i][col+j].getType().equals("Ant"))
                {
                    this.days_havent_eat = 0;
                    creatures[row+i][col+j] = creatures[row][col];

                    creatures[row][col] = null;
                    setRow(row+i);
                    setCol(col+j);

                    if(creatures[row+i][col+j] == null)
                    {
                        System.out.println("A bug died during hunting");
                    }

                    return true;
                }

            }
        }
        return false;
    }
    */

    public boolean hunt(Creature[][] creatures)
    {
        int row = getRow();
        int col = getCol();
        // check if it can hunt ant
        int ant_num = 0;
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(row + i < 0 || row + i >= 20 || col + j < 0 || col + j >= 20)
                {
                    continue;
                }

                if(creatures[row+i][col+j] != null && creatures[row+i][col+j].getType().equals("Ant"))
                {
                    ant_num++;
                }
            }
        }

        if(ant_num <= 0)
        {
            return false;
        }

        Random rand = new Random();
        int selected_ant = rand.nextInt(ant_num);

        int which_ant = 0;
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if(row + i < 0 || row + i >= 20 || col + j < 0 || col + j >= 20)
                {
                    continue;
                }

                if(creatures[row+i][col+j] != null && creatures[row+i][col+j].getType().equals("Ant"))
                {
                    if(which_ant == selected_ant)
                    {
                        this.days_havent_eat = 0;
                        creatures[row+i][col+j] = creatures[row][col];

                        creatures[row][col] = null;
                        setRow(row+i);
                        setCol(col+j);

                        if(creatures[row+i][col+j] == null)
                        {
                            System.out.println("A bug died during hunting");
                        }
                        return true;

                    }

                    which_ant++;
                }
            }
        }

        return false;
    }

    public boolean starving()
    {
        if(this.days_havent_eat > 3)
        {
            System.out.println(" Days haven't eat: "+ this.days_havent_eat);
            return true;
        }

        return false;
    }

    public void move(Creature[][] creatures, Field grid, int currentDay)
    {
        if(getLastMove() == currentDay)
        {
            return;
        }

        setLastMove(currentDay);


        //System.out.println("Before Current Dat:" + currentDay+ " THis bug has been starved: " + this.days_havent_eat);
        this.days_havent_eat++;
        //System.out.println("Current Dat:" + currentDay+ " THis bug has been starved: " + this.days_havent_eat);


        int DateBirth = getBirthday();
        boolean spawnBool = getShouldSpawn();
        boolean huntBool = hunt(creatures);
        if((currentDay - getBirthday())%8 == 0 || getShouldSpawn())
        {
            spawn(creatures,grid,currentDay);
        }
        if(!huntBool)
        {
            wander(creatures);
        }

        if(this.days_havent_eat > 3)
        {
            System.out.println(" A doodlebug died, Date:" + currentDay+" Days starve:" + this.days_havent_eat);
            creatures[getRow()][getCol()] = null;
            if(creatures[getRow()][getCol()] == null)
            {
                //System.out.println(" Death confirmed");
            }
        }




    }




}