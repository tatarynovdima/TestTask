package com.gfl.test.Souvenir;

import com.gfl.test.ArrayListNameElement;
import com.gfl.test.printConcole;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ElementSouvenirs {
    private int counter = 0;
    private final ArrayList<Souvenir> souvenirsTempList = new ArrayList<>();
    private Souvenir concreteSouvenir;
    private final String nameSouvenir;

    public ElementSouvenirs(@NonNull String nameSouvenir) {
        this.nameSouvenir = nameSouvenir;
        searchConcreteSouvenir ();
    }

    public Souvenir getConcreteSouvenir() {
        return concreteSouvenir;
    }

    @Nullable
    private void searchConcreteSouvenir () {

        if (!new ArrayListNameElement().returnArrayListNameSouvenir(nameSouvenir).isEmpty()) {
            new ArrayListSouvenir().getArrayListSouvenirs().stream()
                    .filter(souvenirs -> souvenirs.getSouvenirName().equals(nameSouvenir))
                    .forEach(souvenirsTempList::add);
        } else {
            System.out.println("Такого сувенира нет в списке");
            this.concreteSouvenir = null;
        }

        for ( ;counter < souvenirsTempList.size(); counter++) {
            System.out.printf("%s) ", counter + 1);
            new SouvenirInfo().infoProduct(souvenirsTempList.get(counter));
        }
        System.out.printf("%s) Его нет в списке", counter  + 1);
        printConcole console = new printConcole();
        int answer = Integer.parseInt(console.in("\nВыберите что то из списка"));
        if (answer == counter + 1){
            System.out.println("Сувенира с таким параметрами нет в базе");
            this.concreteSouvenir = null;
        } else {
            this.concreteSouvenir = souvenirsTempList.get(answer - 1);
        }

    }
}
