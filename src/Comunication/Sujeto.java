package Comunication;

import java.util.ArrayList;

public interface Sujeto {

    ArrayList<Observador> observadores = new ArrayList<>();

    void registerObserver(Observador newObservador);
    void removeObserver(Observador deleteObservador);
    void notifyObservers();
}
