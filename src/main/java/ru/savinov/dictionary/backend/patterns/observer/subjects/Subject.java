package ru.savinov.dictionary.backend.patterns.observer.subjects;

import ru.savinov.dictionary.backend.patterns.observer.observers.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
