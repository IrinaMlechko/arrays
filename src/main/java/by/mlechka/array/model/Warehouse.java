package by.mlechka.array.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warehouse {

    private static Warehouse instance;

    private Map<UUID, ArrayStatistics> mapWithArrayCharacteristics;

    public Warehouse() {
        mapWithArrayCharacteristics = new HashMap<>();
    }

    public static Warehouse getInstance() {

        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayStatistics put(UUID key, ArrayStatistics value) {
        var test = mapWithArrayCharacteristics.put(key, value);
        System.out.println(mapWithArrayCharacteristics.get(key));
        return test;
    }

    public ArrayStatistics remove(UUID key) {
        return mapWithArrayCharacteristics.remove(key);
    }

    public ArrayStatistics replace(UUID key, ArrayStatistics value) {
        return mapWithArrayCharacteristics.replace(key, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("mapWithArrayCharacteristics=").append(mapWithArrayCharacteristics);
        sb.append('}');
        return sb.toString();
    }
}
