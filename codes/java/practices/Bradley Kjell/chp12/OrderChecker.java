import java.util.Scanner;
class OrderChecker
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    final double boltPrice=5, nutPrice=3, washerPrice=1;
    double bolts, nuts, washers,
            boltsTotal,nutsTotal,washersTotal,total;

    System.out.println("Number of bolts:");
    bolts = scan.nextDouble();
    System.out.println("Number of nuts:");
    nuts = scan.nextDouble();
    System.out.println("Number of washers:");
    washers = scan.nextDouble();

    if (bolts!=nuts) { 
        System.out.println("Check the Order!!"); 
    }

    boltsTotal = bolts * boltPrice;
    nutsTotal = nuts * nutPrice;
    washersTotal = washers * washerPrice;
    total = boltsTotal+ nutsTotal + washersTotal ;

    System.out.println("Total cost: "+total);
    
  }
}
