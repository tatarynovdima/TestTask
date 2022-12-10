package com.gfl.test.Souvenir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SouvenirArrayList {
    HashMap<String, ArrayList<Souvenir>> map;
    private ArrayList<Souvenir> list = new ArrayList<>();

    public void ArrayListSouvenirs() {
        new NewSouvenirCatalog().restoreCatalog();
        this.map = NewSouvenirCatalog.getCatalogSouvenirs();
        Set<String> names = this.map.keySet();
        names.forEach(name -> list.addAll(this.map.get(name)));
    }

    public ArrayList<Souvenir> getArrayListSouvenirs() {
        return this.list;
    }
}
