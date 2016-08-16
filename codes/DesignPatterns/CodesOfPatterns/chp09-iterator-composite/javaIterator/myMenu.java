import java.util.Iterator;

class myMenu extends myComponent {

    myComponent [] childs;
    
    myMenu ( String n ) {
        super(n);
    }

    void addList(myComponent [] c) {
        childs = c;
    }

    Iterator createIterator() {
        return new myMenuIterator(childs);
    }

}