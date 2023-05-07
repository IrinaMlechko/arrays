package by.mlechka.array.reader;

import by.mlechka.array.exception.ArrayCustomException;

import java.util.List;

public interface ArrayReader {
    /**
     * Read array int [ ] from file.
     *
     * @param filename the filename
     * @return the list
     * @throws ArrayCustomException the array custom exception
     */
    List<int[]> readArray(String filename) throws ArrayCustomException;
}
