import java.util.Scanner;
class GroundBeefValue
{
  public static void main (String[] args)
  {
    double pppa,plpa, pppb, plpb, ta, tb;
    Scanner scan = new Scanner( System.in );

    System.out.println("Price per pound package A:");
    pppa  = scan.nextDouble();     

    System.out.println("Percent lean package A:");
    plpa  = scan.nextDouble();     

    System.out.println("Price per pound package B:");
    pppb  = scan.nextDouble();     

    System.out.println("Percent lean package B:");
    plpb  = scan.nextDouble();     
    
    ta = pppa * 100 / plpa; 
    tb = pppb * 100 / plpb; 
    
    System.out.println("Package A cost per pound of lean: "
        + ta + "\nPackage A cost per pound of lean: " + tb );

    if (ta<tb) System.out.println("Package A is the best value");
    else System.out.println("Package B is the best value");

    }
}

