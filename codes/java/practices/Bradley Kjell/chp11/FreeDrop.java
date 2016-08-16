import java.util.Scanner;

class FreeDrop {
public static void main (String [] args) {

Scanner scan = new Scanner(System.in);
double v,t;

System.out.println("Enter the number of seconds:");
t = scan.nextDouble();

v = 0.5 *32.174* (t*t);

System.out.println("Speed of the brick: "
        + v + " feet per second.");

}
}