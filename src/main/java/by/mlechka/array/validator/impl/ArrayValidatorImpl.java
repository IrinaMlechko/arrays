package by.mlechka.array.validator.impl;

import by.mlechka.array.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {

    static Logger logger = LogManager.getLogger();

    private static final String INT_ARRAY_REGEX = "\\s*[-]?\\d{1,5}(?:\\s+[-]?\\d{1,5})*\\s*";

    @Override
    public boolean arrayValidate(String stringArray) {
        boolean result = stringArray.matches(INT_ARRAY_REGEX);
        if(result){
            logger.debug("String {} contains only numbers and whitespaces and will be processed to an array with numbers", stringArray);
        } else {
            logger.debug("String {} do not contain only numbers and whitespaces and will be ignored", stringArray);
        }
        return result;
    }
}
