package com.micles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class Library {
    private   List<Book> books;
    private FileProcessor fileprocessor;


    public Library(FileProcessor fileProcessor) {
        books = new ArrayList<>();
        this.fileprocessor = fileProcessor;
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
                '}';
    }


    public void  save() throws FileNotFoundException {
        fileprocessor.save("Baza", books);
    }
    public void load() throws Exception {
        books = fileprocessor.load("Baza");
    }
}
