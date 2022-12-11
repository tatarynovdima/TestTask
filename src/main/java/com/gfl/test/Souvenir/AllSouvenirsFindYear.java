package com.gfl.test.Souvenir;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSouvenirsFindYear {
    private ArrayList<Souvenir> list;
    private Map<String, List<Souvenir>> mapSouvenirs;


    public AllSouvenirsFindYear() {
        this.list = new ArrayListSouvenir().getArrayListSouvenirs();
        this.mapSouvenirs = list.stream().filter(s -> s.getPrice() != 0)
                .collect(Collectors.groupingBy(Souvenir::getProducedYear));
    }

    public void viewAllSouvenirsGroupYear() {
        Set<String> set = mapSouvenirs.keySet();
        set.forEach(s ->{
            System.out.printf("\nВ %s году были произведены:\n", mapSouvenirs.get(s).get(0).getProducedYear());
            mapSouvenirs.get(s).forEach(c -> new SouvenirInfo().infoProduct(c));
        });
    }
}
