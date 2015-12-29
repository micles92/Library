package com.micles;

import java.io.*;
import java.util.ArrayList;
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
    public List<Book> load(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Book> books = new ArrayList<>();

        String textLine = bufferedReader.readLine();
        do{
            String tmp[] = textLine.split(",");
            if(tmp[0].equals("B")){
                books.add(new Book(tmp[1],tmp[2],Integer.parseInt(tmp[3])));
            }
            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return books;
    }
}
