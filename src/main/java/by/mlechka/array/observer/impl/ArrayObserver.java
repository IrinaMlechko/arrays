package by.mlechka.array.observer.impl;

import by.mlechka.array.observer.ArrayEvent;
import by.mlechka.array.observer.Observer;
import by.mlechka.array.model.ArrayStatistics;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.model.Warehouse;
import by.mlechka.array.service.DataArrayService;
import by.mlechka.array.service.impl.DataArrayServiceImpl;

import java.util.UUID;

public class ArrayObserver implements Observer {

    private static final DataArrayService DATA_ARRAY_SERVICE = new DataArrayServiceImpl();

    @Override
    public void parameterChanged (ArrayEvent arrayEvent){
        DataArray array = arrayEvent.getSource();

        Integer min = DATA_ARRAY_SERVICE.findMinValue(array);
        Integer max = DATA_ARRAY_SERVICE.findMaxValue(array);
        Integer sum = DATA_ARRAY_SERVICE.calculateSum(array);
        Double average = DATA_ARRAY_SERVICE.findAverageValue(array);
        Integer amountOfPositiveElements = DATA_ARRAY_SERVICE.countPositiveValues(array);
        Integer amountOfNegativeElements = DATA_ARRAY_SERVICE.countNegativeValues(array);
        ArrayStatistics statistics = new ArrayStatistics(min, max, sum, average, amountOfPositiveElements, amountOfNegativeElements);

        UUID id = array.getId();

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, statistics);
    }
}
