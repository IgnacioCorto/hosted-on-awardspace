import java.io.*;

class PrintTextFile 
{

  public static void main ( String[] args ) throws IOException
  {
    File file = new File( "myOutput.txt" );
    PrintStream  print = new PrintStream( file );

    print.println( "The world is so full"  );  
    print.println( "Of a number of things,"  );  
    print.println( "I'm sure we should all" );  
    print.println( "Be as happy as kings."  );  

    print.close();
  }
}
