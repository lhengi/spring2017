package com.company;

/**
 * Created by Heng on 4/25/17.
 */
public class MyQueue
{
    private Node pHead;

    public MyQueue()
    {
        this.pHead = null;
    }


    public void enqueue(char data)
    {
        Node temp = new Node(data);
        if(this.pHead == null)
        {
            this.pHead = temp;
            return;
        }

        Node trave = this.pHead;

        while(trave.getpNext() != null)
        {
            trave = trave.getpNext();
        }

        trave.setpNext(temp);
    }

    public char top()
    {
        return this.pHead.getData();
    }

    public void dequeue()
    {
        if(this.pHead == null)
        {
            return;
        }

        this.pHead = this.pHead.getpNext();
    }

    public boolean isEmpty()
    {
        if(this.pHead == null)
        {
            return true;
        }
        return false;
    }

    public void reverseDisplayHelper()
    {
        reverseDisplay(this.pHead);
    }
    public void reverseDisplay(Node pHead)
    {
        if(pHead == null)
        {
            return;
        }

        reverseDisplay(pHead.getpNext());
        System.out.println(pHead.getData());

    }


    class Node
    {
        private char data;
        private Node pNext;

        public Node(char data)
        {
            this.data = data;
            this.pNext = null;
        }

        public void setpNext(Node pNext)
        {
            this.pNext = pNext;
        }

        public Node getpNext()
        {
            return this.pNext;
        }

        public char getData()
        {
            return this.data;
        }

    }
}
