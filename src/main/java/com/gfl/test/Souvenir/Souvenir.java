package com.gfl.test.Souvenir;

import com.gfl.test.Manufacturer.Manufacturer;

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
    private String producedDay;
    //Стоимость товара
    private double Price;
    //Айди сувенира
    private String idSouvenir;

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

    public String getProducedDay() {
        return producedDay;
    }

    public void setProducedDay(String producedDay) {
        this.producedDay = producedDay;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getIdSouvenir() {
        return idSouvenir;
    }

    public void setIdSouvenir(String idSouvenir) {
        this.idSouvenir = idSouvenir;
    }


    //Констркутор со всеми параметрами
    public Souvenir(String souvenirName, Manufacturer manufacturer, String producedYear, String producedMonth, String producedDay, double price, String idSouvenir) {
        this.souvenirName = souvenirName;
        this.manufacturer = manufacturer;
        this.producedYear = producedYear;
        this.producedMonth = producedMonth;
        this.producedDay = producedDay;
        Price = price;
        this.idSouvenir = idSouvenir;
    }

    public void newSouvenir(){

    }


    // переопределеный метод equals() для сравнеиня сложных обьектов
    @Override
    public boolean equals(Object obj) {


        return super.equals(obj);
    }


    //чтобы сравнить два обьекта перепоределяем так же метод hashCode()
    @Override
    public int hashCode() {
      return Objects.hash(souvenirName,manufacturer,producedYear, producedMonth,producedDay,Price,idSouvenir);
    }

}