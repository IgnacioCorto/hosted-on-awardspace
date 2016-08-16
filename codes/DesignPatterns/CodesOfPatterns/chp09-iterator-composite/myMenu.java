class myMenu extends myComponent {

    myComponent [] childs;
    
    myMenu ( String n ) {
        super(n);
    }

    void addList(myComponent [] c) {
        childs = c;
    }

    myIterator createIterator() {
        return new myMenuIterator(childs);
    }

}