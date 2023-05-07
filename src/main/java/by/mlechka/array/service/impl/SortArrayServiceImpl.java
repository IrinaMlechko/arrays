package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.service.SortArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortArrayServiceImpl implements SortArrayService {

    static Logger logger = LogManager.getLogger(SortArrayServiceImpl.class);

    @Override
    public void bubbleSort(DataArray dataArray) throws ArrayCustomException {
        if (dataArray == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int[] numbers = dataArray.getNumbers();

        if (numbers == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        logger.info("Array after bubble sort: {}", dataArray);
    }

    @Override
    public void selectionSort(DataArray dataArray) throws ArrayCustomException {
        if (dataArray == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int[] numbers = dataArray.getNumbers();
        if (numbers == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
        logger.info("Array after selection sort: {}", dataArray);
    }

    @Override
    public void insertionSort(DataArray dataArray) throws ArrayCustomException {
        if (dataArray == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int[] numbers = dataArray.getNumbers();
        if (numbers == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
        logger.info("Array after insertion sort: {}", dataArray);
    }

    @Override
    public void sortArrayStreams(DataArray dataArray) throws ArrayCustomException {
        if (dataArray == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        int[] numbers = dataArray.getNumbers();
        if (numbers == null) {
            throw new ArrayCustomException("Array is null. Array can not be sorted. ");
        }
        Arrays.stream(numbers)
                .sorted();
    }
}
