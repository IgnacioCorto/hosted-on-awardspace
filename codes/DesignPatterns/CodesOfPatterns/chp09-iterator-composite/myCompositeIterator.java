import java.util.Stack;

class myCompositeIterator implements myIterator {
    
    Stack<myIterator> iStack = new Stack<myIterator>();
    
    myCompositeIterator(myIterator i) {
        iStack.push(i);
    }

    public boolean hasNext() {
        if ( iStack.isEmpty() ) return false;
        
        myIterator current =  (myIterator) iStack.peek();
        if ( current.hasNext() ) return true;

        iStack.pop();
        return hasNext();
    }
    
    public Object next() {

        if ( hasNext() ) {
            myIterator current = (myIterator) iStack.peek();
            Object o = current.next();
            if (o instanceof myMenu) {
                myMenu aMenu = (myMenu) o;
                iStack.push( aMenu.createIterator() );
            }
            return o;
        
        } else {
            return null;
        }
    }

}