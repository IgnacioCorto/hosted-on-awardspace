import java.util.Scanner;
import java.io.*;

class StopWordRemover {
public static void main (String [] args) throws IOException {

    Scanner userScan = new Scanner(System.in);
    String input1, output1, token;
    int n=0, l=0;
    
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
        
        
        
        if ( token.equals("the") );
        else if ( token.equals("a") );
        else if ( token.equals("an") );
        else {

            // Limits Letters Per Line
            l=token.length()+1;
            if(n+l>13) { 
                n = 0;
                out01.print("\n");
            }
            n += l; 
        
            out01.print(token+" ");
            
        }
        
        // Limits Words Per Line
        // n++;
        // if (n>11) {
            // out01.print("\n");
            // n=0;
        // }
        
    }
    
    out01.close();

    System.out.println("\n\nFiles Created. Check them.");
    
}
}