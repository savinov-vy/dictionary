package ru.savinov.dictionary.backend.concurrent.Atomic;

public interface IOnceDoer {

    void doOnce(Runnable action);
}
