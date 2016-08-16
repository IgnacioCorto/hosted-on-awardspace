import java.util.Scanner;

class SquareRoot
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner( System.in );
    double value;

    // read in a double
    System.out.print  ("Enter a double:");
    value = scan.nextDouble();
    
    // calculate its square root
    double result = Math.sqrt( value );
    
    // write out the result
    System.out.println("square root: " + result );
  }
}
