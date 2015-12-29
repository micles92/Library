package com.micles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 29.12.2015.
 */
public class BinaryFileProcessor implements FileProcessor{
    @Override
    public void save(String fileName, List<Book> books) throws FileNotFoundException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Book x: books){
                objectOutputStream.writeObject(x);
            }
            objectOutputStream.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> load(String FileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Book>books = new ArrayList<>();


        try {
            Book p = (Book) objectInputStream.readObject();
            while (p != null){
                books.add(p);
                p = (Book) objectInputStream.readObject();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return books;
    }
}
