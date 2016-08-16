import java.util.ArrayList;

class MiArrayList {
    public static void main(String [] args) {
        ArrayList<String> saco = new ArrayList<String>();
        saco.add("1");
        saco.add("2");
        saco.add("3");
        System.out.println( "size(): " + saco.size() );
        System.out.println( "isEmpty()? " + saco.isEmpty() );
        System.out.println( "indexOf(3): " + saco.indexOf("3") );
        System.out.println( "contains(2)? " + saco.contains("2") );
        System.out.println( "get(0): " + saco.get(0) );
        saco.remove(2);
        saco.remove("2");
        System.out.println( "New size(): " + saco.size() );
        saco.remove(0);
        System.out.println( "Now isEmpty()? " + saco.isEmpty() );
    }
}