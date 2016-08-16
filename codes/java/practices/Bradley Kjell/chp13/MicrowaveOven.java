import java.util.Scanner;

class MicrowaveOven
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int items, time, recommended;

      System.out.println("Number of Items: "  );
      items = scan.nextInt();
      
      System.out.println("Single Item Heating Time:"  );
      time = scan.nextInt();

      if (items==1) {
        recommended = time;
        System.out.println("It is OK with that time."  );
      } else if (items==2) {
        recommended = (int) (time * 1.5);
        System.out.println("Recommended Time: "+ recommended );
      } else if (items==3) {
        recommended = time * 2;
        System.out.println("Recommended Time: "+ recommended );
      } else {
        System.out.println("USING MICROWAVE NOT RECOMMEND!!");
      }
      
  }
}
