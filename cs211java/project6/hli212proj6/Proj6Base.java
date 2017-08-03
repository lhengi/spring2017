import java.io.*;
import java.util.*;
import java.lang.String;

public class Proj6Base
{

 public static void main (String[] args)
 {
   // set up an instance of the BufferedReader class to read from standard input
   BufferedReader br = new BufferedReader (new InputStreamReader (
        System.in));
   
   // set up the data needed for the airport adjcency list
   TravelNetwork airportData = new TravelNetwork();
   
   // call the method that reads and parses the input
   airportData.processCommandLoop (br);
   
   System.out.println ("Goodbye");
 }
}

class TravelNetwork
{
  // Create the Data Members for the Travel Network here
    Airport[] airports;
    MySList filesInUse;
  
  // Use a constructor to initialize the Data Members for Travel Network
  public TravelNetwork()
  {
      airports = new Airport[11];
      for(int i = 1; i < 11; i ++)
      {
          airports[i] = new Airport(i);
          //System.out.println("New Airport Created");
          //airports[i].setCode(i);
      }
      
      filesInUse = new MySList();
  }
  
  
  public void processCommandLoop (BufferedReader br)
  {
   showCommands();
   System.out.println("Enter Command ");
    try {  //try-catch clauses are needed since BufferedReader and Scanner classes
           //  throw exceptions on errors
    String inline = br.readLine();   // get a line of input
    Scanner sc;
    
   // loop until all lines are read from the input
   while (inline != null)
   {
     sc = new Scanner (inline);   // process each line of input using the Scanner iterators
     String command = "#";
     if(sc.hasNext())
     {
         command = sc.next();
     }
     System.out.println ("*" + command + "*");
     
     if (command.equals("q") == true)
       System.exit(1);
     
     else if (command.equals("?") == true)
       showCommands();
     
     else if (command.equals("t") == true)
       doTravel(sc);
     
     else if (command.equals("r") == true)
       doResize(sc);

     else if (command.equals("i") == true)
       doInsert(sc);

     else if (command.equals("d") == true)
       doDelete(sc);

     else if (command.equals("l") == true)
       doList(sc);

     else if (command.equals("f") == true)
       doFile(sc);
       

     else if (command.equals("#") == true)
       ;
     
     else
       System.out.println ("Command is not known: " + command);
     
     inline = br.readLine();   // get the next line of input

   }
  }
  catch (IOException ioe)
  {
    System.out.println ("Error in Reading - Assuming End of File");
  }
 }
 
 public void dfsHelper(int start, int end)
 {
     boolean[] visited = new boolean[this.airports.length];
     visited[start] = true;
     
     if(dfs(start,end,visited))
     {
         System.out.println("You can get from airport " + start + " to airport " + end);
         return;
     }
     
     
     System.out.println("You CANNot get from airport " + start + " to airport " + end);
     
     
 }
 
 public boolean dfs(int start, int end, boolean[] visited)
 {
     if(airports[start].findAvailable(end))
     {
         return true;
     }
     for(int i = 1; i < this.airports.length; i++)
     {
         if(this.airports[start].findAvailable(i) && visited[i] == false)
         {
             visited[i] = true;
             
             return dfs(i,end,visited);
         }
     }
     return false;
     
 }
 
 
 public void showCommands()
 {
   System.out.println ("The commands for this project are:");
   System.out.println ("  q ");
   System.out.println ("  ? ");
   System.out.println ("  # ");
   System.out.println ("  t <int1> <int2> ");
   System.out.println ("  r <int> ");
   System.out.println ("  i <int1> <int2> ");
   System.out.println ("  d <int1> <int2> ");
   System.out.println ("  l ");
   System.out.println ("  f <filename> ");
 }
 
 public void doTravel(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;
   
   if ( sc.hasNextInt() == true )
   {
     val1 = sc.nextInt();
     if(val1 <= 0 || val1 >= this.airports.length)
     {
         System.err.println("Proper value expected");
         return;
     }
    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if ( sc.hasNextInt() == true )
   {
     val2 = sc.nextInt();
     if(val2 <= 0 || val2 >= this.airports.length)
     {
         System.err.println("Proper value expected");
         return;
     }
    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   System.out.println ("Performing the Travel Command from " + val1 +
                       " to " + val2);
   dfsHelper(val1,val2);
   
 }
 
 public void doResize(Scanner sc)
 {
   int val1 = 0;
   
   if ( sc.hasNextInt() == true )
     val1 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   this.airports = new Airport[val1+1];
   for(int i = 1; i < val1+1;i++)
   {
       this.airports[i] = new Airport(i);
   }
   
   System.out.println ("Performing the Resize Command with " + val1 );
   

 }
 
 public void doInsert(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;
   if ( sc.hasNextInt() == true )
   {
     val1 = sc.nextInt();
    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if ( sc.hasNextInt() == true )
   {
     val2 = sc.nextInt();

    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if(val1 <= 0 || val1 >= this.airports.length)
   {
        System.err.println("Proper value expected");
        return;
   }
   if(val2 <= 0 || val2 >= this.airports.length)
   {
       System.err.println("Proper value expected");
       return;
   }   
   this.airports[val1].addAvailable(val2);
   System.out.println("Insert " + val1 + " , " + val2);
   
 }
 
 public void doDelete(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;
   
   if ( sc.hasNextInt() == true )
   {
     val1 = sc.nextInt();
     if(val1 <= 0 || val1 >= this.airports.length)
     {
         System.err.println("Proper value expected");
         return;
     }
    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if ( sc.hasNextInt() == true )
   {
     val2 = sc.nextInt();
     if(val2 <= 0 || val2 >= this.airports.length)
     {
         System.err.println("Proper value expected");
         return;
     }
    } 
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   this.airports[val1].deleteAvailable(val2);
   
   System.out.println("Airport " +val1 + " to " + val2 + " deleted");
 }
 
 public void doList(Scanner sc)
 {
     for(int i = 1; i < this.airports.length; i++)
     {
         System.out.print("Airport"+i + " Can travel directly to Airport: ");
         for(int j = 1; j < this.airports.length; j++)
         {
             //System.out.println("If excuted");
             if(this.airports[i].findAvailable(j))
             {
                 System.out.print(j + " , " );
             }
         }
         
         System.out.println();
     }
 }
 
 public void doFile(Scanner sc)
 {
   String fname = null;
   
   if ( sc.hasNext() == true )
     fname = sc.next();
   else
   {
     System.out.println ("Filename expected");
     return;
   }
   
   System.out.println ("Performing the File command with file: " + fname);
   
   
   
   // next steps:  (if any step fails: print an error message and return ) 
   //  1. verify the file name is not currently in use
        
   //  2. open the file
   //  3. create a new instance of BufferedReader
   if(filesInUse.exist(fname))
   { 
       System.err.println("File calling the file that already in use");
       return;
   }
   
   System.out.println(fname+ " pushed");
   filesInUse.push(fname);
   BufferedReader br;
   try
   {
       br = new BufferedReader (new FileReader (fname));
       processCommandLoop(br);
       br.close();
       filesInUse.pop();
       System.out.println(fname + "Popped");
       
   }
   catch(FileNotFoundException fnfe)
   {
       System.err.println("File not Found");
       return;
   }
   catch(IOException ioe)
   {
       System.err.println("File Can't Close");
       return;
   }
   
   //  4. recursively call processCommandLoop() with this new instance of BufferedReader as the parameter
   //  5. close the file when processCommandLoop() returns
 }
 
}
