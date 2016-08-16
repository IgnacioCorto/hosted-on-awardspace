// This program requires Java 1.5 or higher
//
import java.io.*;
import java.util.Scanner;

class DoubleDouble
{
  public static void main (String[] args)
  {
    double value;
    Scanner scan = new Scanner( System.in );
 
    System.out.print("Enter a double:");
    value = scan.nextDouble();

    System.out.println("value: " + value +" twice value: " + 2.0*value );
  }
}
