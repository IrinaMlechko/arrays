package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class DataArrayServiceImplTest {

    private DataArrayServiceImpl numbersArrayService;

    @BeforeEach
    void setUp() {
        numbersArrayService = new DataArrayServiceImpl();
    }

    @Test
    void testFindMinValue() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, -4, 5, 6});
        int actualResult = numbersArrayService.findMinValue(dataArray);
        Assertions.assertEquals(-4, actualResult);
    }

    @Test
    void testFindMaxValue() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, -4, 5, 6});
        int actualResult = numbersArrayService.findMaxValue(dataArray);
        Assertions.assertEquals(6, actualResult);
    }

    @Test
    void testReplaceValuesIf() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        int oldValue = 4;
        int newValue = 0;
        numbersArrayService.replaceValues(dataArray, oldValue, newValue);
        int[] expectedArray = new int[]{1, 2, 3, 0, 5, 6};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

    @Test
    void testFindAverageValue() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        double actualResult = numbersArrayService.findAverageValue(dataArray);
        Assertions.assertEquals(3.5, actualResult);
    }

    @Test
    void testCalculateSum() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        int actualResult = numbersArrayService.calculateSum(dataArray);
        Assertions.assertEquals(21, actualResult);
    }

    @Test
    void testCountPositiveValues() {
        DataArray dataArray = new DataArray(new int[]{-1, 2, -3, 4, -5, 6});
        int actualResult = numbersArrayService.countPositiveValues(dataArray);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    void testCountNegativeValues() {
        DataArray dataArray = new DataArray(new int[]{-1, 2, -3, 4, -5, 6});
        int actualResult = numbersArrayService.countNegativeValues(dataArray);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    void testBubbleSort() {
        DataArray dataArray = new DataArray(new int[]{5, 2, 8, 1, 4});
        numbersArrayService.bubbleSort(dataArray);
        int[] expectedArray = new int[]{1, 2, 4, 5, 8};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

    @Test
    void testInsertionSort() {
        DataArray dataArray = new DataArray(new int[]{5, 2, 6, 1, 3, 4});
        numbersArrayService.insertionSort(dataArray);
        int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

    @Test
    void testSelectionSort() {
        DataArray dataArray = new DataArray(new int[]{5, 2, 8, 1, 4});
        numbersArrayService.selectionSort(dataArray);
        int[] expectedArray = new int[]{1, 2, 4, 5, 8};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

        @Test
        public void testCreateArrayFromFile() throws ArrayCustomException, FileNotFoundException {
            DataArrayServiceImpl service = new DataArrayServiceImpl();
            DataArray array = service.createArrayFromFile("src/main/resources/data.txt");
            Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array.getNumbers());
        }

        @Test
        public void testCreateArrayFromFileWithInvalidData() throws FileNotFoundException {
            DataArrayServiceImpl service = new DataArrayServiceImpl();
            Assertions.assertThrows(ArrayCustomException.class, () -> service.createArrayFromFile("src/main/resources/invalid_data.txt"));
        }

    @Test
    void testFindMinValueStreams() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, -4, 5, 6});
        int actualResult = numbersArrayService.findMinValueStreams(dataArray);
        Assertions.assertEquals(-4, actualResult);
    }

    @Test
    void testFindMaxValueStreams() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, -4, 5, 6});
        int actualResult = numbersArrayService.findMaxValueStreams(dataArray);
        Assertions.assertEquals(6, actualResult);
    }

    @Test
    void testReplaceValuesStreams() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        int oldValue = 4;
        int newValue = 0;
        numbersArrayService.replaceValuesStreams(dataArray, oldValue, newValue);
        int[] expectedArray = new int[]{1, 2, 3, 0, 5, 6};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

    @Test
    void testFindAverageValueStreams() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        double actualResult = numbersArrayService.findAverageValueStreams(dataArray);
        Assertions.assertEquals(3.5, actualResult);
    }

    @Test
    void testCalculateSumStreams() {
        DataArray dataArray = new DataArray(new int[]{1, 2, 3, 4, 5, 6});
        int actualResult = numbersArrayService.calculateSumStreams(dataArray);
        Assertions.assertEquals(21, actualResult);
    }

    @Test
    void testCountPositiveValuesStreams() {
        DataArray dataArray = new DataArray(new int[]{-1, 2, -3, 4, -5, 6});
        int actualResult = numbersArrayService.countPositiveValuesStreams(dataArray);
        Assertions.assertEquals(3, actualResult);
    }

    @Test
    void testCountNegativeValuesStreams() {
        DataArray dataArray = new DataArray(new int[]{-1, 2, -3, 4, -5, 6});
        int actualResult = numbersArrayService.countNegativeValuesStreams(dataArray);
        Assertions.assertEquals(3, actualResult);
    }
}

