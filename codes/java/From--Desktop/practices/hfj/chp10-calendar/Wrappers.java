class Wrappers {
    public static void main(String [] klk) {
        int entero = 2;
        String cadena = "2";

        int entero2 = Integer.parseInt(cadena);
        String cadena2 = Integer.toString(entero);
        
        System.out.println( "" 
                + "Entero: " + entero2 + "\n" 
                + "Cadena: " + cadena2
                );
    }
}