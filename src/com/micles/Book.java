package com.micles;

import java.io.Serializable;

/**
 * Created by Bolesław on 2015-12-28.
 */
public class Book implements Serializable {

    private String title;
    private String autor;
    private int year;
    private double price;
    private final static String BOOKID= "B";

    public Book(String title, String autor, int year, double price) {
        this.title = title;
        this.autor = autor;
        this.year = year;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return autor != null ? autor.equals(book.autor) : book.autor == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = BOOKID + "," + title + "," + autor + "," + year;
        return result;
    }
}
