package by.mlechka.array.reader.impl;

import by.mlechka.array.exception.ArrayCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


//TODO: add some tests
class ArrayReaderImplTest {

    private ArrayReaderImpl arrayReader;

    @BeforeEach
    void setUp() {
        arrayReader = new ArrayReaderImpl();
    }

    @Test
    void readArray_ValidFile_ReturnsListOfArrays() throws ArrayCustomException {
        String filename = "valid_file.txt";
        List<int[]> result = arrayReader.readArray(filename);
        // Perform assertions on the result
        // ...
    }

    @Test
    void readArray_NonexistentFile_ThrowsArrayCustomException() {
        String filename = "nonexistent_file.txt";
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            arrayReader.readArray(filename);
        });
    }

    @Test
    void readArray_InvalidFileFormat_ThrowsArrayCustomException() {
        String filename = "invalid_file_format.txt";
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            arrayReader.readArray(filename);
        });
    }
}

