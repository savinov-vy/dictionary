package ru.savinov.dictionary.backend.patterns.observer;

import ru.savinov.dictionary.backend.patterns.observer.observers.Observer;
import ru.savinov.dictionary.backend.patterns.observer.observers.ObserverImpl;
import ru.savinov.dictionary.backend.patterns.observer.subjects.SubjectImpl;

public class MainObserver {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        StateSubjectDto dto = new StateSubjectDto(4, "four number");
        Observer observer = new ObserverImpl(subject);
        subject.setStateSubject(dto);
    }
}
