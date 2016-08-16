class TestDrive {
    public static void main (String [] args) {
        SubjectObject subject 
            = new SubjectObject();
        ObserverObject observer1 
            = new ObserverObject(subject);
            
        subject.incrementarDato();
        subject.notifyIt();
        subject.incrementarDato();
        subject.notifyIt();
        subject.incrementarDato();
        subject.notifyIt();

        System.out.println("El dato de Subject es: "
            + subject.getDato() );

            System.out.println("El dato de Observer1 es: "
            + observer1.miDato);
        
        
    }
}