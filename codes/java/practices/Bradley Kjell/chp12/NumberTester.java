import java.util.Scanner;

class NumberTester
{
  public static void main (String[] args) 
  {
    Scanner scan = new Scanner( System.in );
    int num;

    System.out.println("Enter an integer:");
    num = scan.nextInt();
    
    if ( num < 0 )   // is num less than zero?               
      System.out.println("The number " + num + " is negative");  // true branch
    else
      System.out.println("The number " + num + " is positive");  // false branch
    
    System.out.println("Good-bye for now");    // always executed
  }
}
