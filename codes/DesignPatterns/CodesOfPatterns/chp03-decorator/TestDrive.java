class TestDrive {
    public static void main ( String [] args ) {
        Bebida beb1 = new Leche();
        beb1 = new DecoradorAzucar(beb1);
        beb1 = new DecoradorAzucar(beb1);
        beb1 = new DecoradorAzucar(beb1);
        beb1 = new DecoradorAzucar(beb1);
        beb1 = new DecoradorAzucar(beb1);
        
        System.out.println( beb1.getDescripcion()
            + " --> " + beb1.costo() );

    }
}