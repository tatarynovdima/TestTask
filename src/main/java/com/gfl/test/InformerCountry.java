package com.gfl.test;

import com.gfl.test.Manufacturer.ArrayListManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.Souvenir.ArrayListSouvenir;
import com.gfl.test.Souvenir.SouvenirInfo;

public class InformerCountry {
    public void country() {
        printConcole console = new printConcole();
        String country = console.in("Необходимо указать название страны");
        System.out.printf("\nВ стране %s были произведены:\n", country);
        new ArrayListManufacturer()
                .getArrayListManufacturer()
                .stream()
                .filter(s -> s.getCountry().equals(country))
                .forEach(this::viewManufacturerSouvenirsTemp);
    }

    public void viewManufacturerSouvenirsTemp (Manufacturer manufacturer) {
        new ArrayListSouvenir().getArrayListSouvenirs().stream()
                .filter(souvenirs -> souvenirs.getManufacturer().equals(manufacturer))
                .forEach(souvenirs ->  new SouvenirInfo().infoProduct(souvenirs));
    }
}
