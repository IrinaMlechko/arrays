package by.mlechka.array.reader.impl;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.reader.ArrayReader;
import by.mlechka.array.validator.ArrayValidator;
import by.mlechka.array.validator.impl.ArrayValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    private static final String SPACE_DELIMITER = "\\s+";

    public List<int[]> readArray(String filename) throws ArrayCustomException {
        Path path = Path.of(filename);
        if (!Files.exists(path)) {
            throw new ArrayCustomException("File does not exist. " + filename);
        }
        int[] oneArray;
        List<int[]> resultList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            ArrayValidator validator = new ArrayValidatorImpl();
            for (int i = 0; i < lines.size(); i++) {
                String strNum = lines.get(i);
                if (validator.arrayValidate(strNum)) {
                    String[] numArr = strNum.split(SPACE_DELIMITER);
                    oneArray = new int[numArr.length];
                    for (int j = 0; j < numArr.length; j++) {
                        oneArray[j] = Integer.parseInt(numArr[j]);
                    }
                    resultList.add(oneArray);
                }
            }
            return resultList;
        } catch (IOException e) {
            throw new ArrayCustomException(e);
        }
    }
}
