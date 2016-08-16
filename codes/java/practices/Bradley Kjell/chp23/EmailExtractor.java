import java.util.Scanner;
import java.io.*;

class EmailExtractor {
public static void main (String [] args) throws IOException {

    Scanner userScan = new Scanner(System.in);
    String input1, output1, token;
    int ai=0, l=0;
    
    System.out.println("Enter Input File");
    input1 = userScan.nextLine().trim();
    
    System.out.println("Enter Output File");
    output1 = userScan.nextLine().trim();
    
    File file1 = new File(input1);
    File file2 = new File(output1);
    
    Scanner dataScan = new Scanner(file1);
    PrintStream out01 = new PrintStream(file2);
    
    while(dataScan.hasNext()) {
        token = dataScan.next();
        if ( (ai=token.indexOf('@')) != -1 ) {
            if ( token.indexOf('.', ai) != -1 ) {
                out01.println(token+' ');
            }
        }
        
    }
    
    out01.close();

    System.out.println("\n\nFiles Created. Check them.");
    
}
}