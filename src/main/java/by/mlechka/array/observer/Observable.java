package by.mlechka.array.observer;

public interface Observable {
    void attach(Observer observer);
    void detach (Observer observer);
    void notifyObserver();
}
