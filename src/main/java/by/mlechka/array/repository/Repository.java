package by.mlechka.array.repository;

import by.mlechka.array.model.DataArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class Repository {

    private static Repository instance;

    private static final List<DataArray> dataArrays = new ArrayList<>();

    public Repository(){}

    public static Repository getInstance(){

        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public List<DataArray> getDataArrays() {
        return dataArrays;
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", DataArray.class.getSimpleName() + "[", "]")
                .add("dataArrays=" + dataArrays)
                .toString();
    }

    public boolean add(DataArray dataArray) {
        return dataArrays.add(dataArray);
    }

    public boolean addAll(List<DataArray> dataArrays) {
        return this.dataArrays.addAll(dataArrays);
    }

    public boolean delete(DataArray dataArray) {
        return dataArrays.remove(dataArray);
    }

    public boolean deleteAll(List<DataArray> dataArrays) {
        return this.dataArrays.removeAll(dataArrays);
    }

    public DataArray queryFindFirstBySpecification (Specification specification) {
        return dataArrays.stream().filter(specification::specify).findFirst().orElse(null);
    }

    public void sortArrayByFirstElement() {
        dataArrays.sort(Comparator.comparingInt(o -> o.getNumbers()[0]));
    }

    public void sortArrayByLength() {
        dataArrays.sort(Comparator.comparingInt(o -> o.getNumbers().length));
    }
}
