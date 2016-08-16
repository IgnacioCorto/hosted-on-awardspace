import java.util.Scanner;
class Y2K
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    int b,n,a;

    System.out.println("Year of Birth:");
    b = scan.nextInt();
    
    System.out.println("Current year:");
    n = scan.nextInt();

    if (b>n) a = 100-b+n;
    else { a = n-b; }

    System.out.println("Your age:"+a);

  }
}
