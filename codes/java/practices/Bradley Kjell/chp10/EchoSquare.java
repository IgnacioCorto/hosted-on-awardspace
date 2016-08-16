import java.util.Scanner;

class EchoSquare
{
  public static void main (String[] args)
  { 
    Scanner scan = new Scanner( System.in );
    int num, square;      // declare two int variables 

    System.out.println("Enter an integer:");
    num = scan.nextInt();
    square = num * num ;  // compute the square 

    System.out.println("The square of " + num + " is " + square);
  }
}
