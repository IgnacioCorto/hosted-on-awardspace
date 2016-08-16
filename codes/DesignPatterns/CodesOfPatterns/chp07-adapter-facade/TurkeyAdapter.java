class TurkeyAdapter extends Duck {
    
    Turkey turkey;

    TurkeyAdapter(Turkey t) {
        turkey = t;
    }
    
    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for(int i = 0; i < 3 ; i++ ) {
            turkey.hover();
        }
    }

}