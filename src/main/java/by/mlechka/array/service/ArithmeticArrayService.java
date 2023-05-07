package by.mlechka.array.service;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * The interface Arithmetic array service.
 */
public interface ArithmeticArrayService {
    /**
     * Finds the minimum value in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the minimum value in the array
     */
    int findMinValue(DataArray numbers) throws ArrayCustomException;

    /**
     * Finds the maximum value in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the maximum value in the array
     */
    int findMaxValue(DataArray numbers) throws ArrayCustomException;

    /**
     * Replaces some elements in the given array with the specified value.
     *
     * @param numbers    the array of numbers to update
     * @param oldValue  the value to be replaced
     * @param newValue the value with which to replace the matching elements
     */
    void replaceValues(DataArray numbers, int oldValue, int newValue) throws ArrayCustomException;

    /**
     * Calculates the average value of the elements in the given array.
     *
     * @param numbers the array of numbers to calculate the average of
     * @return the average value of the elements in the array
     */
    double findAverageValue(DataArray numbers) throws ArrayCustomException;

    /**
     * Calculates the sum of the elements in the given array.
     *
     * @param numbers the array of numbers to sum
     * @return the sum of the elements in the array
     */
    int calculateSum(DataArray numbers) throws ArrayCustomException;

    /**
     * Calculates the number of positive elements in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the number of positive elements in the array
     */
    int countPositiveValues(DataArray numbers) throws ArrayCustomException;

    /**
     * Calculates the number of negative elements in the given array.
     *
     * @param numbers the array of numbers to search
     * @return the number of negative elements in the array
     */
    int countNegativeValues(DataArray numbers) throws ArrayCustomException;

    /**
     * Finds the minimum value in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the minimum value in the array
     */
    OptionalInt findMinValueStreams(DataArray dataArray);
    /**
     * Finds the maximum value in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the maximum value in the array
     */
    OptionalInt findMaxValueStreams(DataArray dataArray);
    /**
     * Replaces all elements with old value in the given array  with the specified value using streams.
     *
     * @param dataArray    the array of numbers to update
     * @param oldValue  the value to be replaced
     * @param newValue the value with which to replace the matching elements
     */
    void replaceValuesStreams(DataArray dataArray, int oldValue, int newValue) throws ArrayCustomException;
    /**
     * Calculates the average value of the elements in the given array using streams.
     *
     * @param dataArray the array of numbers to calculate the average of
     * @return the average value of the elements in the array
     */
    OptionalDouble findAverageValueStreams(DataArray dataArray);
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
    long countPositiveValuesStreams(DataArray dataArray);
    /**
     * Calculates the number of negative elements in the given array using streams.
     *
     * @param dataArray the array of numbers to search
     * @return the number of negative elements in the array
     */
    long countNegativeValuesStreams(DataArray dataArray);
}
