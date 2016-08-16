class FactoryTestDrive {
    public static void main(String [] args) {
        Creator c = new AnotherCreator();
        Product p = c.factoryMethod(2);
        if (p!=null) {
            p.presentarse();
            c.anOperation();
        }
    
    }
}