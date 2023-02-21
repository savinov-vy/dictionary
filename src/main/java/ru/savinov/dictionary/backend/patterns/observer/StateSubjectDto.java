package ru.savinov.dictionary.backend.patterns.observer;

public class StateSubjectDto {
    private final Integer countSomething;
    private final String stateName;

    public StateSubjectDto(Integer countSomething, String stateName) {
        this.countSomething = countSomething;
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "StateSubject{" +
                "countSomething=" + countSomething +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
