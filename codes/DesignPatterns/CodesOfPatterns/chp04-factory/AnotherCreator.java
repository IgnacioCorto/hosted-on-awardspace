class AnotherCreator implements Creator {

    public Product factoryMethod(int tipo) {
        if (tipo==2) { return new Product02(); } 
        return null;
    }
    
    public void anOperation() {

        System.out.println("FROM "
            + this.getClass().getName()
            + ", DESCENDANT OF "
            + this.getClass().getSuperclass().getName()
            + " AND IMPLEMENT "
            + this.getClass().getInterfaces()[0].getName()
            );

    }

}