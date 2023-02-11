package ru.savinov.dictionary.backend.patterns.observer.custom;

import ru.savinov.dictionary.backend.patterns.observer.custom.observers.Observer;
import ru.savinov.dictionary.backend.patterns.observer.custom.observers.ObserverImpl;
import ru.savinov.dictionary.backend.patterns.observer.custom.subjects.SubjectImpl;

public class Main {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();
        StateSubjectDto dto = new StateSubjectDto(4, "four number");
        Observer observer = new ObserverImpl(subject);
        subject.setStateSubject(dto);

    }
}
