import java.util.ArrayList;

class MapTest {
	public static void main(String [] args) {
		ArrayList<Object> lst = new ArrayList<Object>();
        lst.add(new Integer(1));
        lst.add(new String("A"));
        Integer d0 = (Integer) lst.get(0);
        String d1 = (String) lst.get(1);
        
        System.out.println("Numero: "+d0.toString());
        System.out.println("Cadena: "+d1.toString());
       
        System.out.println("PI: "+Math.PI);
        
	}
}
