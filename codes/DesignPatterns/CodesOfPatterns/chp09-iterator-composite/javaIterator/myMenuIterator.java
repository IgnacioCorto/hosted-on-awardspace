import java.util.Iterator;

class myMenuIterator implements Iterator {
    
    myComponent [] list;
    private int counter = 0;
    private int total;
    
    myMenuIterator(myComponent [] l ) {
        list = l;
        total = list.length;
    }

    public boolean hasNext() {
        return counter < total;
    }
    
    public Object next() {
        if ( hasNext() ) {
            Object hold = list[counter];
            counter++;
            // myComponent test = (myComponent) hold;
            // System.out.println("Debug: "+  test.getName() );
            return hold;
        } else {
            return null;
        }
    }

    public void remove() {
        throw new 
            UnsupportedOperationException
                ("Method not needed");
    }

}