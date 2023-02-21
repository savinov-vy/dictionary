package ru.savinov.dictionary.backend.patterns.observer.observers;

import ru.savinov.dictionary.backend.patterns.observer.StateSubjectDto;

public interface Observer {
    void update(StateSubjectDto stateSubject);
}
