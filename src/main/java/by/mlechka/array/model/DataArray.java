package by.mlechka.array.model;

import by.mlechka.array.observer.ArrayEvent;
import by.mlechka.array.observer.Observable;
import by.mlechka.array.observer.Observer;
import by.mlechka.array.observer.impl.ArrayObserver;

import java.util.Arrays;
import java.util.UUID;

public class DataArray implements Observable {

    private UUID id;
    private int[] numbers;
    private Observer observer;

    public DataArray() {
        this.id = UUID.randomUUID();
        this.numbers = new int[]{};
        observer = new ArrayObserver();
    }

    public DataArray(int[] numbers) {
        this.id = UUID.randomUUID();
        setNumbers(numbers);
        //TODO: why? how to do it right?
        observer = new ArrayObserver();
    }

    public DataArray(UUID id, int[] numbers) {
        this.id = id;
        this.numbers = numbers;
        observer = new ArrayObserver();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        notifyObserver();
    }

    @Override
    public String toString() {
        return "DataArray{" +
                "id=" + id +
                ", numbers=" + Arrays.toString(numbers) +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataArray dataArray = (DataArray) o;
        return Arrays.equals(numbers, dataArray.numbers) && id.equals(dataArray.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Arrays.hashCode(numbers);
        return result;
    }

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        if (this.observer == observer) {
            this.observer = new ArrayObserver();

        }

    }

    @Override
    public void notifyObserver() {
        ArrayEvent event = new ArrayEvent(this);
        if(observer != null){
            observer.parameterChanged(event);}
    }
}
