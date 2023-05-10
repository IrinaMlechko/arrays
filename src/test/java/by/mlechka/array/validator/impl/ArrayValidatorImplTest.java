package by.mlechka.array.validator.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayValidatorImplTest {

    private ArrayValidatorImpl arrayValidator;

    @BeforeEach
    void setUp() {
        arrayValidator = new ArrayValidatorImpl();
    }

    @Test
    void arrayValidate_ValidIntArrayString_ReturnsTrue() {
        String validArrayString = "1 2 3 4 5";
        boolean isValid = arrayValidator.arrayValidate(validArrayString);
        Assertions.assertTrue(isValid);
    }

    @Test
    void arrayValidate_ValidIntArrayStringWithNegativeNumbers_ReturnsTrue() {
        String validArrayString = "-1 -2 -3 -4 -5";
        boolean isValid = arrayValidator.arrayValidate(validArrayString);
        Assertions.assertTrue(isValid);
    }

    @Test
    void arrayValidate_ValidIntArrayStringWithLeadingAndTrailingWhitespace_ReturnsTrue() {
        String validArrayString = " 1 2 3 4 5  ";
        boolean isValid = arrayValidator.arrayValidate(validArrayString);
        Assertions.assertTrue(isValid);
    }

    @Test
    void arrayValidate_InvalidIntArrayStringWithInvalidCharacters_ReturnsFalse() {
        String invalidArrayString = "1 2a 3 4 5";
        boolean isValid = arrayValidator.arrayValidate(invalidArrayString);
        Assertions.assertFalse(isValid);
    }

    @Test
    void arrayValidate_ValidIntArrayStringWithExtraWhitespaces_ReturnsFalse() {
        String invalidArrayString = "1  2 3 4 5";
        boolean isValid = arrayValidator.arrayValidate(invalidArrayString);
        Assertions.assertTrue(isValid);
    }

}
