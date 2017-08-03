package com.company;

import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        MyQueue stack = new MyQueue();

        stack.enqueue('H');
        stack.enqueue('e');
        stack.enqueue('n');
        stack.enqueue('g');
        stack.enqueue('!');



        while(!stack.isEmpty())
        {
            System.out.println(stack.top() + " "  );
            stack.dequeue();
        }

        stack.enqueue('L');
        stack.enqueue('i');

        System.out.println(stack.top() + " "   );

        stack.dequeue();
        System.out.println(stack.top() + " "  );
        stack.dequeue();

        stack.enqueue('B');
        stack.enqueue('a');
        stack.enqueue('c');
        stack.enqueue('k');
        stack.enqueue(' ');
        stack.enqueue('a');
        stack.enqueue('g');
        stack.enqueue('a');
        stack.enqueue('i');
        stack.enqueue('n');

        while(!stack.isEmpty())
        {
            System.out.println(stack.top() + " "  );
            stack.dequeue();
        }


    }



}

