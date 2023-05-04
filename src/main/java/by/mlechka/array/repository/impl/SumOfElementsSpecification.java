package by.mlechka.array.repository.impl;

import by.mlechka.array.repository.Specification;
import by.mlechka.array.model.DataArray;

import java.util.Arrays;

public class SumOfElementsSpecification implements Specification {

    private int sum;

    public SumOfElementsSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(DataArray dataArray) {
        boolean result = Arrays.stream(dataArray.getNumbers()).sum() == sum;
        return result;
    }
}
