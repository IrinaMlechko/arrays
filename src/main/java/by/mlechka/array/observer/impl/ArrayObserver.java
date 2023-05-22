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
    
    private static final ArithmeticArrayService arithmeticArrayService = new ArithmeticArrayServiceImpl();
    static Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(ArrayEvent arrayEvent){
        logger.debug("parameterChanged called for " + arrayEvent );
        DataArray array = arrayEvent.getSource();
        try {
            Integer min = arithmeticArrayService.findMinValue(array);
            Integer max = arithmeticArrayService.findMaxValue(array);
            Integer sum = arithmeticArrayService.calculateSum(array);
            Double average = arithmeticArrayService.findAverageValue(array);
            Integer amountOfPositiveElements = arithmeticArrayService.countPositiveValues(array);
            Integer amountOfNegativeElements = arithmeticArrayService.countNegativeValues(array);
            ArrayStatistics statistics = new ArrayStatistics(min, max, sum, average, amountOfPositiveElements, amountOfNegativeElements);

            UUID id = array.getId();

            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(id, statistics);
        } catch (ArrayCustomException e) {
            logger.warn("ArrayObserver exception");
            //FIXME: what should we do by catch?
        }
    }
}
