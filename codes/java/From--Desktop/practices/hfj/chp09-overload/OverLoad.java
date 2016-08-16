class OverLoad {
    public static void main(String [] args) {
        System.out.println( dato() );
        System.out.println( dato() );
    }
    
    public static int dato() { return 1; }
    public static char dato() { return 'a'; }
}