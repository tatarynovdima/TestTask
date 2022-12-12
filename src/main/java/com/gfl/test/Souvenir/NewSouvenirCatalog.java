package com.gfl.test.Souvenir;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NewSouvenirCatalog {
    private static HashMap<String, ArrayList<Souvenir>> catalogSouvenirs = new HashMap<>();

    private String fileName;
    private int year;
    private int month;

    public synchronized static void setCatalogSouvenirs (HashMap<String, ArrayList<Souvenir>> catalogSouvenirs) {
        NewSouvenirCatalog.catalogSouvenirs = catalogSouvenirs;
    }

    private void setFileName() {
        this.fileName = this.year + this.month + ".txt";
    }


    public void restoreCatalog () {

        this.year = LocalDateTime.now().getYear();
        this.month = LocalDateTime.now().getMonthValue();


        for (; this.year > 1800; this.year--) {
            for (this.month = 12; this.month > 0; this.month--) {
                setFileName();
                restore();
            }
        }
    }

    private void restore () {
        if (!new File(this.fileName).exists()) {
            NewSouvenirCatalog.catalogSouvenirs.put("" + this.year + this.month , new ArrayList<Souvenir>());
        } else {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.fileName))) {

                NewSouvenirCatalog.catalogSouvenirs.put(
                        String.valueOf( this.year + this.month),(ArrayList<Souvenir>) stream.readObject());

            } catch (IOException e) {
                System.out.printf("В файле %s ошибка", this.fileName);
                return;
            } catch (ClassNotFoundException e) {
                System.out.printf("В файле %s ошибка", this.fileName);
                return;
            }
        }
    }


    public static HashMap<String, ArrayList<Souvenir>> getCatalogSouvenirs() {
        return catalogSouvenirs;
    }
}
