package com.micles;

import java.io.IOException;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Library obj = new Library(new BinaryFileProcessor());

        obj.addBook(new Book("Inkwizytor","Piekara",2005));
        obj.addBook(new Book("Pan Lodowego Ogrodu","Grzedowicz",2005));
        obj.addBook(new Book("Wiedzmin","Sapkowski",1999));

        obj.save();
        obj.load();
        System.out.println(obj);
    }
}
