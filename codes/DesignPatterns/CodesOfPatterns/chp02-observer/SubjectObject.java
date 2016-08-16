import java.util.*;

class SubjectObject implements SubjectInterface {
    ArrayList<ObserverInterface> observers 
            = new ArrayList<ObserverInterface>();
    int dato = 0; 
    
    public void addOne(ObserverInterface oi){
        observers.add(oi);
    }
    
    public void removeOne(ObserverInterface oi){
        observers.remove(oi);
    }

    public void notifyIt(){
        Iterator it = observers.iterator();
        ObserverInterface oib;
        while( it.hasNext() ){
            oib = (ObserverInterface) it.next();
            oib.updateIt();
        }
    }
    
    void incrementarDato() {
        dato++;
    }

    int getDato() {
        return dato;
    }

}