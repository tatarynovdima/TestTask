package com.gfl.test;

import com.gfl.test.Manufacturer.ArrayListManufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenir;
import com.gfl.test.Souvenir.SouvenirInfo;

public class InformerAllInfo {
    public void viewAllSouvenirs() {
        new ArrayListSouvenir().getArrayListSouvenirs().forEach(souvenirs -> new SouvenirInfo().infoProduct(souvenirs));
    }

    public void viewAllManufacturer () {
        new ArrayListManufacturer().getArrayListManufacturer().forEach(manufacturer ->  new SouvenirInfo().infoManufacturer(manufacturer));
    }
}
