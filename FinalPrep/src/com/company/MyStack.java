package com.company;

/**
 * Created by Heng on 4/25/17.
 */
public class MyStack
{
    private Node pHead;

    public MyStack()
    {
        this.pHead = null;
    }

    public void push(char data)
    {
        Node temp = new Node(data,this.pHead);
        this.pHead = temp;

    }

    public char top()
    {
        return this.pHead.getData();
    }

    public void pop()
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

        public Node(char data, Node pNext)
        {
            this.data = data;
            this.pNext = pNext;
        }

        public Node getpNext()
        {
            return pNext;
        }

        public void setData(char data)
        {
            this.data = data;
        }

        public char getData()
        {
            return this.data;
        }

        public void setpNext(Node pNext)
        {
            this.pNext = pNext;
        }
    }
}