package by.mlechka.array.service;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;

import java.io.FileNotFoundException;

/**
 * A service interface for performing operations on an array of numbers.
 */
public interface DataArrayService {


    DataArray createArrayFromFile(String fileName) throws ArrayCustomException, FileNotFoundException;

    int[] readNumbersFromFile(String fileName) throws ArrayCustomException, FileNotFoundException;

    DataArray createArrayFromFileStreams(String fileName) throws ArrayCustomException, FileNotFoundException;

    String readLineFromFileStreams(String fileName) throws FileNotFoundException, ArrayCustomException;
}