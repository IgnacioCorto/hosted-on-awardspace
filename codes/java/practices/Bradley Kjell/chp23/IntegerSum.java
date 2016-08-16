import java.util.Scanner;
import java.io.*;

class IntegerSum
{
  public static void main (String[] args) throws IOException
  { 
    int sum=0;
    
    File archivo = new File("integers.txt");
    Scanner data = new Scanner(archivo);
    
    while(data.hasNextInt()) {
        sum += data.nextInt();
    }
    
    System.out.println("Total of Integers: "+sum);
  }
}
