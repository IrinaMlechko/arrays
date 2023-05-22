package by.mlechka.array.reader.impl;

import by.mlechka.array.exception.ArrayCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


//TODO: add some tests
class ArrayReaderImplTest {

    static final String VALID_PATH = "src/main/resources/array/data.txt";
    static final String NONEXISTENT_PATH = "src/main/resources/array/test.txt";

    private ArrayReaderImpl arrayReader;

    @BeforeEach
    void setUp() {
        arrayReader = new ArrayReaderImpl();
    }

    @Test
    void readArray_ValidFile_ReturnsListOfArrays() throws ArrayCustomException {
        String filename = VALID_PATH;
        List<int[]> result = arrayReader.readArray(filename);
        Assertions.assertEquals(5, result.size());
    }

    @Test
    void readArray_NonexistentFile_ThrowsArrayCustomException() {
        String filename = NONEXISTENT_PATH;
        Assertions.assertThrows(ArrayCustomException.class, () -> {
            arrayReader.readArray(filename);
        });
    }
}

