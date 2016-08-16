import java.util.Stack;
import java.util.Iterator;

class myCompositeIterator implements Iterator {
    
    Stack<Iterator> iStack = new Stack<Iterator>();
    
    myCompositeIterator(Iterator i) {
        iStack.push(i);
    }

    public boolean hasNext() {
        if ( iStack.isEmpty() ) return false;
        
        Iterator current =  (Iterator) iStack.peek();
        if ( current.hasNext() ) return true;

        iStack.pop();
        return hasNext();
    }
    
    public Object next() {

        if ( hasNext() ) {
            Iterator current = (Iterator) iStack.peek();
            Object o = current.next();

            Iterator nIt = ((myComponent)o).createIterator();
            if(nIt!=null) iStack.push(nIt);

            // if (o instanceof myMenu) {
                // myMenu aMenu = (myMenu) o;
                // iStack.push( aMenu.createIterator() );
            // }
            return o;
        
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