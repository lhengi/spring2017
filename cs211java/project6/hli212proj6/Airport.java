import java.io.*;
import java.util.*;
import java.lang.String;
/**
 * Write a description of class Airport here.
 *
 * @author (Heng Li)
 * @version (4-07-2017)
 */
public class Airport
{
    // instance variables - replace the example below with your own
    private int airport_code;
    private Node available;

    /**
     * Constructor for objects of class Airport
     */
    public Airport(int airport_code)
    {
        // initialise instance variables
        this.airport_code = airport_code;
        this.available = null;
    }
    
    public Airport()
    {
        this.airport_code = 0;
        this.available = null;
    }
    
    public void setCode(int code)
    {
        this.airport_code = code;
    }
    
    public int getCode()
    {
        return this.airport_code;
    }
    
    public void addAvailable(int available_airport)
    {
        Node new_available_airport = new Node(available_airport);
        
        if(this.available == null)
        {
            this.available = new_available_airport;
            return;
        }
        
        
        Node temp_node = this.available;
        while(temp_node.getNext() != null)
        {
            temp_node = temp_node.getNext();
        }
        
        temp_node.setNext(new_available_airport);
        
    }
    
    public void deleteAvailable(int available_airport)
    {
        Node temp_node = this.available;
        if(temp_node == null)
        {
            return;
        }
        else if(temp_node.getNext() == null)
        {
            if(temp_node.getData() == available_airport)
            {
                this.available = null;
                return;
            }
        }
        
        if(this.available.getData() == available_airport)
        {
            this.available.setNext(this.available.getNext());
            return;
        }
        
        while(temp_node.getNext().getNext() != null)
        {
            if(temp_node.getNext().getData() == available_airport)
            {
                temp_node.setNext(temp_node.getNext().getNext());
                return;
            }
            temp_node = temp_node.getNext();
        }
        
        if(temp_node.getNext().getData() == available_airport)
        {
            temp_node.setNext(temp_node.getNext().getNext());
        }
        
        
    }
    
    public boolean findAvailable(int target)
    {
        Node temp_node = this.available;
        
        while(temp_node != null)
        {
            if(temp_node.getData() == target)
            {
                return true;
            }
            temp_node = temp_node.getNext();
        }
        
        return false;
    }
    
    class Node
    {
        private int data;
        private Node pNext;
        
        public Node(int data)
        {
            this.data = data;
            this.pNext = null;
        }
        
        public int getData()
        {
            return this.data;
        }
        
        public Node getNext()
        {
            return this.pNext;
        }
        
        public void setNext(Node pNext)
        {
            this.pNext = pNext;
        }
        
    }
    

}
