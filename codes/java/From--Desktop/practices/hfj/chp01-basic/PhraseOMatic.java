class PhraseOMatic {
    public static void main(String [] args) {
        String [] palabras = {"Rico","Millonario","Poderoso"};
        int contador = 10;
        int selector = 0;
        int totalPalabras = palabras.length;
        while(contador>0){
           selector = (int) (Math.random() * totalPalabras);
           System.out.println("Sere "+palabras[selector]);
           contador=contador-1;
        }
    }
}