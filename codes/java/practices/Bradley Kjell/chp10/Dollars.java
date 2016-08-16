import java.util.Scanner;

class Dollars {
public static void main (String [] args) {
int dollars, totalcents, dollarcents;
Scanner scan = new Scanner(System.in);

System.out.println("Input the cents:");
totalcents = scan.nextInt();
dollars = totalcents / 100;
dollarcents = totalcents % 100;

System.out.println("That is "+dollars
        +" dollars and "+dollarcents
        +" cents.");
        }}