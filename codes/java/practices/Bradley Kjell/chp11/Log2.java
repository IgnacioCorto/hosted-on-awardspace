import java.util.Scanner;

class Log2 {
public static void main (String [] args) {

double X,Y,A,H;
Scanner scan = new Scanner(System.in);

System.out.println("Enter X:");
X = scan.nextDouble();

System.out.println("Enter Y:");
Y = scan.nextDouble();

A = (X+Y)/2;
H = 2 / ( 1/X + 1/Y );

System.out.println("Arithmetic mean: "+A
        +"\nHarmonic   mean: "+H);
        
       
}
}