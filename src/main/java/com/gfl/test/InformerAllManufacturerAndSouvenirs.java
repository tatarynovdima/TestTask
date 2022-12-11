package com.gfl.test;

import com.gfl.test.Manufacturer.ArrayListManufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenir;
import com.gfl.test.Souvenir.SouvenirInfo;

public class InformerAllManufacturerAndSouvenirs {
    public void viewInfoAllManufacturer() {
        new ArrayListManufacturer().getArrayListManufacturer().forEach(manufacturerTemp-> {
            new SouvenirInfo().infoManufacturer(manufacturerTemp);
            new ArrayListSouvenir().getArrayListSouvenirs().stream()
                    .filter(x-> x.getManufacturer().getManufacturerName().equals(manufacturerTemp.getManufacturerName()))
                    .forEach(souvenirs -> new SouvenirInfo().infoProduct(souvenirs));
        });
    }
}
