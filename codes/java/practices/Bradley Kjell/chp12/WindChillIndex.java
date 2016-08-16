import java.util.Scanner;
class WindChillIndex
{
  public static void main (String[] args) {

    Scanner scan = new Scanner( System.in );
    double v,t,wci;

    System.out.println("Temperature:");
    t = scan.nextDouble();
    
    System.out.println("Wind Speed:");
    v = scan.nextDouble();

    if ( 0<=v ) {
        if ( v <=4 ) {
            //if (0 <= v <= 4) then 
            wci = t;
        } else {
            if (v>=45) {
                //if (v >=45) then 
                wci = (1.6*t) - 55;
            } else {
                //otherwise, 
                wci = 91.4 + (91.4 - t)
                    * ( (0.0203*v) - (0.304*Math.sqrt(v)) 
                    - 0.474);
            }
        }
    } else {
        //otherwise, 
        wci = 91.4 + (91.4 - t)
            * ( (0.0203*v) - (0.304*Math.sqrt(v)) 
            - 0.474);
    }
    
    System.out.println("Wind Chill Index: "+wci);

  }
}
