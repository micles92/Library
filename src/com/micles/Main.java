package com.micles;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class Main {
    public static void main(String[] args) {
        Library obj = new Library(new TextFileProcessor());

        obj.addBook(new Book("Inkwizytor","Piekara",2005));
        obj.addBook(new Book("Pan Lodowego Ogrodu","Grzedowicz",2005));

        obj.save();
    }
}
