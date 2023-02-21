package ru.savinov.dictionary.backend.patterns.observer.observers;

import ru.savinov.dictionary.backend.patterns.observer.StateSubjectDto;
import ru.savinov.dictionary.backend.patterns.observer.subjects.Subject;

public class ObserverImpl implements Observer, Display {
    Subject subject;
    StateSubjectDto stateSubject;

    public ObserverImpl(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(stateSubject);
    }

    @Override
    public void update(StateSubjectDto stateSubject) {
        this.stateSubject = stateSubject;
        display();
    }
}
