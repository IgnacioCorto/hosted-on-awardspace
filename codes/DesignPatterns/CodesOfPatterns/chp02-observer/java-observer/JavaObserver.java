import java.util.Observable;
import java.util.Observer;

class JavaObserver implements Observer {
    Observable observable;
    int miDato = 10;

    JavaObserver(Observable obj) {
        this.observable = obj;
        observable.addObserver(this);
    }
    
    public void update(Observable obs, Object arg) {
        if(obs instanceof JavaObservable) {
            JavaObservable jo = (JavaObservable) obs;
            miDato+=jo.getDato();
        }
    }
}