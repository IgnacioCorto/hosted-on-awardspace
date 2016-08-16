import java.util.Scanner;

class KWH {
public static void main (String [] args) {
Scanner scan = new Scanner(System.in);
double cents, kwh, cost;

System.out.println("Enter cost per kilowatt-hour in cents:");
cents = scan.nextDouble();

System.out.println("Enter kilowatt-hours used per year:");
kwh = scan.nextDouble();

cost = kwh * cents;
System.out.println("Annual Cost: "+cost);

}
}