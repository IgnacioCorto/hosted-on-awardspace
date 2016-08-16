class BirdsFacade {
    
    Duck duck;
    Turkey turkey;

    BirdsFacade(Duck d, Turkey t) {
        duck = d;
        turkey = t;
    }
    
    public void birdsFest() {

        for(int i = 0; i < 3 ; i++ ) {
            duck.quack();
            turkey.gobble();
        }

        for(int i = 0; i < 3 ; i++ ) {
            duck.fly();
            turkey.hover();
        }
            
    }

}