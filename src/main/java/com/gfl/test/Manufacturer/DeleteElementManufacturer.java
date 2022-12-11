package com.gfl.test.Manufacturer;

import com.gfl.test.Souvenir.DeleteElementSouvenire;

public class DeleteElementManufacturer {
    private String nameManufacturer;

    private Manufacturer concreteManufacturer;

    public DeleteElementManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
        createElementManufacturerToDelete();
    }

    private void createElementManufacturerToDelete() {
        ElementManufacturer concreteElementManufacturer =
                new ElementManufacturer(this.nameManufacturer);
        concreteManufacturer = concreteElementManufacturer.getManufacturer();
    }

    public boolean deleteManufacturer () {
        if (concreteManufacturer != null) {
            new DeleteElementSouvenire().deleteManufactureSouvenirs(concreteManufacturer);
            new CatalogManufacturer().deleteElementCatalogManufacture(concreteManufacturer);
            // Добавить ссылку на метод проверяющий наличие элемента в базе с развветвлением ифов
            return true;
        } else {
            return false;
        }
    }
}
