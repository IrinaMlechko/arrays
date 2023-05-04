package by.mlechka.array.main;

import by.mlechka.array.exception.ArrayCutomException;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.service.DataArrayService;
import by.mlechka.array.service.impl.DataArrayServiceImpl;
import by.mlechka.array.validator.FileValidator;

import java.io.FileNotFoundException;

public class ArrayApplication {

        public static void main(String[] args) {
            String fileName = "numbers.txt";
            FileValidator validator = new FileValidator();
            try {
                validator.validateFileStreams(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
                return;
            } catch (ArrayCutomException e) {
                System.out.println("Invalid data in file: " + e.getMessage());
                return;
            }

            try {
                DataArrayService service = new DataArrayServiceImpl();
                int[] numbers = service.createArrayFromFileStreams(fileName).getNumbers();
                DataArray dataArray = new DataArray(numbers);


                System.out.println("Original array: " + dataArray.toString());

                int minValue = service.findMinValue(dataArray);
                System.out.println("Minimum value in array: " + minValue);

                int maxValue = service.findMaxValue(dataArray);
                System.out.println("Maximum value in array: " + maxValue);

                service.replaceValues(dataArray, minValue, maxValue);
                System.out.println("Array after replacement: " + dataArray.toString());

                double averageValue = service.findAverageValue(dataArray);
                System.out.println("Average value in array: " + averageValue);

                int sum = service.calculateSum(dataArray);
                System.out.println("Sum of values in array: " + sum);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            } catch (ArrayCutomException e) {
                System.out.println("Invalid data in file: " + e.getMessage());
            }
        }
}
