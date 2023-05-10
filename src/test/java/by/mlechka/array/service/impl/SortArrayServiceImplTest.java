package by.mlechka.array.service.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortArrayServiceImplTest {

    private SortArrayServiceImpl sortArrayService;
    int[] numbers;
    int[] expectedSortedNumbers;
    DataArray nullDataArray;
    DataArray dataArrayWithNullNumbers;
    DataArray dataArray;

    @BeforeEach
    void setUp() {
        sortArrayService = new SortArrayServiceImpl();
        numbers = new int[]{5, 3, 1, 4, 2};
        expectedSortedNumbers = new int[]{1, 2, 3, 4, 5};
        nullDataArray = null;
        dataArrayWithNullNumbers = new DataArray(null);
        dataArray = new DataArray(numbers);
    }

    @Test
    void bubbleSort_ValidDataArray_SortsArrayInAscendingOrder() throws ArrayCustomException {
        sortArrayService.bubbleSort(dataArray);
        int[] sortedNumbers = dataArray.getNumbers();
        Assertions.assertArrayEquals(expectedSortedNumbers, sortedNumbers);
    }

    @Test
    void bubbleSort_NullDataArray_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.bubbleSort(nullDataArray);    });
    }

    @Test
    void bubbleSort_DataArrayWithNullNumbers_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.bubbleSort(dataArrayWithNullNumbers);    });
    }

    @Test
    void selectionSort_ValidDataArray_SortsArrayInAscendingOrder() throws ArrayCustomException {
        sortArrayService.selectionSort(dataArray);
        int[] sortedNumbers = dataArray.getNumbers();
        Assertions.assertArrayEquals(expectedSortedNumbers, sortedNumbers);
    }

    @Test
    void selectionSort_NullDataArray_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.selectionSort(nullDataArray);    });
    }

    @Test
    void selectionSort_DataArrayWithNullNumbers_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.selectionSort(dataArrayWithNullNumbers);    });
    }

    @Test
    void insertionSort_ValidDataArray_SortsArrayInAscendingOrder() throws ArrayCustomException {
        sortArrayService.insertionSort(dataArray);
        int[] sortedNumbers = dataArray.getNumbers();
        Assertions.assertArrayEquals(expectedSortedNumbers, sortedNumbers);
    }

    @Test
    void insertionSort_NullDataArray_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.insertionSort(nullDataArray);    });
    }

    @Test
    void insertionSort_DataArrayWithNullNumbers_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.insertionSort(dataArrayWithNullNumbers);    });
    }

    @Test
    void sortArrayStreams_ValidDataArray_SortsArrayInAscendingOrder() throws ArrayCustomException {
        sortArrayService.sortArrayStreams(dataArray);
        int[] sortedNumbers = dataArray.getNumbers();
        Assertions.assertArrayEquals(expectedSortedNumbers, sortedNumbers);
    }

    @Test
    void sortArrayStreams_NullDataArray_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.sortArrayStreams(nullDataArray);    });
    }

    @Test
    void sortArrayStreams_DataArrayWithNullNumbers_ThrowsException() throws ArrayCustomException {
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            sortArrayService.sortArrayStreams(dataArrayWithNullNumbers);    });
    }
}
