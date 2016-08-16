class myMenuIterator implements myIterator {
    
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

}