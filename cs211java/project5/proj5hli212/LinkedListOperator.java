
/**
 * Write a description of class LinkedListOperator here.
 *
 * @author (Heng Li)
 * @version (3-25-2017)
 */
public class LinkedListOperator
{
    // instance variables - replace the example below with your own
    private Operator pHead;

    /**
     * Constructor for objects of class LinkedListOperator
     */
    public LinkedListOperator()
    {
        // initialise instance variables
        this.pHead = null;
    }
    
    public boolean isEmpty()
    {
        if(this.pHead == null)
        {
            return true;
        }
        return false;
    }
    
    public void push(char data)
    {
        Operator latestNode = new Operator(data,this.pHead);
        this.pHead = latestNode;
    }
    
    public char top()
    {
        return this.pHead.getData();
    }
    
    public void pop()
    {
        this.pHead = this.pHead.getPnext();
    }
        
    class Operator
    {
        char data;
        Operator pNext;
        public Operator(char data)
        {
            this.data = data;
            this.pNext = null;
        }
        public Operator(char data, Operator pNext)
        {
            this.data = data;
            this.pNext = pNext;
        }
        
        public char getData()
        {
            return this.data;
        }
        
        public Operator getPnext()
        {
            return this.pNext;
        }
        
    }
}
