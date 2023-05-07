package by.mlechka.array.creator;

import by.mlechka.array.exception.ArrayCustomException;
import by.mlechka.array.model.DataArray;

import java.util.ArrayList;
import java.util.List;

public class DataArrayFactory {

    public static DataArray createDataArray(int[] array) throws ArrayCustomException {
        if (array == null) {
            throw new ArrayCustomException("Can not create a DataArray with a null array");
        }
        DataArray dataArray = new DataArray(array);
        return dataArray;
    }

    public static List<DataArray> createDataArrayList(List<int[]> arrays) throws ArrayCustomException {
        List<DataArray> dataArrays = new ArrayList<>();
        for (int[] array : arrays) {
            if (array != null) {
                DataArray dataArray = new DataArray(array);
                dataArrays.add(dataArray);
            } else {
                throw new ArrayCustomException("Can not create a DataArray with a null array");
            }

        }
        return dataArrays;
    }

}
