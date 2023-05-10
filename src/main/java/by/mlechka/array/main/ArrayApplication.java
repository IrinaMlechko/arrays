package by.mlechka.array.main;

import by.mlechka.array.creator.DataArrayFactory;
import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;
import by.mlechka.array.model.Warehouse;
import by.mlechka.array.reader.ArrayReader;
import by.mlechka.array.reader.impl.ArrayReaderImpl;
import by.mlechka.array.repository.Repository;
import by.mlechka.array.service.ArithmeticArrayService;
import by.mlechka.array.service.impl.ArithmeticArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayApplication {

    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        String fileName = "src/main/resources/array/data.txt";
        ArrayReader reader = new ArrayReaderImpl();
        List<int[]> numbers;
        List<DataArray> dataArrays = new ArrayList<>();
        try {
            numbers = reader.readArray(fileName);
        } catch (ArrayCustomException ex) {
            throw new RuntimeException(ex);
        }

        try {
            dataArrays = DataArrayFactory.createDataArrayList(numbers);
            ArithmeticArrayService service = new ArithmeticArrayServiceImpl();
            for (DataArray dataArray : dataArrays) {
                logger.info("Original array: " + dataArray);
                service.findMinValue(dataArray);
                service.findMaxValue(dataArray);
                service.findAverageValue(dataArray);
                service.calculateSum(dataArray);
            }
        } catch (ArrayCustomException e) {
            System.err.println(e);
        }

        Repository arrayRepository = new Repository();
        for (DataArray dataArray : dataArrays){
            arrayRepository.add(dataArray);
        }

    }

}


