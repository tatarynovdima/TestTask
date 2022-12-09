package com.gfl.test;

import java.io.*;

public class Catalog {

    //Обьевление переменной catalog типа класса Catalog, которая
    // может ссылаться на обькт
    private Catalog catalog;
    //Имя файла
    private String fileName;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean save () {
        snapShot();
        return !new File(fileName).exists();
    }
    public void restore () {
        rest();
    }
    private void snapShot () {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            //когда мы вызываем метод stream.writeObject(this),
            // который запускает механизм сериализации и объект разлагается на байты
            //при сериализации не сохраняется ни файл класса объекта, ни его методы, сохраняется лишь состояние объекта.
            stream.writeObject(this);
        } catch (IOException e) {
            //если что-то не так выбрасываем исключение которая возникла во время выполнения
            throw new RuntimeException(e);
        }
    }
    private void rest () {
        if (!new File(this.fileName).exists()) {
            //вызываем метод сет и передаем туда обьект Catalog()
            this.setCatalog(new Catalog());
        } else {
            try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(this.fileName))) {
               //С помощью  readObject() мы можем считать любой сериализуемый объект
                this.setCatalog((Catalog) stream.readObject());
            } catch (IOException e) {
                //Бросает исключение если возникла проблема при доступе к данным с помощью потоков
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                // Бросает исключение если в случае не нахождения класса JVM
                throw new RuntimeException(e);
            }
        }
    }
}