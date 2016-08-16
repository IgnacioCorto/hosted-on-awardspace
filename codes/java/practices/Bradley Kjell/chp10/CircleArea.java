import java.util.Scanner;

class CircleArea {
public static void main (String [] args) {
int radius;
double area;
Scanner scan = new Scanner(System.in);

System.out.println("Input the radius:");
radius = scan.nextInt();
area = Math.PI * (radius *radius);
System.out.println("The radius is: "+radius
        +". The Area of the circle is: "+area);

        }}