package com.gfl.test.Souvenir;

import com.gfl.test.Manufacturer.Manufacturer;

import java.util.ArrayList;

public class ArrayListSouvenirsConcreteManufacture {
    public ArrayList<Souvenir> returnArrayListSouvenirsConcreteManufacture (Manufacturer manufacturer){
        ArrayList<Souvenir> arrayListSouvenirsTemp = new ArrayList<>();
        new ArrayListSouvenir().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(arrayListSouvenirsTemp::add);
        return arrayListSouvenirsTemp;
    }
}
