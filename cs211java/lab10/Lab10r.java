/** Code to show and explore recursion
  * 
  * The code also shows one approach at using a debug mode
  */

public class Lab10r
{
  // Ideas for debug mode code for Java
  private static boolean debug;
  
  public static void debugOn()
  {
    debug = true;
  }
  
  public static void debugOff()
  {
    debug = false;
  }
  
  public static void dprintln (String s)
  {
    if ( debug == true )
      System.out.println (s);
  }
  // end of code for the debug mode
  
  public static void main (String[] args)
  {
    // initialize the debug mode to false and check if the command line arguments contain -d
    debugOff();
    if (args.length > 0 && args[0].equals("-d"))
      debugOn();
    
    System.out.println ("fact(5) is: " + fact(5) );
    System.out.println ("fact(15) is: " + fact(15) );
    
    // force debug mode to be off: debug = false;
    debugOff();
    System.out.println ("fib(5) is: " + fib(5) );
    System.out.println ("fib(15) is: " + fib(15) );
    //force debug mode to be on: debug = true;
    debugOn();
    
    System.out.println ("power(2, 5) is: " + power(2, 5) );
    System.out.println ("power(2, 15) is: " + power(2, 15) );
    
    System.out.println ("isPrime(1) is: " + isPrime(1) );
    System.out.println ("isPrime(2) is: " + isPrime(2) );
    System.out.println ("isPrime(7) is: " + isPrime(7) );
    System.out.println ("isPrime(8) is: " + isPrime(8) );
    System.out.println ("isPrime(201) is: " + isPrime(201) );
    System.out.println ("isPrime(211) is: " + isPrime(211) );

  }
  
 // calculate factiorial recursively
 public static int fact (int num)
 {
   // traditional debug mode usage
   if (debug == true)
     System.out.println ("In fact(" + num + ")");
   
   if ( num <= 0 )
     return 1;
   else
     return num * fact(num - 1);
 }
 
 // calculate fibonacci valuesrecursively
 public static int fib (int num)
 {
   // improved debug mode usage
   dprintln ("In fib(" + num + ")");
   
   if ( num <= 0 )
     return 0;
   else if ( num == 1 )
     return 1;
   else
     return fib(num - 2) + fib(num - 1);
 }
    
 // isPrime itself is not recursive
 //  However it uses the helper function of factorInRange which is recursive
 public static boolean isPrime (int num)
 {
   if ( num < 2 )
     return false;
   else if ( factorInRange( 2, num ) == false)
     return true;
   else
     return false;
 }
 
 // reccursive Helper Function for isPrime()
 public static boolean factorInRange (int m, int n)
 {
   dprintln ("In factorInRange(" + m + ", " + n + ")");
   
   
   if ( m >= n )
     return false;
   else if ( n%m == 0)
     return true;
   else if ( m == 2)
     return factorInRange (m+1, n);
   else
     return factorInRange (m+2, n);
 }
 
 
 // calcuate one value raise to the power of another recursively
 public static int power (int base, int exp)
 {
   dprintln ("In power(" + base + ", " + exp + ")");
   
   if ( exp <= 0 )
     return 1;
   else if ( exp == 1)
     return base;
   else if (exp % 2 == 0)
   {
     int tmp = power (base, exp/2);
     return ( tmp * tmp );
   }
   else
     return base * power (base, exp-1);
 }   
    
 // calcualte the greatest common divisor of two numbers recursively
 public static int greatestCommonDivisor (int a, int b)
  {
    dprintln ("In gcd(" + a + ", " + b + ")");
   
    // computer Greatest Common Divisor recursively via Euclid's algorithm
    if (b == 0)
      return a;
    else 
      return greatestCommonDivisor (b, a%b);
  }
}
  
  