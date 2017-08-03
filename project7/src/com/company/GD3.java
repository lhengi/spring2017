package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GD3 {

    public static void main( String args[] )
    {

        int seconds = 500; // default

        if(args.length != 0)
        {
            if(args[0].equals("-d"))
            {
                try
                {
                    seconds = Integer.parseInt(args[1]);
                }
                catch (NumberFormatException Nfe)
                {
                    System.err.println("Wrong command line input");
                    return;
                }

            }
            else
            {
                System.err.println("Wrong command line input");
                return;

            }
        }

        System.out.println("Sleep Time" + seconds);


        // create the grid of 25 rows and 35 columns
        GridDisplay disp = new GridDisplay(20, 20);
        Field field = new Field();
        field.setCreatures(5,100);

        while(true)
        {
            int antsCount = 0;
            int doodleCount = 0;
            Creature[][] newCreatures = field.getArray();
            for (int row = 0; row < 20; row++) {
                for (int col = 0; col < 20; col++) {
                    if (newCreatures[row][col] == null)
                    {
                        disp.setColor(row, col, Color.WHITE);
                    }
                    else if (newCreatures[row][col].getType().equals("Doodlebug"))
                    {
                        disp.setColor(row, col, Color.RED);
                        doodleCount++;
                    }
                    else
                    {
                        disp.setColor(row, col, Color.blue);
                        antsCount++;
                    }
                }
            }
            GridDisplay.mySleep(seconds);
            System.out.println("Ant population: " + antsCount);
            System.out.println("Doodlebug population: "+ doodleCount);
            field.next_day();
        }



        //System.out.println("Success run the loop");



        // some code to demonstrate the use of the setChar and setColor methods of GridDisplay
        /*
        disp.setChar(0,0,'t');
        disp.setColor(0,0,Color.BLUE);
        disp.setChar(1,1,'x');
        GridDisplay.mySleep(10000);
        for (int i = 1; i < 10; i = i + 2)
            disp.setChar (i, i*2, 'v');
        for (int i = 2; i < 12; i = i + 2)
            disp.setColor (i+1, i, Color.RED);
        for (int i = 3; i < 12; i++)
        {
            disp.setColor (1, i, Color.GREEN);
            GridDisplay.mySleep (250);  // sleep for 250 milliseconds i.e. 1/4 second
        }
        for (int i = 11; i > 3; i--)
        {
            disp.setColor (1, i, Color.LIGHT_GRAY);
            GridDisplay.mySleep (500);  // sleep for 500 milliseconds i.e. 1/2 second
        }
        for (int i = 2; i < 12; i++)
        {
            disp.setColor (i, 3, Color.GREEN);
            GridDisplay.mySleep (100);  // sleep for 100 milliseconds i.e. 1/10 second
        }

        for (int j = 0 ; j < 10 ; j ++)
        {
            for (int i = 2; i < 12; i++)
                disp.setColor (15, i, Color.RED);
            //GridDisplay.mySleep (250);  // sleep for 250 milliseconds i.e. 1/4 second

            for (int i = 2; i < 12; i++)
                disp.setColor (15, i, Color.YELLOW);
            //GridDisplay.mySleep (250);  // sleep for 250 milliseconds i.e. 1/4 second
        }
        */
    }
}  // end of GD3 class

class GridDisplay extends JFrame
{
    private JLabel labels[];

    private Container container;
    private GridLayout grid1;
    int rowCount;
    int colCount;

    // set up GUI
    public GridDisplay(int rows, int cols)
    {
        super( "GridDisplay for CS211" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // set up grid layout struture of the display
        rowCount = rows;
        colCount = cols;
        grid1 = new GridLayout( rows, cols );
        container = getContentPane();
        container.setLayout( grid1 );

        // create and add buttons
        labels = new JLabel[ rows * cols ];

        for ( int count = 0; count < labels.length; count++ ) {
            labels[ count ] = new JLabel( " " );
            labels[count].setOpaque(true);
            container.add( labels[ count ] );
        }

        // set up the size of the window and show it
        setSize( cols * 15 , rows * 15 );
        setVisible( true );

    } // end constructor GridLayoutDemo

    // display the given char in the (row,col) position of the display
    public void setChar (int row, int col, char c)
    {
        if ((row >= 0 && row < rowCount) && (col >= 0 && col < colCount) )
        {
            int pos = row * colCount + col;
            labels [pos].setText("" + c);
        }
    }

    // display the given color in the (row,col) position of the display
    public void setColor (int row, int col, Color c)
    {
        if ((row >= 0 && row < rowCount) && (col >= 0 && col < colCount) )
        {
            int pos = row * colCount + col;
            labels [pos].setBackground(c);
        }
    }

    // puts the current thread to sleep for some number of milliseconds to allow for "animation"
    public static void mySleep( int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException ie)
        {
        }
    }
} // end class GridDisplay
