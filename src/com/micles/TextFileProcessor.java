package com.micles;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bolesław on 2015-12-29.
 */
public class TextFileProcessor implements FileProcessor {
    @Override
    public void saveBook(String fileName, List<Book> books) {
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
    public List<Book> loadBook(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Book> books = new ArrayList<>();

        String textLine = bufferedReader.readLine();
        do{
            String tmp[] = textLine.split(",");
            if(tmp[0].equals("B")){
                books.add(new Book(tmp[1],tmp[2],Integer.parseInt(tmp[3]), Double.parseDouble(tmp[4])));
            }
            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return books;
    }

    @Override
    public void saveUser(String fileName, Set<User> users) throws Exception {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(User x: users){
                printWriter.println(x);
            }

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie udalo sie zapisac pliku");
        }

    }

    @Override
    public Set<User> loadUser(String fileName) throws Exception {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Set<User>users = new HashSet<>();

        String textLine = bufferedReader.readLine();
        do{
            String tmp[] = textLine.split(",");
            if(tmp[0].equals("U")){
                users.add(new User(tmp[1],tmp[2],Integer.parseInt(tmp[3])));
            }
            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return users;
    }
}
