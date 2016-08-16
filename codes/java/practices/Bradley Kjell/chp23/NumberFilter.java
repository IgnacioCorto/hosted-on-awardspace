import java.util.Scanner;
import java.io.*;

class NumberFilter {
public static void main (String [] args) throws IOException {

    Scanner userScan = new Scanner(System.in);
    String input1, output1, output2;
    int numero;
    
    System.out.println("Enter Input File");
    input1 = userScan.nextLine().trim();
    
    System.out.println("Enter Positives Output File");
    output1 = userScan.nextLine().trim();
    
    System.out.println("Enter Negatives Output File");
    output2 = userScan.nextLine().trim();
    
    File file1 = new File(input1);
    File file2 = new File(output1);
    File file3 = new File(output2);
    
    Scanner dataScan = new Scanner(file1);
    PrintStream out01 = new PrintStream(file2);
    PrintStream out02 = new PrintStream(file3);
    
    while(dataScan.hasNextInt()) {
        numero = dataScan.nextInt();
        if (numero < 0) {
            out02.println(numero);
        } else {
            out01.println(numero);
        }
    }
    
    out01.close();
    out02.close();

    System.out.println("\n\nFiles Created. Check them.");
    
}
}