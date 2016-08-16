import java.util.Scanner;
import java.io.*;

class SeparateSums {
public static void main (String [] args) throws IOException {

    String holder;
    int number, Xsum=0, Ysum=0, invalido=0;
    
    File file1 = new File("XYtest.txt");
    
    Scanner dataScan = new Scanner(file1);
    
    while(dataScan.hasNext()) {
        holder = dataScan.next();
        number = dataScan.nextInt();
        if ( holder.equals("x=") ) {
            Xsum += number;
        } else if ( holder.equals("y=") ) {
            Ysum += number;
        } else {
            invalido++;
        }
    }
    

    System.out.println("\n\nTotals:"
        +"\nSum of X: "+Xsum
        +"\nSum of Y: "+Ysum
        +"\nInvalid : "+invalido
    );
    
}
}