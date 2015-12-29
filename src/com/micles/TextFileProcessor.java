package com.micles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Bolesław on 2015-12-29.
 */
public class TextFileProcessor implements FileProcessor {
    @Override
    public void save(String fileName, List<Book> books) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(Book tmp: books){
                printWriter.println(tmp);
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Nie mozna zapisac pliku");
        }
    }

    @Override
    public List<Book> load(String FileName) {
        return null;
    }
}
