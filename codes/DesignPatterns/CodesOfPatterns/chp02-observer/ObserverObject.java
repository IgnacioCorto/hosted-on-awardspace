class ObserverObject implements ObserverInterface {
    SubjectObject mySubject;
    int miDato = 10;

    ObserverObject(SubjectObject so) {
        mySubject = so;
        mySubject.addOne(this);
    }
    
    public void updateIt() {
        miDato+=mySubject.getDato();
    }
}