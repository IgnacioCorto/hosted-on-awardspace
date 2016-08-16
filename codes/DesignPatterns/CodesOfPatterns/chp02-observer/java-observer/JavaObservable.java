import java.util.Observable;
import java.util.Observer;
import java.util.*;

class JavaObservable extends Observable {
    int dato = 0; 
    
    void notifyIt() {
        setChanged();
        notifyObservers();
    }
    
    void incrementarDato() {
        dato++;
    }

    int getDato() {
        return dato;
    }

}