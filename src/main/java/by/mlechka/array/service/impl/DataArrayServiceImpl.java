//package by.mlechka.array.service.impl;
//
//import by.mlechka.array.exception.ArrayCustomException;
//import by.mlechka.array.service.DataArrayService;
//import by.mlechka.array.model.DataArray;
//
//import by.mlechka.array.validator.FileValidator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.stream.Stream;
//
//public class DataArrayServiceImpl implements DataArrayService {
//
//    static Logger logger = LogManager.getLogger(DataArrayServiceImpl.class);
//
//    @Override
//    public DataArray createArrayFromFile(String fileName) throws ArrayCustomException, FileNotFoundException {
//        FileValidator.validateFile(fileName);
//        int[] numbers = readNumbersFromFile(fileName);
//        return new DataArray(numbers);
//    }
//    @Override
//    public int[] readNumbersFromFile(String fileName) throws ArrayCustomException, FileNotFoundException {
//        Scanner scanner = new Scanner(new File(fileName));
//        String line = scanner.nextLine();
//        String[] numberStrings = line.split(" ");
//        int[] numbers = new int[numberStrings.length];
//        for (int i = 0; i < numberStrings.length; i++) {
//            try {
//                numbers[i] = Integer.parseInt(numberStrings[i]);
//            } catch (NumberFormatException e) {
//                throw new ArrayCustomException("Invalid number format: " + numberStrings[i]);
//            }
//        }
//        scanner.close();
//        return numbers;
//    }
//
//    @Override
//    public DataArray createArrayFromFileStreams(String fileName) throws ArrayCustomException{
//        FileValidator fileValidator = new FileValidator();
//        fileValidator.validateFileStreams(fileName);
//        int[] numbers = Arrays.stream(readLineFromFileStreams(fileName).split("\\s"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        return new DataArray(numbers);
//    }
//    @Override
//    public String readLineFromFileStreams(String fileName) throws ArrayCustomException {
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            return stream.findFirst().orElseThrow(FileNotFoundException::new);
//        } catch (IOException e) {
//            throw new ArrayCustomException("File is wrong");
//        }
//    }
//
//    private void validateNumbersStreams(int[] numbers) throws ArrayCustomException {
//        boolean invalidNumberExists = Arrays.stream(numbers).anyMatch(number -> number < 1 || number > 10);
//        if (invalidNumberExists) {
//            throw new ArrayCustomException("Invalid number found");
//        }
//    }
//}
