import java.util.*;

public class Hli212Exam2
{

    public static void main(String[] args)
    {
	    // write your code here

        Scanner sc = new Scanner(System.in);
        double d = 0.0;

        MyQueue q1 = new MyQueue();
        MyQueue q2 = new MyQueue();

        System.out.println("Enter Value here, until non-positive");

        while(d >= 0.0)
        {

            while(!sc.hasNextDouble())
            {
                sc.next();
            }

            d = sc.nextDouble();

            if(d < 0.0)
            {
                break;
            }

            while( !q1.isEmpty() && q1.front() < d )
            {
                q2.enqueue(q1.front());
                q1.dequeue();
            }

            q2.enqueue(d);

            while(!q1.isEmpty())
            {
                q2.enqueue(q1.front());
                q1.dequeue();
            }

            while(!q2.isEmpty())
            {
                q1.enqueue(q2.front());
                q2.dequeue();
            }
        }// end of scanning while

        int count = 0;
        while(!q1.isEmpty())
        {
            count++;
            String string = "";
            string += Double.toString( q1.front());
            for(int i = 0; i < 16 - string.length(); i++)
            {
                string += " ";
            }
            System.out.print(string);

            if(count % 8 == 0)
            {
                System.out.println();
            }
            q1.dequeue();
        }

        System.out.println();



    }// end of main class

}
