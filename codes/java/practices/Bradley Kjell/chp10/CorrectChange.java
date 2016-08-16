import java.util.Scanner;

class CorrectChange {
public static void main (String [] args) {
int dollars, quarters,dimes, nickels, pennies;
Scanner scan = new Scanner(System.in);

System.out.println("Input the cents:");
pennies = scan.nextInt();

dollars = pennies / 100 ;
pennies = pennies % 100 ;

quarters = pennies / 25 ;
pennies = pennies % 25 ;

dimes = pennies / 10 ;
pennies = pennies % 10 ;

nickels = pennies / 5 ;
pennies = pennies % 5 ;

System.out.println("Your channge is: "
        + dollars + " dollars, "
        + quarters + " quarters, "
        + dimes + " dimes, "
        + nickels + " nickels and "
        + pennies + " pennies. ");
        }}