import java.io.*;

class Prueba {
    public static void main(String [] args) {
        System.gc();
        for(int i = 0; i<5; i++) {
            System.out.println("Va por "+i);
            // try { Thread.sleep(1000); }
            // catch (Exception e) { }
            try { 
                FileWriter fw = new FileWriter("Hola.txt");
                fw.write("Hola Mundo");
                fw.write("Hola Mundo");
                fw.close();
                
                BufferedReader fr = new BufferedReader( new FileInputStream("Hola.txt") );
                System.out.println( fr.readLine() );
                System.out.println( fr.readLine() );
                fr.close();


            } catch (Exception e) { }

        }
        String tolete = new String("KLK");
        System.out.println(tolete.getClass());
        try { 
            System.in.read();

        } catch (Exception e) { }
    }
}