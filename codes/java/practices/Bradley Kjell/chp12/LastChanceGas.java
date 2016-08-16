import java.util.Scanner;
class LastChanceGas
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    int tank, reading, miles, totalMiles;

    System.out.println("Tank capacity:");
    tank = scan.nextInt();

    System.out.println("Gage reading:");
    reading = scan.nextInt();

    System.out.println("Miles per gallon:");
    miles = scan.nextInt();

    totalMiles = tank * reading * miles / 100;
    
    System.out.println("Total Miles: "+totalMiles);

    if(totalMiles<200) {
        System.out.println("Get Gas !!!");
    } else {
        System.out.println("Safe to Proceed.");
    }
    
  }
}