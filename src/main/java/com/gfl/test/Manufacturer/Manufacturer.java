package com.gfl.test.Manufacturer;

import com.gfl.test.printConcole;

import java.util.Objects;

public class Manufacturer {
    //название производителя
    private String manufacturerName;
    //страна где было производство
    private String country;
    // айди производителя
    private String idManufacturer;

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public Manufacturer addNewManufacture () {

        printConcole console = new printConcole();
        this.manufacturerName = console.in("Введите название производителя");
        this.country = console.in("Введите страну производителя");
        this.idManufacturer = String.valueOf(new CatalogManufacturer().getCatalogManufacturer().size());
        new CatalogManufacturer().addElementCatalogManufacturer(this);
        return this;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerName, country);
    }
}
