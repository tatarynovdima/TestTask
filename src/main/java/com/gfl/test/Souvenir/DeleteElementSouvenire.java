package com.gfl.test.Souvenir;

import com.gfl.test.Catalog;
import com.gfl.test.Manufacturer.Manufacturer;

import java.util.ArrayList;

public class DeleteElementSouvenire extends CatalogSouvenirs {
    public void deleteManufactureSouvenirs (Manufacturer manufacturer) {
        ArrayList<Souvenir> list =
                new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturer);
        list.forEach(this::deleteConcreteSouvenirs);
        save();
    }
}