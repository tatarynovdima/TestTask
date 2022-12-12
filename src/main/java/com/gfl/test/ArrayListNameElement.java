package com.gfl.test;

import com.gfl.test.Manufacturer.ArrayListManufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenir;
import lombok.NonNull;

import java.util.ArrayList;

public class ArrayListNameElement {
    //Проверяем на пустоту лист, если лист не пустой выводим имя сувениров
    @NonNull
    public ArrayList<String> returnArrayListNameSouvenir (@NonNull String nameSouvenir) {
        ArrayList<String> list = new ArrayList<>();
        new ArrayListSouvenir().getArrayListSouvenirs().stream()
                .filter(souvenirs -> nameSouvenir.equals(souvenirs.getSouvenirName()))
                .forEach(souvenirs ->  list.add(souvenirs.getSouvenirName()));
        return list;
    }

    public ArrayList<String> returnAllManufactureName (){
        ArrayList<String> listTemp = new ArrayList<>();
        new ArrayListManufacturer().getArrayListManufacturer().forEach(
                manufacturer -> listTemp.add(manufacturer.getManufacturerName())
        );
        return listTemp;
    }
}
