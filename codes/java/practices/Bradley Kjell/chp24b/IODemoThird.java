import java.text.*;
import java.util.Locale;

class IODemoThird
{
  public static void main ( String[] args )
  {
    DecimalFormat numform = new DecimalFormat("0000.00"); 
    System.out.println( "Third = " 
        + numform.format(11111111.1111) 
        + ", Locale: "+ Locale.getDefault()
    );
    
  }
}
