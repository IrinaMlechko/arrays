package by.mlechka.array.observer.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.ArrayStatistics;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.model.Warehouse;
import by.mlechka.array.observer.ArrayEvent;
import by.mlechka.array.observer.Observer;
import by.mlechka.array.service.ArithmeticArrayService;
import by.mlechka.array.service.impl.ArithmeticArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class ArrayObserver implements Observer {

    private static final ArithmeticArrayService ARITHMETIC_ARRAY_SERVICE = new ArithmeticArrayServiceImpl();
    static Logger logger = LogManager.getLogger();

    //TODO: catch exceptions
    @Override
    public void parameterChanged(ArrayEvent arrayEvent){
        System.out.println("parameterChanged called for " + arrayEvent );
        DataArray array = arrayEvent.getSource();
        try {
            Integer min = ARITHMETIC_ARRAY_SERVICE.findMinValue(array);
            Integer max = ARITHMETIC_ARRAY_SERVICE.findMaxValue(array);
            Integer sum = ARITHMETIC_ARRAY_SERVICE.calculateSum(array);
            Double average = ARITHMETIC_ARRAY_SERVICE.findAverageValue(array);
            Integer amountOfPositiveElements = ARITHMETIC_ARRAY_SERVICE.countPositiveValues(array);
            Integer amountOfNegativeElements = ARITHMETIC_ARRAY_SERVICE.countNegativeValues(array);
            ArrayStatistics statistics = new ArrayStatistics(min, max, sum, average, amountOfPositiveElements, amountOfNegativeElements);

            UUID id = array.getId();

            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(id, statistics);
        } catch (ArrayCustomException e) {
            logger.warn("ArrayObserver exception");
        }
    }
}
