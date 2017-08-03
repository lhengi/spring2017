package com.company;

import java.lang.String;
/**
 * Created by Heng on 4/25/17.
 */
public class StackArray
{
    private char[] array;
    private int pHead;

    public StackArray()
    {
        this.array = new char[2];
        this.pHead = -1;
    }

    public void push(char data)
    {
        if(this.array.length <= pHead+1)
        {
            char[] newArray = new char[this.array.length * 2];

            for(int i = 0; i < this.array.length; i++)
            {
                newArray[i] = this.array[i];
            }

            this.array = null;
            this.array = newArray;
        }
        this.array[pHead +1] = data;
        this.pHead++;
    }

    public char top()
    {
        return this.array[this.pHead];
    }

    public void pop()
    {
        this.pHead--;
    }

    public boolean isEmpty()
    {
        if(this.pHead == -1)
        {
            return true;
        }

        return false;
    }




}
