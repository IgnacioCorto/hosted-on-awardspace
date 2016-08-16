import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class AllInOne {
    public static void main (String [] args) {
        System.out.println("\n");

        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(1); lista1.add(2); lista1.add(3);
        System.out.println("Total de Lista: "+lista1.size());
        System.out.println("Elemento 0: "+lista1.get(0));
        System.out.println("Datos Lista: "+lista1.toString());
        System.out.println("Elemento 0: "+lista1.get(0));

        try {
        System.out.print("Escribe Algo: ");
        BufferedReader is = new BufferedReader (
            new InputStreamReader(System.in) );
        System.out.println("Nueva Cadena Entrada ===> "
        + is.readLine() );
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try {
            int i = 7 / 0 ;
        } catch (Exception ex) {
            System.out.print("HUBO UN ERROR: ");
            ex.printStackTrace();
        }

        System.out.println("3 Aleatorios: "
            + Math.random() + " "
            + Math.random() + " "
            + Math.random() + " "
        );
    
        //int [6] il = new int[6];
        int seis = 6; 
        Float [] flotantes;
        flotantes = new Float[seis];
        int [] il = {1,2,3,4,5,6};
        System.out.print("Lista de Enteros: ");
        for (int i : il ) {
        System.out.print(i+" ");
        } System.out.println();
    
        System.out.println("Suma de enteros: "
            + (Integer.parseInt("1")+Integer.parseInt("2"))
        );
        
    }
}