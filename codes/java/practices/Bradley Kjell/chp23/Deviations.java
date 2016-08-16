import java.util.Scanner;
import java.io.*;

class Deviations
{
  public static void main (String[] args) throws IOException
  { 
    double sum=0, sumSQ=0,
            avg=0, avgSQ=0, vari=0, sd=0,
            N=0, currentData;
    
    File archivo = new File("doubles.txt");
    Scanner dataScan = new Scanner(archivo);
    
    while(dataScan.hasNextDouble()) {
        currentData = dataScan.nextDouble();
        sum += currentData;
        sumSQ += Math.pow(currentData,2);
        N++;
    }
    
    avg = sum / N;
    avgSQ = sumSQ / N;
    vari = avgSQ - Math.pow(avg,2);
    sd = Math.sqrt(vari);
    
    System.out.println("\nGrand Totals: "
        +"\nSum: "+ sum
        +"\nSum of Squares: "+ sumSQ
        +"\nAverage: "+ avg
        +"\nAverage Square: "+ avgSQ
        +"\nVariance: "+ vari
        +"\nStandard Deviation: "+ sd
        );
  }
}
