import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
    //instance variables
    private int[][] maze;
    private boolean exitFound;

    //constructors
    public Maze()
    {
        exitFound = false;
        maze = new int[0][0];
    }

    public Maze(int size, String line)
    {
        exitFound=false;
        maze = new int[size][size];
        int spot=0;
        //out.println(line);
        for(int r = 0; r < maze.length; r++)
        {
            for(int c =0 ; c < maze[r].length; c++)
            {
                maze[r][c]=(line.charAt(spot*2)-48);
                spot++;
            }
        }
    }
    
    //other methods
    public void checkForExitPath(int r, int c)
    {
        if (maze[r][c]!=1)
        {
            exitFound=false;
        }
        else
        {
            maze[r][c] = 7;
            if (r==maze.length-1)
            {
                exitFound=true;
            }
            else 
            {
                if (!exitFound)
                {
                    checkForExitPath(r, c+1);
                }
                if (!exitFound)
                {
                    checkForExitPath(r+1, c);
                }
                if (!exitFound)
                {
                    checkForExitPath(r, c-1);
                }
                if (!exitFound)
                {
                    checkForExitPath(r-1, c);
                }
            }
        }
    }

    public String toString()
    {
        if (exitFound)
        {
            System.out.println("exit found");
        }
        else
        {
            System.out.println("exit not found");
        }
        
        String matrix="";
        
        for (int r=0; r<maze.length; r++)
        {
            for (int c=0; c<maze[r].length; c++)
            {
                matrix+=maze[r][c]+ " ";
            }
            matrix+="\n";
        }
        
        return matrix;
    }
}