package com.gfl.test;

import com.gfl.test.Manufacturer.ElementManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenirsConcreteManufacture;
import com.gfl.test.Souvenir.SouvenirInfo;

public class InformerManufacturerSouvenirs {
    public void viewInfoAllManufacturerSouvenirs () {
        String manufacturerName;
        manufacturerName = new printConcole().in("Укажите название производителя");
        Manufacturer manufacturerTemp;
        ElementManufacturer concreteElementManufacturer = new ElementManufacturer(manufacturerName);
        manufacturerTemp = concreteElementManufacturer.getManufacturer();
        new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturerTemp)
                .forEach(souvenirs ->  new SouvenirInfo().infoProduct(souvenirs));
    }
}
