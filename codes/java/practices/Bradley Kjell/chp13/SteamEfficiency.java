import java.util.Scanner;

class SteamEfficiency
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    double efficiency, Tair, Tsteam;

      System.out.println("Air Temperature (in Kelvin):"  );
      Tair = scan.nextDouble();
      
      System.out.println("Steam Temperature (in Kelvin):"  );
      Tsteam = scan.nextDouble();

      if (Tsteam < 373) efficiency = 0;
      else efficiency = 1 - Tair / Tsteam;

      System.out.println("\nSteam Engine Efficiency:"
            +efficiency
            );

  }
}
