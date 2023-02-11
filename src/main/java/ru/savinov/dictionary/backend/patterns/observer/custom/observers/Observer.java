package ru.savinov.dictionary.backend.patterns.observer.custom.observers;

import ru.savinov.dictionary.backend.patterns.observer.custom.StateSubjectDto;

public interface Observer {
    void update(StateSubjectDto stateSubject);
}
