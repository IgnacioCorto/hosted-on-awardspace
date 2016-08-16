import java.util.*;

class IteratorTest {
    public static void main(String [] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add(new String("Hola Mundo"));
        al.add(new String("Hello World"));
        al.add(new String("Bonjour Monde"));
        
        Iterator it = al.iterator();
        String texto;
        
        
        for( 
            Iterator it = al.iterator(); 
            it.hasNext();
            it.next();
           ){
            texto = (String) it ;//.next();
            System.out.println(texto);
            it.next();
        }
    }
    
}