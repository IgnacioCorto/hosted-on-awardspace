class ConcreteCreator implements Creator {

    public Product factoryMethod(int tipo) {
        if (tipo==1) { return new Product01(); } 
        if (tipo==2) { return new Product02(); } 
        return null;
    }
    
    public void anOperation() {
        System.out.println("Operacion Realizada.");
    }

}