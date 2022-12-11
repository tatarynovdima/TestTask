package com.gfl.test.Manufacturer;

import com.gfl.test.ArrayListNameElement;
import com.gfl.test.Souvenir.SouvenirInfo;
import com.gfl.test.printConcole;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ElementManufacturer {
    private final String manufacturerName;
    private Manufacturer manufacturer;

    public ElementManufacturer(@NonNull String manufacturerName) {
        this.manufacturerName = manufacturerName;
        returnObjectManufacturerForManufacturerName ();
    }
    @Nullable
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }

    private void returnObjectManufacturerForManufacturerName () {
        Manufacturer manufacturerTemp;
        if ( new ArrayListNameElement().returnAllManufactureName().contains(manufacturerName)){
            manufacturerTemp = new ArrayListManufacturer().getArrayListManufacturer().stream()
                    .filter(manufacturer -> manufacturer.getManufacturerName().equals(manufacturerName))
                    .findFirst()
                    .get();
            new SouvenirInfo().infoManufacturer(manufacturerTemp);
            if (new printConcole().trueOrFalse()) {
                this.manufacturer = manufacturerTemp;
            } else {
                concreteManufacturer();
            }
        } else {
            System.out.println("Производителя с таким названием нет в базе");
            this.manufacturer = null;
        }
    }

    private void concreteManufacturer () {
        int counter = 0;
        ArrayList<Manufacturer> listManufacturerTempConcreteManufacturer = new ArrayList<>();

        new ArrayListManufacturer().getArrayListManufacturer().stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().equals(this.manufacturerName))
                .forEach(listManufacturerTempConcreteManufacturer::add);


        for ( ;counter < listManufacturerTempConcreteManufacturer.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new SouvenirInfo().infoManufacturer(listManufacturerTempConcreteManufacturer.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        printConcole console = new printConcole();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Производителя с таким параметрами нет в базе");
            this.manufacturer =  null;
        } else {
            this.manufacturer =  listManufacturerTempConcreteManufacturer.get(answer - 1);
        }
    }

}
