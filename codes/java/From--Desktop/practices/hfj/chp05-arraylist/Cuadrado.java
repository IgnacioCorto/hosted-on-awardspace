import java.io.*;

class Cuadrado {
    public static void main(String [] args) {
        try {
            System.out.print("Escriba el numero a elevar: ");
            BufferedReader entrada = new BufferedReader ( new InputStreamReader(System.in) );
            int numero = Integer.parseInt( entrada.readLine() );
//            int numero = entrada.readLine().parseInt();
            int numero2 = numero;
            System.out.println("El cuadrado es: "+(numero*numero2) );
        } catch (IOException e) {
            System.out.println("Excepcion: "+e );
        }
    }
}