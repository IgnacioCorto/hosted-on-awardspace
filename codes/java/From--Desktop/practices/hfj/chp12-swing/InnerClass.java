class InnerClass {
    public static void main (String [] args) throws Exception {
        MyOuter obj = new MyOuter();
        obj.doStuff();
    }
}

class MyOuter {
    private int x;
    MyInner inner = new MyInner();
    
    public void doStuff() {
        inner.go();
        System.out.println(x);
    }

    class MyInner {
        void go() {
            x = 42;
        }
    }
    
}