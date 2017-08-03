import java.io.*;
import java.util.*;
import java.lang.String;

/**
 * Write a description of class MySList here.
 *
 * @author (Heng Li)
 * @version (4-10)
 */
public class MySList
{
    // instance variables - replace the example below with your own
    private Node pHead;

    /**
     * Constructor for objects of class MySList
     */
    public MySList()
    {
        // initialise instance variables
        this.pHead = null;
    }

    public void push(String data)
    {
        Node new_node = new Node(data,this.pHead);
        this.pHead = new_node;
    }
    
    public boolean exist(String data)
    {
        Node temp_node = this.pHead;
        while(temp_node != null)
        {
            if(data.compareTo(temp_node.getData()) == 0)
            {
                return true;
            }
            temp_node = temp_node.getNext();
        }
        return false;
    }
    
    public void pop()
    {
        this.pHead = this.pHead.getNext();
    }
    
    
    class Node
    {
        String data;
        Node pNext;
        
        public Node(String data)
        {
            this.data = new String(data);
            this.pNext = null;
        }
        
        public Node(String data, Node pNext)
        {
            this.data = new String(data);
            this.pNext = pNext;
        }
        
        public String getData()
        {
            return this.data;
        }
        
        public Node getNext()
        {
            return this.pNext;
        }
        
        public void setNext(Node next)
        {
            this.pNext = next;
        }
        
        
    }
    
}
