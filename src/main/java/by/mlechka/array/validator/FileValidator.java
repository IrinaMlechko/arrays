package by.mlechka.array.validator;

import by.mlechka.array.exception.ArrayCustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileValidator {

    static Logger logger = LogManager.getLogger();

    public static void validateFile(String fileName) throws ArrayCustomException, FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        if (!scanner.hasNextLine()) {
            scanner.close();
            throw new ArrayCustomException("File is empty.");
        }
        String line = scanner.nextLine();
        if (!line.matches("[0-9\\s]+")) {
            scanner.close();
            throw new ArrayCustomException("Invalid character found in file: " + line.replaceAll("[0-9\\s]+", ""));
        }
        scanner.close();
    }

    public void validateFileStreams(String fileName) throws ArrayCustomException {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            long count = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(s -> !s.matches("\\d+"))
                    .count();
            if (count > 0) {
                throw new ArrayCustomException("Invalid data in file");
            }
        } catch (IOException e) {
            logger.fatal("File not found: " + fileName);
            throw new ArrayCustomException("File not found: " + fileName);
        }
    }
}
