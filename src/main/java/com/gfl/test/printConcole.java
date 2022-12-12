package com.gfl.test;

import java.util.Scanner;
public class printConcole {
    public String in (String massage) {
        return scanner(massage);
    }

    private String scanner(String massage) {
        //Бесконечный цикл пока не будет введена команда или текст на консоль
        while (true) {
            System.out.println(massage);
            //Создаем обьект Scanner
            String command = new Scanner(System.in).nextLine();
            //проверка на пустоту
            if (command.equals("") || command == null) {
                System.out.println("Вы ничего не ввели, попробуйте еще раз!");
            } else {
                return command;
            }
        }
    }

    public boolean trueOrFalse() {
        //создаем обьект класса
        printConcole printConcole = new printConcole();
        String str = printConcole.in("""                    
                    Информация введена верно?
                    1) Да
                    2) Нет
                    """);
        //сравниваем строку игнорируя регистр
        if (str.equalsIgnoreCase("да") || str.equals("1")){
            return true;
        } else {
            return false;
        }
    }
}
