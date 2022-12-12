package com.gfl.test;

import com.gfl.test.Souvenir.ArrayListSouvenir;
import com.gfl.test.Souvenir.SouvenirInfo;

public class Price {
    public void price() {
        //Создаем обьект класса прит для записи цены товара
        printConcole console = new printConcole();
        String priceTemp = console.in("Укажите цену");

        double price = Double.parseDouble(priceTemp.replace(',','.'));

        System.out.print("\nСписок производителей у которых есть цены на сувениры ниже указанной\n");

        new ArrayListSouvenir().getArrayListSouvenirs().stream().filter(souvenirs -> souvenirs.getPrice() < price)
                .forEach(souvenirs -> new SouvenirInfo().infoManufacturer(souvenirs.getManufacturer()));
    }
}