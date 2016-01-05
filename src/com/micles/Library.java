package com.micles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class Library {
    private   List<Book> books;
    private   Set<User> users;
    private DataProcessor dataProcessor;



    public Library(DataProcessor dataProcessor) {
        books = new ArrayList<>();
        users = new HashSet<>();
        this.dataProcessor = dataProcessor;
    }

    public void viewUser(){
        for(User x: users){
            System.out.println(x);
        }
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void removeUser(String email){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User tmp = iterator.next();
            if(tmp.getEmail().equals(email)){
                iterator.remove();
            }
        }
    }



    //metody ksiazek
    public void viewBook(){
        for (Book x: books){
            System.out.println(x);
        }
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }
    public void removeBook(String title){
        Iterator<Book> iiterator = books.iterator();

        while(iiterator.hasNext()){
            Book tmp = iiterator.next();
            if(tmp.getTitle().equals(title)){
                iiterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }

    public void  saveBook() throws Exception {
        dataProcessor.saveBook("Baza", books);
    }
    public void loadBook() throws Exception {
        books = dataProcessor.loadBook("Baza");
    }

    public  void saveUser() throws Exception{
        dataProcessor.saveUser("Users", users);
    }

    public void loadUser() throws  Exception{
        dataProcessor.loadUser("Users");
    }
}
