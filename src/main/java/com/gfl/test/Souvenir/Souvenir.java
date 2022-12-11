package com.gfl.test.Souvenir;

import com.gfl.test.Manufacturer.ElementManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.printConcole;

import java.io.Serializable;
import java.util.Objects;

public class Souvenir implements Serializable {
    //Название товара
    private String souvenirName;
    //Реквезиты производителя
    private Manufacturer manufacturer;
    //Дата
    private String producedYear;
    private String producedMonth;


    //Стоимость товара
    private double price;
    //Айди сувенира
    private String idSouvenir;

    public Souvenir() {

    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProducedYear() {
        return producedYear;
    }

    public void setProducedYear(String producedYear) {
        this.producedYear = producedYear;
    }

    public String getProducedMonth() {
        return producedMonth;
    }

    public void setProducedMonth(String producedMonth) {
        this.producedMonth = producedMonth;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIdSouvenir() {
        return idSouvenir;
    }

    public void setIdSouvenir(String idSouvenir) {
        this.idSouvenir = idSouvenir;
    }


    //Констркутор со всеми параметрами
    public Souvenir(String souvenirName, Manufacturer manufacturer, String producedYear, String producedMonth, double price, String idSouvenir) {
        this.souvenirName = souvenirName;
        this.manufacturer = manufacturer;
        this.producedYear = producedYear;
        this.producedMonth = producedMonth;
        this.price = price;
        this.idSouvenir = idSouvenir;
    }

    public void newSouvenir(){
        printConcole concole = new printConcole();
        this.souvenirName = concole.in("Необходимо указать название сувенира");
        this.producedYear = concole.in("Введите год производства");
        this.producedMonth = concole.in("Введите месяц производства");
        this.price = Double.parseDouble(concole.in("Укажите стоимость"));

        ElementManufacturer concrete = new ElementManufacturer(
                concole.in("Введите название производителя"));
        Manufacturer manufacturerTempCreate = concrete.getManufacturer();


        if (manufacturerTempCreate != null){
            this.manufacturer = manufacturerTempCreate;
        } else {
            this.manufacturer = new Manufacturer().addNewManufacture();
        }

        new SaveSouvenirCatalog(this).addElementCatalog();
    }


    // переопределеный метод equals() для сравнеиня сложных обьектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Souvenir souvenirs = (Souvenir) obj;
        return Double.compare(souvenirs.price, price) == 0
                && Objects.equals(idSouvenir, souvenirs.idSouvenir)
                && Objects.equals(souvenirName, souvenirs.souvenirName)
                && Objects.equals(manufacturer, souvenirs.manufacturer)
                && Objects.equals(producedYear, souvenirs.producedYear)
                && Objects.equals(producedMonth, souvenirs.producedMonth);
    }


    //чтобы сравнить два обьекта перепоределяем так же метод hashCode()
    @Override
    public int hashCode() {
      return Objects.hash(souvenirName,manufacturer,producedYear, producedMonth,price,idSouvenir);
    }

}