package Observer;

import java.util.Observable;

import model.persistence.ApplicationState;

public class StateObservable extends Observable {

    public StateObservable() { }

    public void uiStateChange (Object obj) {
        System.out.println("In the uiStateChange \n");
        setChanged();
        notifyObservers(obj);

    }


}



