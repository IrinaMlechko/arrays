package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.service.ArithmeticArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ArithmeticArrayServiceImpl implements ArithmeticArrayService {

    static Logger logger = LogManager.getLogger(ArithmeticArrayServiceImpl.class);

    @Override
    public int findMinValue(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Minimal value can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        logger.info("Minimal value in array: {}", minValue);
        return minValue;
    }

    @Override
    public int findMaxValue(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Maximal value can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        logger.info("Maximum value in array: {}", maxValue);
        return maxValue;
    }

    @Override
    public void replaceValues(DataArray dataArray, int oldValue, int newValue) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. There is no data to replace. ");
        }
        int[] numbers = dataArray.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == oldValue) {
                numbers[i] = newValue;
            }
        }
        logger.info("Array after replacement: {}", dataArray);
    }

    @Override
    public double findAverageValue(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Average value can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = sum / numbers.length;
        logger.info("Average value in array: {}", average);
        return average;
    }

    @Override
    public int calculateSum(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Sum can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        logger.info("Sum of values in array: {}", sum);
        return sum;
    }

    @Override
    public int countPositiveValues(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Amount of positive values can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        int count = 0;
        for (int number : numbers) {
            if (number > 0) {
                count++;
            }
        }
        logger.info("Number of positive values in array: {}", count);
        return count;
    }

    @Override
    public int countNegativeValues(DataArray dataArray) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. Amount of negative values can not be calculated. ");
        }
        int[] numbers = dataArray.getNumbers();
        int count = 0;
        for (int number : numbers) {
            if (number < 0) {
                count++;
            }
        }
        logger.info("Number of negative values in array: {}", count);
        return count;
    }

    @Override
    public OptionalInt findMinValueStreams(DataArray dataArray) {
        logger.info("Finding minimal value in array ");
        return Arrays.stream(dataArray.getNumbers()).min();
    }

    @Override
    public OptionalInt findMaxValueStreams(DataArray dataArray) {
        logger.info("Finding maximal value in array ");
        return Arrays.stream(dataArray.getNumbers()).max();
    }

    @Override
    public void replaceValuesStreams(DataArray dataArray, int oldValue, int newValue) throws ArrayCustomException {
        if(dataArray == null){
            throw new ArrayCustomException("Array is null. There is no data to replace. ");
        }
        logger.info("Replacing all {} in the array with {}", oldValue, newValue);
        int[] numbers = dataArray.getNumbers();
        int[] newNumbers = Arrays.stream(numbers)
                .map(num -> num == oldValue ? newValue : num)
                .toArray();
        dataArray.setNumbers(newNumbers);
    }

    @Override
    public OptionalDouble findAverageValueStreams(DataArray dataArray) {
        logger.info("Finding average of all values in array ");
        return Arrays.stream(dataArray.getNumbers()).average();
    }

    @Override
    public int calculateSumStreams(DataArray dataArray) {
        logger.info("Finding minimal value in array ");
        return Arrays.stream(dataArray.getNumbers()).sum();
    }

    @Override
    public long countPositiveValuesStreams(DataArray dataArray) {
        logger.info("Finding minimal value in array ");
        return Arrays.stream(dataArray.getNumbers()).filter(num -> num > 0).count();
    }

    @Override
    public long countNegativeValuesStreams(DataArray dataArray) {
        logger.info("Finding minimal value in array ");
        return Arrays.stream(dataArray.getNumbers()).filter(num -> num < 0).count();
    }
}
