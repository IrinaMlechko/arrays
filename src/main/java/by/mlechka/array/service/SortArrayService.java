package by.mlechka.array.service;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;

/**
 * The interface Sort array service.
 */
public interface SortArrayService {

    /**
     * Sorts the given array of numbers using the bubble sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */
    void bubbleSort(DataArray dataArray) throws ArrayCustomException;

    /**
     * Sorts the given array of numbers using the selection sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */
    void selectionSort(DataArray dataArray) throws ArrayCustomException;

    /**
     * Sorts the given array of numbers using the insertion sort algorithm.
     *
     * @param dataArray the array of numbers to be sorted
     */
    void insertionSort(DataArray dataArray) throws ArrayCustomException;

    /**
     * Sort array with streams.
     *
     * @param dataArray the data array
     */
    void sortArrayStreams(DataArray dataArray) throws ArrayCustomException;
}
