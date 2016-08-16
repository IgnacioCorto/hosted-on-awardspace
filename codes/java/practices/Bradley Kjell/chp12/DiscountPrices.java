import java.util.Scanner;
class DiscountPrices
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    double a, d, dp;

    System.out.println("Enter amount of purchases:");
    a = scan.nextDouble();
    if (a<10) d=0;
    else d=a*.1;
    
    dp=a-d;
    System.out.println("Discounted price: "+dp);
    
  }
}
