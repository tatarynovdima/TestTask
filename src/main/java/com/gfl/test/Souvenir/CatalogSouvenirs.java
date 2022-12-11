package com.gfl.test.Souvenir;

import com.gfl.test.Catalog;
import com.gfl.test.Manufacturer.Manufacturer;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class CatalogSouvenirs extends Catalog implements Serializable {
    HashMap<String, Souvenir> catalogSouvenirs;

    public HashMap<String, Souvenir> getCatalogSouvenirs() {
        return catalogSouvenirs;
    }

    public CatalogSouvenirs() {
        this.setFileName("catalogsouvenirs.txt");

        if (!new File("catalogsouvenirs.txt").exists()) {
            this.catalogSouvenirs = new HashMap<>();
        } else {
            restore();
            this.catalogSouvenirs = ((CatalogSouvenirs) this.getCatalog()).getCatalogSouvenirs();
        }

    }

    public void addElementCatalogSouvenirs (Souvenir souvenirsTemp) {
        restore();
        if (this.catalogSouvenirs.containsKey(souvenirsTemp.getIdSouvenir())) {
            this.catalogSouvenirs.replace(souvenirsTemp.getIdSouvenir(), souvenirsTemp);
        } else {
            this.catalogSouvenirs.put(souvenirsTemp.getIdSouvenir(), souvenirsTemp);
        }
        save();
    }

    public void deleteManufactureSouvenirs (Manufacturer manufacturer) {
        restore();
        ArrayList<Souvenir> list =
                new ArrayListSouvenirsConcreteManufacture().returnArrayListSouvenirsConcreteManufacture(manufacturer);
        list.forEach(this::deleteConcreteSouvenirs);
        save();
    }
    public void deleteConcreteSouvenirs (Souvenir souvenirs) {
        restore();
        this.catalogSouvenirs.remove(souvenirs.getIdSouvenir());
        save();
    }

    public void addCatalogSouvenirs (HashMap<String, Souvenir> map) {
        restore();
        this.catalogSouvenirs = map;
        save();
    }
}
