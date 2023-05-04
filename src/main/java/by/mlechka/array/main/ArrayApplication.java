package by.mlechka.array.main;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.model.Warehouse;
import by.mlechka.array.observer.impl.ArrayObserver;
import by.mlechka.array.repository.Repository;
import by.mlechka.array.service.DataArrayService;
import by.mlechka.array.service.impl.DataArrayServiceImpl;
import by.mlechka.array.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class ArrayApplication {

    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
//        String fileName = "src/main/resources/array/data.txt";
//        FileValidator validator = new FileValidator();
//        try {
//            validator.validateFileStreams(fileName);
//        } catch (ArrayCustomException e) {
//            logger.info("Invalid data in file: " + e.getMessage());
//            return;
//        }
//
//        try {
//            DataArrayService service = new DataArrayServiceImpl();
//            int[] numbers = service.createArrayFromFileStreams(fileName).getNumbers();
//            DataArray dataArray = new DataArray(numbers);
//            logger.info("Original array: " + dataArray);
//
//            int minValue = service.findMinValue(dataArray);
//            logger.info("Minimum value in array: " + minValue);
//
//            int maxValue = service.findMaxValue(dataArray);
//            logger.info("Maximum value in array: " + maxValue);
//
//            service.replaceValues(dataArray, minValue, maxValue);
//            logger.info("Array after replacement: " + dataArray);
//
//            double averageValue = service.findAverageValue(dataArray);
//            logger.info("Average value in array: " + averageValue);
//
//            int sum = service.calculateSum(dataArray);
//            logger.info("Sum of values in array: " + sum);
//
//        } catch (FileNotFoundException e) {
//            logger.warn("File not found: " + fileName);
//        } catch (ArrayCustomException e) {
//            logger.warn("Invalid data in file: " + e.getMessage());
//        }

        DataArray firstArray = new DataArray();
        DataArray secondArray = new DataArray(new int[]{0, -10, 5, -100, 80, 4, 5, 98});
        Repository arrayRepository = new Repository();
        arrayRepository.add(firstArray);
        arrayRepository.add(secondArray);

        ArrayObserver observer = new ArrayObserver();

        //TODO: how to create observer? how to attach it?
        //TODO: when implemented, add tests
        for (DataArray array : arrayRepository.getDataArrays()) {
            array.attach(observer);
        }
        Warehouse warehouse = new Warehouse();
        firstArray.setNumbers(new int[]{1, 5, 9, -1, 8, 0});
        logger.info("Warehouse: " + warehouse);
    }
}
