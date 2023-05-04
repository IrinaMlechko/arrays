package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCutomException;
import by.mlechka.array.service.DataArrayService;
import by.mlechka.array.model.DataArray;

import by.mlechka.array.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class DataArrayServiceImpl implements DataArrayService {

    static Logger logger = LogManager.getLogger(DataArrayServiceImpl.class);

    @Override
    public int findMinValue(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        logger.info("Minimum value in array: {}", minValue);
        return minValue;
    }

    @Override
    public int findMaxValue(DataArray dataArray) {
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
    public void replaceValues(DataArray dataArray, int oldValue, int newValue) {
        int[] numbers = dataArray.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == oldValue) {
                numbers[i] = newValue;
            }
        }
        logger.info("Array after replacement: {}", dataArray);
    }

    @Override
    public double findAverageValue(DataArray dataArray) {
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
    public int calculateSum(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        logger.info("Sum of values in array: {}", sum);
        return sum;
    }

    @Override
    public int countPositiveValues(DataArray dataArray) {
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
    public int countNegativeValues(DataArray dataArray) {
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
    public void bubbleSort(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
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
    public void selectionSort(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
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
    public void insertionSort(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
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
    public DataArray createArrayFromFile(String fileName) throws ArrayCutomException, FileNotFoundException {
        FileValidator.validateFile(fileName);
        int[] numbers = readNumbersFromFile(fileName);
        return new DataArray(numbers);
    }
    @Override
    public int[] readNumbersFromFile(String fileName) throws FileNotFoundException, ArrayCutomException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = scanner.nextLine();
        String[] numberStrings = line.split(" ");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            } catch (NumberFormatException e) {
                throw new ArrayCutomException("Invalid number format: " + numberStrings[i]);
            }
        }
        scanner.close();
        return numbers;
    }

    @Override
    public int findMinValueStreams(DataArray dataArray) {
        return Arrays.stream(dataArray.getNumbers()).min().orElseThrow();
    }

    @Override
    public int findMaxValueStreams(DataArray dataArray) {
        return Arrays.stream(dataArray.getNumbers()).max().orElseThrow();
    }

    @Override
    public void replaceValuesStreams(DataArray dataArray, int oldValue, int newValue) {
        int[] numbers = dataArray.getNumbers();
        int[] newNumbers = Arrays.stream(numbers)
                .map(num -> num == oldValue ? newValue : num)
                .toArray();
        dataArray.setNumbers(newNumbers);
    }

    @Override
    public double findAverageValueStreams(DataArray dataArray) {
        return Arrays.stream(dataArray.getNumbers()).average().orElseThrow();
    }

    @Override
    public int calculateSumStreams(DataArray dataArray) {
        return Arrays.stream(dataArray.getNumbers()).sum();
    }

    @Override
    public int countPositiveValuesStreams(DataArray dataArray) {
        return (int) Arrays.stream(dataArray.getNumbers()).filter(num -> num > 0).count();
    }

    @Override
    public int countNegativeValuesStreams(DataArray dataArray) {
        return (int) Arrays.stream(dataArray.getNumbers()).filter(num -> num < 0).count();
    }
    @Override
    public void sortArrayStreams(DataArray dataArray) {
        int[] numbers = dataArray.getNumbers();
        Arrays.stream(numbers)
                .sorted();
    }
    @Override
    public DataArray createArrayFromFileStreams(String fileName) throws ArrayCutomException, FileNotFoundException {
        FileValidator fileValidator = new FileValidator();
        fileValidator.validateFileStreams(fileName);
        int[] numbers = Arrays.stream(readLineFromFileStreams(fileName).split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new DataArray(numbers);
    }
    @Override
    public String readLineFromFileStreams(String fileName) throws FileNotFoundException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.findFirst().orElseThrow(FileNotFoundException::new);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    private void validateNumbersStreams(int[] numbers) throws ArrayCutomException {
        boolean invalidNumberExists = Arrays.stream(numbers).anyMatch(number -> number < 1 || number > 10);
        if (invalidNumberExists) {
            throw new ArrayCutomException("Invalid number found");
        }
    }
}
