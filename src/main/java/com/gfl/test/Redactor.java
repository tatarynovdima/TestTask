package com.gfl.test;

import com.gfl.test.Manufacturer.CatalogManufacturer;
import com.gfl.test.Manufacturer.ElementManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.Souvenir.ElementSouvenirs;
import com.gfl.test.Souvenir.SaveSouvenirCatalog;
import com.gfl.test.Souvenir.Souvenir;
import lombok.NonNull;

public class Redactor {
    //
    private printConcole console = new printConcole();

    public void editManufacture() {
        ElementManufacturer concreteElementManufacturer = new ElementManufacturer(
                console.in("Введите имя производителя которого желаете отредактировать")
        );
        Manufacturer manufacturerTempEdite = concreteElementManufacturer.getManufacturer();
        if (manufacturerTempEdite != null) {
            manufacturerTempEdite = new Redactor().editManufacture(manufacturerTempEdite);
            new CatalogManufacturer().addElementCatalogManufacturer(manufacturerTempEdite);
        }
    }

    public void editSouvenirs(){
        ElementSouvenirs concreteElementSouvenirs = new ElementSouvenirs(console.in("Введите название сувенира"));
        Souvenir souvenirsTemp = concreteElementSouvenirs.getConcreteSouvenir();

        if (souvenirsTemp != null) {
            souvenirsTemp = new Redactor().editSouvenirs(souvenirsTemp);
            new SaveSouvenirCatalog(souvenirsTemp).addElementCatalog();
        }
    }

    public Manufacturer editManufacture(@NonNull Manufacturer manufacturer){


        int answer = Integer.parseInt( console.in ("""
                Что именно вы желаете изменить:
                1) Название производителя
                2) Страну
                3) Все
                """));
        if (answer == 2) {
            manufacturer.setCountry(console.in("Укажите страну"));
            return manufacturer;
        } else if (answer == 1){
            manufacturer.setManufacturerName(console.in("Введите новое название"));
            return manufacturer;
        } else {
            manufacturer.setCountry(console.in("Укажите страну"));
            manufacturer.setManufacturerName(console.in("Введите новое название"));
            return manufacturer;
        }
    }

    public Souvenir editSouvenirs(@NonNull Souvenir souvenirs){


        int choice = Integer.parseInt( console.in("""
                Какие именно изменения вы желаете внести?
                1) Изменить название
                2) Изменить цену
                3) Изменить год изготовления
                4) Изменить название изготовителя
                5) Изменить страну изготовителя
                """));
        if (choice == 1){
            souvenirs.setSouvenirName(console.in("Введите имя"));
        } else if (choice == 2){
            souvenirs.setPrice(Double.parseDouble(console.in("Введите цену")));
        } else if (choice == 3){
            souvenirs.setProducedYear(console.in("Введите год"));
        } else if (choice == 4){
            souvenirs.getManufacturer().setManufacturerName(console.in("Введите название производителя"));
        } else if (choice == 5){
            souvenirs.getManufacturer().setCountry(console.in("Введите название страны"));
        }
        return souvenirs;
    }
}
