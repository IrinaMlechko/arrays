package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithmeticArrayServiceImplTest {

    private ArithmeticArrayServiceImpl arithmeticArrayService;
    private DataArray dataArray;

    @BeforeEach
    void setUp() {
        arithmeticArrayService = new ArithmeticArrayServiceImpl();
        dataArray = new DataArray(new int[]{9, 3, 0, 9, -1, 1, 7});
    }

    @Test
    void findMinValue_ValidDataArray_ReturnsMinValue() throws ArrayCustomException {
        int minValue = arithmeticArrayService.findMinValue(dataArray);
        Assertions.assertEquals(-1, minValue);
    }

    @Test
    void findMaxValue_ValidDataArray_ReturnsMaxValue() throws ArrayCustomException {
        int maxValue = arithmeticArrayService.findMaxValue(dataArray);
        Assertions.assertEquals(9, maxValue);
    }

    @Test
    void replaceValues_ValidDataArray_ReplacesOldValueWithNewValue() throws ArrayCustomException {
        arithmeticArrayService.replaceValues(dataArray, 3, 10);
        int[] expectedArray = {9, 10, 0, 9, -1, 1, 7};
        Assertions.assertArrayEquals(expectedArray, dataArray.getNumbers());
    }

    @Test
    void findAverageValue_ValidDataArray_ReturnsAverageValue() throws ArrayCustomException {
        double averageValue = arithmeticArrayService.findAverageValue(dataArray);
        Assertions.assertEquals(4.0, averageValue);
    }

    @Test
    void calculateSum_ValidDataArray_ReturnsSum() throws ArrayCustomException {
        int sum = arithmeticArrayService.calculateSum(dataArray);
        Assertions.assertEquals(28, sum);
    }

    @Test
    void countPositiveValues_ValidDataArray_ReturnsCount() throws ArrayCustomException {
        int count = arithmeticArrayService.countPositiveValues(dataArray);
        Assertions.assertEquals(5, count);
    }

    @Test
    void countNegativeValues_ValidDataArray_ReturnsCount() throws ArrayCustomException {
        int count = arithmeticArrayService.countNegativeValues(dataArray);
        Assertions.assertEquals(1, count);
    }
}
