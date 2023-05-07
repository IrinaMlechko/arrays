package by.mlechka.array.observer;

import by.mlechka.array.exception.ArrayCustomException;

public interface Observer {
    void parameterChanged (ArrayEvent arrayEvent) throws ArrayCustomException;
}
