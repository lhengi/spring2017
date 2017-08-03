package com.company;

/**
 * Created by Heng on 4/25/17.
 */
public class QueueArray
{
    private char[] array;
    private int pHead;
    private int pTail;

    public QueueArray()
    {
        this.array = new char[2];
        this.pHead = 0;
        this.pTail = 0;
    }

    public void enqueue(char data)
    {

        if(this.pTail < this.pHead && (this.pTail + 1 + this.array.length - this.pHead) >= this.array.length)
        {
            char[] newArray = new char[this.array.length * 2];
            int index = 0;
            for(int i = this.pHead; i < this.array.length;i++)
            {
                newArray[index] = this.array[i];
                index++;
            }

            for(int i = 0; i < this.pTail; i++)
            {
                newArray[index] = this.array[i];
                index++;
            }

            this.array = newArray;
            this.array[pTail +1] = data;
            this.pHead = 0;
            this.pTail += 2;
            return;
        }

        if(this.pTail  >= this.array.length && this.pHead == 0)
        {
            char[] newArray = new char[this.array.length * 2];

            for(int i = this.pHead; i < this.array.length;i++)
            {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            this.array[pTail] = data;
            this.pHead = 0;
            this.pTail++;
            return;

        }

        if(this.pTail  >= this.array.length)
        {
            this.pTail %= this.array.length;
            this.array[pTail] = data;
            this.pTail++;
            return;
        }

        this.array[pTail] = data;
        this.pTail++;


    }

    public char top()
    {
        return this.array[this.pHead];
    }
    public int getpHead()
    {
        return this.pHead;
    }
    public void dequeue()
    {
        if(this.pTail == this.pHead)
        {
            return;
        }

        if(this.pHead == this.array.length - 1)
        {
            this.pHead = 0;
            return;
        }

        this.pHead++;



    }

    public boolean isEmpty()
    {
        if(this.pTail == this.pHead)
        {
            return true;
        }
        return false;
    }
}
