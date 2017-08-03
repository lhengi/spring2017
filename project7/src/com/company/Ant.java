package com.company;

import java.lang.String;
import java.io.*;
import java.util.*;

public class Ant extends Creature
{
    public Ant(int row, int col,int birthday)
    {

        super("Ant",row,col,3,birthday);
    }

    public void move(Creature[][] creatures,Field grid, int currentDay)
    {
        if(getLastMove() == currentDay)
        {
            return;
        }

        setLastMove(currentDay);


        if((currentDay - getBirthday())%3 == 0 || getShouldSpawn())
        {
            spawn(creatures,grid, currentDay);
        }
        wander(creatures);
    }

    public Ant copyCreature()
    {
        Ant newAnt = new Ant(getRow(),getCol(),getBirthday());
        newAnt.setShouldSpawn(getShouldSpawn());

        return newAnt;
    }



}