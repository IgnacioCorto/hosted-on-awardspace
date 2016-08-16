import java.util.Scanner;

class InternetDelicatessen
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    double price,total,shipping;
    String product;
    int overnight;

      System.out.println("Enter the item:"  );
      product = scan.nextLine();
      
      System.out.println("Enter the price:"  );
      price = scan.nextDouble();

      System.out.println("Overnight delivery (0==no, 1==yes) ?");
      overnight = scan.nextInt();

      if (price < 10) shipping = 2;
      else shipping = 3;

      if (overnight==1) shipping+=5;
      total=price+shipping;
      
      System.out.println("\nInvoice:"
            +"\n\t"+product+": "+price
            +"\n\tShipping: "+shipping
            +"\n\tTotal: "+total
            );

  }
}
