package com.company;

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
            int row = rand.nextInt(this.creatures.length);
            int col = rand.nextInt(this.creatures[0].length);

            if(this.creatures[row][col] == null)
            {
                this.creatures[row][col] = new Doodlebug(row,col,day_num);
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
                this.creatures[row][col] = new Ant(row,col,day_num);
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

    public void addCreature(Creature[][] array,int addRow, int addCol,int theDate, String type)
    {
        if(type.equals("Doodlebug"))
        {
            array[addRow][addCol] = new Doodlebug(addRow,addCol,theDate);
        }
        else
        {
            array[addRow][addCol] = new Ant(addRow,addCol,theDate);
        }

    }

    public void next_day()
    {
        incrementDay();
        System.out.println(" Current Day :" + day_num + "*********");

        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null  && creatures[row][col].getType().equals("Doodlebug"))
                {

                    creatures[row][col].move(creatures,this, day_num);

                    //System.out.println("Day:"+ day_num + " row:" + row + " col:"+col);
                }
            }
        }

        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null && creatures[row][col].getType().equals("Ant"))
                {

                    creatures[row][col].move(creatures,this,day_num);

                    //System.out.println("Day:"+ day_num + " row:" + row + " col:"+col);
                }
            }
        }


    }

    /*
    public void nextDay()
    {
        incrementDay();

        //set up the next day array

        Creature[][] nextCreatures = new Creature[20][20];
        for(int i = 0; i < 20 ; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                if(creatures[i][j] != null)
                {
                    nextCreatures[i][j] = creatures[i][j].copyCreature();
                }
                else
                {
                    nextCreatures[i][j] = null;
                }
            }
        }



        System.out.println(" Current Day :" + day_num + "*********");

        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null && nextCreatures[row][col] != null &&
                        creatures[row][col].getType().equals("Doodlebug"))
                {
                    creatures[row][col].move(creatures, nextCreatures, day_num);

                    //System.out.println("Day:"+ day_num + " row:" + row + " col:"+col);
                }
            }
        }

        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null && nextCreatures[row][col] != null &&
                        creatures[row][col].getType().equals("Ant"))
                {
                    creatures[row][col].move(creatures, nextCreatures, day_num);

                    //System.out.println("Day:"+ day_num + " row:" + row + " col:"+col);
                }
            }
        }

        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                this.creatures[i][j] = null;
                this.creatures[i][j] = nextCreatures[i][j];
                if(this.creatures[i][j] != null) {
                    Doodlebug bug = (Doodlebug) this.creatures[i][j].copyCreature();
                    System.out.println("Field, bug starved: " + bug.getDays_havent_eat());
                }
                nextCreatures[i][j] = null;
            }
        }

        //this.creatures = nextCreatures;
        //starvingBug();
        //spawnCratures();
        //everyOneWander();
    }
    */

    /*
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
                        this.creatures[row][col].spawn(this.creatures,day_num);
                        this.creatures[row][col].setBirthday(this.day_num);
                        this.creatures[row][col].setShouldSpawn(false);
                    }
                }
            }
        }


    }
    */

    /*
    public void starvingBug()
    {
        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null && this.creatures[row][col].getType().equals("Doodlebug"))
                {
                    this.creatures[row][col].setDays_havent_eat(this.creatures[row][col].getDays_havent_eat() + 1);
                    if(this.creatures[row][col].getDays_havent_eat() >= 3)
                    {
                        this.creatures[row][col] = null;
                        continue;
                    }

                }

            }
        }

    }
    */

    /*
    public void everyOneWander()
    {
        for(int row = 0; row < 20; row++)
        {
            for(int col = 0; col < 20; col++)
            {
                if(this.creatures[row][col] != null)
                {
                    this.creatures[row][col].wander(this.creatures);
                }
            }
            System.out.println("EveryoneWander running : "+ row);
        }

    }
    */

    public void incrementDay()
    {
        this.day_num++;
    }



}