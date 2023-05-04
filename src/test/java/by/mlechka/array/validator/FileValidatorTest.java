package by.mlechka.array.validator;

import by.mlechka.array.exception.ArrayCutomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class FileValidatorTest {
    @Test
    public void testValidateFile() throws ArrayCutomException, FileNotFoundException {
        FileValidator.validateFile("src/test/java/resources/test1.txt");
    }

    @Test
    public void testValidateFileWithInvalidCharacter() throws FileNotFoundException {
        Assertions.assertThrows(ArrayCutomException.class, () -> {
            FileValidator.validateFile("src/test/java/resources/test2.txt");
        });
    }

    @Test
    public void testValidateEmptyFile() throws FileNotFoundException {
        Assertions.assertThrows(ArrayCutomException.class, () -> {
            FileValidator.validateFile("src/test/java/resources/test3.txt");
        });
    }

    @Test
    public void testValidateNonexistentFile() throws FileNotFoundException {
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            FileValidator.validateFile("src/test/java/resources/nonexistent.txt");
        });
    }
}
