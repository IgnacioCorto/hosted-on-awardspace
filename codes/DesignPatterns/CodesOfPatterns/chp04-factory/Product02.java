class Product02 implements Product {
    public void presentarse() {
        System.out.println("I AM "
            + this.getClass().getName()
            + ", DESCENDANT OF "
            + this.getClass().getSuperclass().getName()
            + " AND IMPLEMENT "
            + this.getClass().getInterfaces()[0].getName()
            );
    }
}