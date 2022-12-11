package com.gfl.test.Souvenir;

import com.gfl.test.printConcole;

import java.util.ArrayList;

public class ArrayListSouvenirsYear {
    printConcole console = new printConcole();
    public void Method () {
        ArrayList<Souvenir> arrayListSouvenirsYear =
                new ArrayListSouvenirsYear().returnArrayListSouvenirsYear(
                        console.in("Введите название сувенира"),
                        console.in("Укажите год производства"));
        if (arrayListSouvenirsYear.size() == 0 ){
            System.out.println("Под ваше описание ничего не подошло");
        } else {
            System.out.println("Вот подходящие под данное описание сувениры:");
            arrayListSouvenirsYear
                    .forEach(souvenirsTempYear -> new SouvenirInfo().infoProduct(souvenirsTempYear));
        }
    }
    public ArrayList<Souvenir> returnArrayListSouvenirsYear(String name, String year) {
        ArrayList<Souvenir> listArrayList = new ArrayList<>();
        new ArrayListSouvenir().getArrayListSouvenirs().stream()
                .filter(s -> s.getSouvenirName().equals(name))
                .filter(souvenirs -> souvenirs.getProducedYear().equals(year))
                .forEach(listArrayList::add);
        return listArrayList;
    }
}
