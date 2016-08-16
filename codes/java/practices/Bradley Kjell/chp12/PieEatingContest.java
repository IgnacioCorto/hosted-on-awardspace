import java.util.Scanner;
class PieEatingContest
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    int w;

    System.out.println("Weight of Contestant:");
    w = scan.nextInt();
    
    if (w<30) {
        System.out.println("Contestan is NOT allowed");
    } else if(w>250) {
        System.out.println("Contestan is NOT allowed");
    } else {
        System.out.println("Contestan is ALLOWED");
    }
    
  }
}
