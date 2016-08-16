import java.util.Scanner;
class TaxProgram
{
  public static void main (String[] args)
  {
    final double taxRate = 0.05;
    Scanner scan = new Scanner( System.in );
    double price;
    double tax ;

    System.out.println("Enter the price:");
    price  = scan.nextDouble();     

    if ( price >= 100.0  )
      tax = price * taxRate;   
    else
      tax = 0.0;

    System.out.println("Item cost: " + price + 
        " Tax: " + tax + " Total: " + (price+tax) );    
  }
}
