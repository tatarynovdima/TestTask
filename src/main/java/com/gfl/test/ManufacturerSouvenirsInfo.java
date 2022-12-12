package com.gfl.test;

import com.gfl.test.Manufacturer.ElementManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenirsManufacture;
import com.gfl.test.Souvenir.SouvenirInfo;

public class ManufacturerSouvenirsInfo {
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName = new printConcole().in("Укажите название производителя");

        Manufacturer manufacturerTemp;
        ElementManufacturer concreteElementManufacturer = new ElementManufacturer(manufacturerName);

        manufacturerTemp = concreteElementManufacturer.getManufacturer();

        new ArrayListSouvenirsManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new SouvenirInfo().infoProduct(souvenirs));
    }
}
