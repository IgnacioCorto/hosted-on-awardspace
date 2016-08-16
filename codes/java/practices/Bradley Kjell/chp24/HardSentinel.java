import java.util.Scanner;
import java.io.*;

class HardSentinel {
public static void main (String [] args) throws IOException {

    Scanner userScan = new Scanner(System.in);
    String input1, output1, label="";
    int currentGroup=0, groupSum=0, qty=0, number;
    boolean tiene;
    
    input1 = "HardSentinelInput.txt";
    output1 = "HardSentinelOutput.txt";
    
    File file1 = new File(input1);
    File file2 = new File(output1);
    
    Scanner dataScan = new Scanner(file1);
    PrintStream out01 = new PrintStream(file2);
    
    while(true) {
        tiene = dataScan.hasNext();
        if(tiene) label = dataScan.next();
        
        if( !tiene || label.equals("next") ) {
            if (currentGroup>0) {
                if (qty>0) {
                    out01.println( "Sum of Group " 
                        + currentGroup 
                        + " is " + groupSum );
                } else {
                    out01.println( "Group " 
                        + currentGroup 
                        + " contains no data.");
                }
                
                groupSum=0;
                qty=0;
            } 
            currentGroup++;
        } else {
            number = Integer.parseInt(label);
            groupSum += number;
            qty++;
        }
        if (!tiene) break;
    }

    out01.close();

    System.out.println("\n\nFiles Created. Check them.");
    
}
}