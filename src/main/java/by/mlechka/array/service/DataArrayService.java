package by.mlechka.array.service;

import by.mlechka.array.exception.ArrayCutomException;
import by.mlechka.array.model.DataArray;

import java.io.FileNotFoundException;

/**
 * A service interface for performing operations on an array of numbers.
 */
public interface DataArrayService {

    /**
     * Finds the minimum value in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the minimum value in the array
     */
    int findMinValue(DataArray numbers);

    /**
     * Finds the maximum value in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the maximum value in the array
     */
    int findMaxValue(DataArray numbers);

    /**
     * Replaces some elements in the given array with the specified value.
     *
     * @param numbers    the array of numbers to update
     * @param oldValue  the value to be replaced
     * @param newValue the value with which to replace the matching elements
     */
    void replaceValues(DataArray numbers, int oldValue, int newValue);

    /**
     * Calculates the average value of the elements in the given array.
     *
     * @param numbers the array of numbers to calculate the average of
     * @return the average value of the elements in the array
     */
    double findAverageValue(DataArray numbers);

    /**
     * Calculates the sum of the elements in the given array.
     *
     * @param numbers the array of numbers to sum
     * @return the sum of the elements in the array
     */
    int calculateSum(DataArray numbers);

    /**
     * Calculates the number of positive elements in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the number of positive elements in the array
     */
    int countPositiveValues(DataArray numbers);

    /**
     * Calculates the number of negative elements in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the number of negative elements in the array
     */
    int countNegativeValues(DataArray numbers);

    /**
     * Sorts the given array of numbers using the bubble sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */
    void bubbleSort(DataArray dataArray);
    /**
     * Sorts the given array of numbers using the selection sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */
    void selectionSort(DataArray dataArray);
    /**
     * Sorts the given array of numbers using the insertion sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */

    void insertionSort(DataArray dataArray);

    DataArray createArrayFromFile(String fileName) throws ArrayCutomException, FileNotFoundException;

    int[] readNumbersFromFile(String fileName) throws FileNotFoundException, ArrayCutomException;

    /**
     * Finds the minimum value in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the minimum value in the array
     */
    int findMinValueStreams(DataArray dataArray);
    /**
     * Finds the maximum value in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the maximum value in the array
     */
    int findMaxValueStreams(DataArray dataArray);
    /**
     * Replaces all elements with old value in the given array  with the specified value using streams.
     *
     * @param dataArray    the array of numbers to update
     * @param oldValue  the value to be replaced
     * @param newValue the value with which to replace the matching elements
     */
    void replaceValuesStreams(DataArray dataArray, int oldValue, int newValue);
    /**
     * Calculates the average value of the elements in the given array using streams.
     *
     * @param dataArray the array of numbers to calculate the average of
     * @return the average value of the elements in the array
     */
    double findAverageValueStreams(DataArray dataArray);
    /**
     * Calculates the sum of the elements in the given array.
     *
     * @param dataArray the array of numbers to sum
     * @return the sum of the elements in the array
     */
    int calculateSumStreams(DataArray dataArray);
    /**
     * Calculates the number of positive elements in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the number of positive elements in the array
     */
    int countPositiveValuesStreams(DataArray dataArray);
    /**
     * Calculates the number of negative elements in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the number of negative elements in the array
     */
    int countNegativeValuesStreams(DataArray dataArray);

    void sortArrayStreams(DataArray dataArray);

    DataArray createArrayFromFileStreams(String fileName) throws ArrayCutomException, FileNotFoundException;

    String readLineFromFileStreams(String fileName) throws FileNotFoundException;
}