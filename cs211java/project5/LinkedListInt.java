
/**
 * Write a description of class LinkedList here.
 *
 * @author (Heng Li)
 * @version ()
 */
public class LinkedListInt
{
    // instance variables - replace the example below with your own
    private Value pHead;

    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedListInt()
    {
        // initialise instance variables
        this.pHead = null;
    }
    
    /*
     * return true if LinkedList is empty
     * return false if not empty
     */
    public boolean isEmpty()
    {
        if(this.pHead == null)
        {
            return true;
        }
        return false;
    }
    
    public void push(int data)
    {
        Value latestNode = new Value(data, this.pHead);
        this.pHead = latestNode;
    }
    
    public int top()
    {
        return this.pHead.getData();
    }
    
    public void pop()
    {
        this.pHead = this.pHead.getPnext();
    }
    
    public 
    
    
    class Value
    {
        int data;
        Value pNext;
        
        public Value()
        {
            this.data = -999;
            this.pNext = null;
        }
        public Value(int data)
        {
            this.data = data;
            this.pNext = pNext;
        }
        public Value(int data, Value pNext)
        {
            this.data = data;
            this.pNext = pNext;
        }
        
        public int getData()
        {
            return this.data;
        }
        
        public Value getPnext()
        {
            return this.pNext;
        }
        
    }

}



