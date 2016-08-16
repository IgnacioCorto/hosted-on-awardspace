import java.util.Scanner;
import java.io.*;

class LongCounter {
public static void main (String [] args) throws IOException {

    Scanner userScan = new Scanner(System.in);
    String input1, output1, label="";
    int groupCant=0, currentGroup=0, groupSum=0, qty=0, number,
            startSum=0,finishSum=0,startAvg=0, finishAvg=0,
            change;
    boolean tiene;
    
    input1 = "LongCounterInput.txt";
    output1 = "LongCounterOutput.txt";
    
    File file1 = new File(input1);
    File file2 = new File(output1);
    
    Scanner dataScan = new Scanner(file1);
    PrintStream out01 = new PrintStream(file2);
    
    groupCant = dataScan.nextInt();
    
    for ( int i=1; i <= groupCant; i++) {

        qty = dataScan.nextInt();
        out01.println ( "Group " + i + ", " 
                + qty + " Subjects");
        if (qty>0)  {       
            for (int j=1; j <=qty; j++) {
                startSum += dataScan.nextInt();
                finishSum += dataScan.nextInt();
            }
            
            startAvg = startSum / qty ;
            finishAvg = finishSum / qty ;
            change = finishAvg - startAvg;
            
            out01.println ("\taverage starting cholesterol: "
                + startAvg );
            out01.println ("\taverage final    cholesterol: "
                + finishAvg );
            out01.println ("\tchange in        cholesterol: "
                + change );
        }
                
        startSum = finishSum = 0;

    }
    out01.println ("Done with processing.");
    out01.close();

    System.out.println("\n\nFiles Created. Check them.");
    
}
}