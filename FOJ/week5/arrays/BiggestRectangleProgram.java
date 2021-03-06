import javax.swing.*;
import java.util.*;

public class BiggestRectangleProgram
{
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        Rectangle[] rects = readRectangles();
        Rectangle biggest = findBiggest(rects);
        System.out.println("The biggest rectangle is " + biggest);
    }

    private static Rectangle findBiggest(Rectangle[] rects)
    {
        Rectangle biggestSoFar = rects[0];
        for (int i = 1; i < rects.length; i++)
        {
          if (rects[i].getArea() > biggestSoFar.getArea())
            biggestSoFar = rects[i];
            //if (this one is bigger than biggestSoFar)
            //    biggestSoFar = this one
        }
        return biggestSoFar;
    }

    private static Rectangle[] readRectangles()
    {
        // This method contains both syntax errors *and* logic errors
        //
        int howMany = getInt("How many rectangles?");
        Rectangle[] rects = new Rectangle[howMany];
        for (int i = 0; i < howMany; i++)
        {
            int width = getInt("Width of rectangle #"+(i + 1)+":");
            int height = getInt("Height of rectangle #"+(i + 1)+":");
            rects[i] = new Rectangle(width, height);
        }
        return rects;
    }

    private static int getInt(String prompt)
    {
        System.out.print(prompt + " ");
        return keyboard.nextInt();
    }
}
