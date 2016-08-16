import java.util.Scanner;
class BoxOffice
{
  public static void main (String[] args) 
  {
    Scanner scan = new Scanner( System.in );
    int age;
 
    System.out.println("Enter your age:");
    age = scan.nextInt();

    if ( age < 17 )
    {
      System.out.println("Child rate.");   
    } 
    else
    {
      System.out.println("Adult rate.");   
    }
    System.out.println("Enjoy the show.");    // always executed
  }
}
