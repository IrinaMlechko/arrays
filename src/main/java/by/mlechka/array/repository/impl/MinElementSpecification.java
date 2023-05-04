package by.mlechka.array.repository.impl;

import by.mlechka.array.repository.Specification;
import by.mlechka.array.model.DataArray;

import java.util.Arrays;

public class MinElementSpecification implements Specification {

    private int minElement;

    public MinElementSpecification(int minElement) {
        this.minElement = minElement;
    }

    @Override
    public boolean specify(DataArray dataArray) {
        int minInArray = Arrays.stream(dataArray.getNumbers()).min().orElseThrow();
        boolean result = false;
        if (minInArray >= minElement){
            result = true;
        }
        return result;
    }
}
