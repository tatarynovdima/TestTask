package com.gfl.test.Souvenir;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveSouvenirCatalog {
    private String fileName;
    private String year;
    private String month;
    private ArrayList<Souvenir> listSouvenirs;
    private Souvenir addSouvenirs;

    private void setAddElementCatalog (Souvenir souvenirs) {
        this.addSouvenirs = souvenirs;
    }

    public SaveSouvenirCatalog(Souvenir souvenirs) {
        setAddElementCatalog(souvenirs);
    }

    public void addElementCatalog () {
        //добавляем информацию о дате в файл
        this.year = this.addSouvenirs.getProducedYear();
        this.month = this.addSouvenirs.getProducedMonth();
        this.fileName = this.year + this.month + ".txt";

        this.listSouvenirs = NewSouvenirCatalog.getCatalogSouvenirs().get(this.year + this.month);
        this.listSouvenirs.add(this.addSouvenirs);
        snapShot();
    }


    private void snapShot () {
        //записываем лист сувениров с помощью метода writeObject
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            stream.writeObject(this.listSouvenirs);
        } catch (IOException e) {
            //если не получилось записать бросаем исключение
            throw new RuntimeException(e);
        }
    }
}
