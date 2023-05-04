package by.mlechka.array.observer;

import by.mlechka.array.model.DataArray;

import java.util.EventObject;

public class ArrayEvent extends EventObject{

    public ArrayEvent(DataArray dataArray){
        super(dataArray);
    }

    @Override
    public DataArray getSource(){
        return (DataArray) super.getSource();
    }

}
