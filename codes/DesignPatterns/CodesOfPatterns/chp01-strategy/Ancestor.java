class Ancestor {
 
    Interface OneBehavior;

    void performIt() {
        OneBehavior.perform();
    }

    void setIt(Interface a){
        OneBehavior = a;
    }

}