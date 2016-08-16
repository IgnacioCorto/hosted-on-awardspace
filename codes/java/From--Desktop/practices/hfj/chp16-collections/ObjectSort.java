import java.util.*;

class ObjectSort implements Comparable<ObjectSort> {
	private String name;
    private int size;
    


    ObjectSort(String n, int s) {
        name = n;
        size = s;
    }
    
    public String toString() {
        return name;
    }

    public static void main(String [] args) {
        new ObjectSort();
    }
    
    
    
    ObjectSort() {
        
        // ArrayList 

        ArrayList<ObjectSort> lista = new ArrayList<ObjectSort>();
        
        // Comparator
        SizeCompare sizeComp = new SizeCompare();
        
        lista.add(new ObjectSort("d",0));
        lista.add(new ObjectSort("c",1));
        lista.add(new ObjectSort("c",1));
        lista.add(new ObjectSort("a",3));
        lista.add(new ObjectSort("b",2));
        
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));

        Collections.sort(lista);
        System.out.println("ArrayList Comparable : " + lista + "\n");

        Collections.sort(lista, sizeComp);
        System.out.println("ArrayList Comparator : " + lista + "\n");

        // HashSet
        
        HashSet<ObjectSort> objHashSet = new HashSet<ObjectSort>();
        objHashSet.addAll(lista);
        System.out.println("HashSet : " + objHashSet + "\n");

        // TreeSet Comparable
        TreeSet<ObjectSort> objTreeSet = new TreeSet<ObjectSort>();
        objTreeSet.addAll(lista);
        System.out.println("TreeSet Comparable : " + objTreeSet + "\n");

        // TreeSet Comparator
        TreeSet<ObjectSort> objTreeSetComp = new TreeSet<ObjectSort>(sizeComp);
        objTreeSetComp.addAll(lista);
        System.out.println("TreeSet Comparator: " + objTreeSetComp + "\n");
        
        // HashMap
        
        HashMap<Integer, String> primerMapa = new HashMap<Integer,String>();
        primerMapa.put(0,"cero");
        primerMapa.put(1,"uno");
        primerMapa.put(2,"dos");
        primerMapa.put(3,"tres");
        
        System.out.println("HashMap : " + primerMapa + "\n");
        System.out.println("get(3) : " + primerMapa.get(3) + "\n");
        
    }
    
    // GETTERS AND SETTERS
    String getName() {
        return name;
    }

    int getSize() {
        return size;
    }

    // ==================================================
    
    public int compareTo(ObjectSort o){
        return name.compareTo(o.getName());
    }
    
    public boolean equals(Object aTest) {
        ObjectSort hold = (ObjectSort) aTest;
        return getName().equals( hold.getName() );
    }

    public int hashCode() {
        return name.hashCode();
    }
  
    // ===== Ccmparator Class =====
    
    class SizeCompare implements Comparator<ObjectSort> {
        public int compare(ObjectSort a, ObjectSort b) {
            return a.getSize() - b.getSize();
        }
    }
    
    
    
}