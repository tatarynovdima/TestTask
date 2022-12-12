package com.gfl.test.Start;

import com.gfl.test.*;
import com.gfl.test.Manufacturer.DeleteElementManufacturer;
import com.gfl.test.Manufacturer.Manufacturer;
import com.gfl.test.Souvenir.AllSouvenirsFindYear;
import com.gfl.test.Souvenir.ArrayListSouvenirsYear;
import com.gfl.test.Souvenir.Souvenir;

public class Menu {
    boolean closedProgram;

    public void startProgram() {

        while (!closedProgram) {

            System.out.println("""
                    1) Добавление сувенира
                    2) редактирование сувенира
                    3) просмотр всех производителей
                    4) просмотр всех сувениров
                    5) Вывести информацию о сувенирах заданного производителя
                    6) Вывести информацию о сувенирах, произведенных в заданной стране
                    7) Вывести информацию о производителях, чьи цены на сувениры меньше заданной
                    8) Вывести информацию по всем производителям и их сувенирам
                    9) Вывести информацию о производителях заданного сувенира, произведенного в заданном году.
                    10) Для каждого года вывести список сувениров, произведенных в этом году.
                    11) Удалить заданного производителя и его сувениры. 
                    12) Добавление нового производителя
                    13) редактирование производителя
                    14) Закрыть
                    """);

            String command = new printConcole().in("Введите номер действия которое хотите выполнить");

            switch (command) {
                case "1":
                    new Souvenir().newSouvenir();
                    break;
                case "2":
                    new Redactor().editSouvenirs();
                    break;
                case "3":
                    new AllInfo().viewAllManufacturer();
                    break;
                case "4":
                    new AllInfo().viewAllSouvenirs();
                    break;
                case "5":
                    new ManufacturerSouvenirsInfo().viewInfoAllManufacturerSouvenirs();
                    break;
                case "6":
                    new InfoCountry().country();
                    break;
                case "7":
                    new Price().price();
                    break;
                case "8":
                    new ManufacturerSouvenirsInfoAll().viewInfoAllManufacturer();
                    break;
                case "9":
                    new ArrayListSouvenirsYear().Method();
                    break;
                case "10":
                    new AllSouvenirsFindYear().viewAllSouvenirsGroupYear();
                    break;
                case "11":
                    new DeleteElementManufacturer(new printConcole().in("Введите название производителя"))
                            .deleteManufacturer();
                    break;
                case "12":
                    new Manufacturer().addNewManufacture();
                    break;
                case "13":
                    new Redactor().editManufacture();
                    break;
                case "14":
                    this.closedProgram = true;
                    break;
            }
        }
    }
}
