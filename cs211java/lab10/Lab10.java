/** Complete the linked list code for 
  *
  *  show()    - traverse the list printing out the value in each node
  *  insert()  - the values are to be inserted in increasing order
  *  remove()  - remove the node from the list with the first occurrence of parameter value
  * 
  *  The C version of insert() and show() are contained in the file lab5a.c on the Notes page.
  *  The C version of remove() was to be written as part of Lab Exercise 6
  */

public class Lab10
{
  public static void main (String[] args)
  {
    MyList list1 = new MyList();
    MyList list2 = new MyList();
    
    System.out.println("List1 *************");
    // insert some values
    list1.insert (5);
    list1.insert (18);
    list1.insert (10);
    list1.show();
    list1.insert (3);
    list1.show();
    
    System.out.println("List2 ***************");
    list2.insert (51);
    list2.insert (68);
    list2.insert (24);
    list2.show();
    list2.insert (93);
    list2.show();
    
    System.out.println("List1 Remove ************");
    // remove some values
    list1 .remove (10);
    list1.show();
    list1.remove (7);
    list1.show();
    list1.remove (3);
    list1.show();
    list1.remove (18);
    list1.show();
    System.out.println("List2 Remove ************");
    list2.remove (93);
    list2.remove (24);
    list2.remove (51);
    list2.show();
    list2.remove (68);
    list2.show();
    list2.remove (3);
    list2.show();
    list2.remove (18);
    list2.show();
    
    /* add code to test the getListLength and getNthElem methodes */
    MyList list3 = new MyList(); 
    // insert some values and verify they are correct
    list3.insert (6);
    list3.insert (4);
    list3.insert (10);
    list3.insert (2);
    list3.insert (8);
    list3.show();
    /* code to duplicate show( )   */
    /*   for ( int pos = 0 ; pos < list3.getListLength() ; pos++)
     *   {
     *     System.out.print (list3.getNthElem( pos ) + � �);
     *   }
     *   System.out.println();
     */
    
    /* code to sum the values in the list without adding any more methods to the list class */
    /*   int sum = 0;
     *   for ( int pos = 0 ; pos < list3.getListLength() ; pos++)
     *   {
     *     sum = sum + list3.getNthElem( pos );
     *   }
     *   System.out.println("The total of the values in the list is: " + sum);
     */
  }
}
  
  
class MyList
{
  private MyLNode head;
  
  public MyList()
  {
    head = null;
  }
   
  public void show()
  {
      MyLNode tempNode = this.head;
      //System.out.println("!@#$%^&*()*&^%$#@$%^&*(");
      while(tempNode != null)
      {
          System.out.println(" elem: "+ tempNode.getElem());
          tempNode = tempNode.getNext();
      }
      
      System.out.println("End of Show*****");
  }
  
  public void insert (int v1)
  {
    MyLNode tmp = new MyLNode (v1);
    MyLNode tempNode = this.head;
    
    if(this.head == null)
    {
        this.head = tmp;
        //tempNode.setNext(null);
        //tempNode.setElem(v1);
        return;
    }
    
    if(v1 <= this.head.getElem())
    {
        tmp.setNext(this.head);
        this.head = tmp;
        return;
    }
    
    while(tempNode != null && tempNode.getNext() != null && tempNode.getNext().getElem() <= v1)
    {
        tempNode = tempNode.getNext();
    }
    
    tmp.setNext(tempNode.getNext());
    tempNode.setNext(tmp);
    

  }
  
  public void remove (int v1)
  {
      MyLNode tempNode = this.head;
      if(this.head == null)
      {
          return;
      }
      
      if(v1 == this.head.getElem())
      {
          this.head = this.head.getNext();
          return;
      }
      
      while(tempNode != null)
      {
        if(tempNode.getNext() != null && tempNode.getNext().getElem() == v1)
          {
              tempNode.setNext(tempNode.getNext().getNext());
              break;
          }
        tempNode = tempNode.getNext();
      }
    
  }
  
  
  // add code for getListLength( ) method
  public int getListLength()
  {
      int length = 0;
      
      
      
  }
  
  // add code for getNthElem( ) method
  
  
  // add code for showRR ( ) method
  
  


}


class MyLNode
{
  private int elem;
  private MyLNode next;
  
  public MyLNode (int v1)
  {
    elem = v1;
    next = null;
  }
  
  public MyLNode (int v1, MyLNode n)
  {
    elem = v1;
    next = n;
  }
  
  public void setElem (int e)
  {
    elem = e;
  }
  
  public int getElem ()
  {
    return elem;
  }
  
  public void setNext (MyLNode n)
  {
    next = n;
  }
  
  public MyLNode getNext()
  {
    return next;
  }
}