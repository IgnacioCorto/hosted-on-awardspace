import java.util.Scanner;

class OhmLaw {
public static void main (String [] args) {
int R, V;
double I;
Scanner scan = new Scanner(System.in);

System.out.println("Input the Voltage:");
V = scan.nextInt();
System.out.println("Input the Resistance:");
R = scan.nextInt();

I = (V+0.0)/R;

System.out.println("The Current of "+V
        +" Volts and "+R
        +" Ohms is "+I
        +" Amps.");
        }}