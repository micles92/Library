package com.micles;

import java.io.*;
import java.util.*;

/**
 * Created by Michał on 29.12.2015.
 */
public class BinaryFileProcessor implements FileProcessor{
    @Override
    public void saveBook(String fileName, List<Book> books) throws FileNotFoundException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Book x: books){
                objectOutputStream.writeObject(x);
            }
            objectOutputStream.writeObject(null);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> loadBook(String FileName) throws IOException {
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

    @Override
    public void saveUser(String fileName, Set<User> users) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(User x: users){
                objectOutputStream.writeObject(x);
            }
            objectOutputStream.writeObject(null);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Set<User> loadUser(String fileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Set<User> users = new HashSet<>();

        try {
            User u = (User) objectInputStream.readObject();
            while (u != null){
                users.add(u);
                u = (User) objectInputStream.readObject();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;

    }
}
