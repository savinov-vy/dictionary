package ru.savinov.dictionary.backend.patterns.observer.custom.subjects;

import ru.savinov.dictionary.backend.patterns.observer.custom.observers.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
