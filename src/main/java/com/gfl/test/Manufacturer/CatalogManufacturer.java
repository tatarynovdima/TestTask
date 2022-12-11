package com.gfl.test.Manufacturer;

import com.gfl.test.Catalog;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class CatalogManufacturer extends Catalog implements Serializable {

    //инициализируем HashMap
    HashMap<String, Manufacturer> catalogManufacturer;
    public HashMap<String, Manufacturer> getCatalogManufacturer() {
        return catalogManufacturer;
    }

    public CatalogManufacturer() {
        //установливаем имя файла
        this.setFileName("catalogmanufacturer.txt");

        if (!new File("catalogmanufacturer.txt").exists()) {
            //создаем обьект HashMap
            this.catalogManufacturer = new HashMap<>();
        } else {
            //вызываем метод класса Catalog с помощью которого считываем Catalog
            restore();
            this.catalogManufacturer = ((CatalogManufacturer) this.getCatalog()).getCatalogManufacturer();
        }
    }

    //Добавляем новый элемент в каталог
    public void addElementCatalogManufacturer (Manufacturer manufacturer) {
        //вызываем метод класса Catalog с помощью которого считываем Catalog
        restore();
        // условие проверяет наличие ключа, если ключ есть возрощает true
        if (this.catalogManufacturer.containsKey(manufacturer.getIdManufacturer())) {
            //метод реплей заменяет строки
            this.catalogManufacturer.replace(manufacturer.getIdManufacturer(), manufacturer);
        } else {
            //вставляем элемент в колекции
            this.catalogManufacturer.put(manufacturer.getIdManufacturer(), manufacturer);
        }
        save();
    }


    //Удаялем элемент из каталога
    public void deleteElementCatalogManufacture(Manufacturer manufacturer) {
        //вызываем метод класса Catalog с помощью которого считываем Catalog
        restore();
        //удаляем элемент из колекции
        this.catalogManufacturer.remove(manufacturer.getIdManufacturer());
        save();
    }


    public void addCatalogManufacturer (HashMap<String, Manufacturer> map) {
        //вызываем метод класса Catalog с помощью которого считываем Catalog
        restore();
        this.catalogManufacturer = map;
        save();
    }
}
