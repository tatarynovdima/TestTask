package com.gfl.test.Souvenir;

import com.gfl.test.Manufacturer.Manufacturer;
import lombok.NonNull;

public class SouvenirInfo {
    public void infoProduct(@NonNull Souvenir souvenirs) {
        System.out.printf(
                """
                        
                        Название сувенира: %s
                        Год производства: %s
                        Цена сувенира: %s
                        Страна производства: %s
                        Производитель: %s
                        
                        """,
                souvenirs.getSouvenirName(),
                souvenirs.getProducedYear(),
                souvenirs.getPrice(),
                souvenirs.getManufacturer().getCountry(),
                souvenirs.getManufacturer().getManufacturerName()
        );
    }
    public void infoManufacturer (@NonNull Manufacturer manufacturer){
        System.out.printf("""
                
                Название производителя: %s
                Страна: %s
                
                """,
                manufacturer.getManufacturerName(),
                manufacturer.getCountry()
        );
    }
}
