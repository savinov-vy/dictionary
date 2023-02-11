package ru.savinov.dictionary.backend.patterns.observer.custom.subjects;

import ru.savinov.dictionary.backend.patterns.observer.custom.StateSubjectDto;
import ru.savinov.dictionary.backend.patterns.observer.custom.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
    List<Observer> observers;
    StateSubjectDto stateSubject;

    public SubjectImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStateSubject(StateSubjectDto stateSubject) {
        this.stateSubject = stateSubject;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        if (observers.isEmpty()) {
            System.out.println("observers is not exists");
        } else {
            observers.forEach(o -> o.update(stateSubject));
        }
    }
}
