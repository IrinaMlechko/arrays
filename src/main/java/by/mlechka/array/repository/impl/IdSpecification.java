package by.mlechka.array.repository.impl;

import by.mlechka.array.repository.Specification;
import by.mlechka.array.model.DataArray;

import java.util.UUID;

public class IdSpecification implements Specification {

    private UUID id;

    public IdSpecification(UUID id) {
        this.id = id;
    }

    @Override
    public boolean specify(DataArray dataArray) {
        boolean result = dataArray.getId().equals(id);
        return result;
    }
}

