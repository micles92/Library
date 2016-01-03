package com.micles;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Michał on 30.12.2015.
 */
public class DataBaseProcessor implements DataProcessor {

    Connection connection;

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/library";

    public DataBaseProcessor() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Nie mozna zaladowac drivera mySQL");
        }
    }

    public void connect() throws SQLException {
       connection =  DriverManager.getConnection(URL,USER,PASSWORD);
    }

    @Override
    public void saveBook(String dataSourceName, List<Book> books) throws Exception {
        try {
            connect();
            connection.setAutoCommit(false);

            for(Book x: books){
                if(x instanceof Book){
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO books(title,autor,year,price) VALUES(?, ? ,? ,?)");
                    statement.setString(1, x.getTitle());
                    statement.setString(2, x.getAutor());
                    statement.setInt(3, x.getYear());
                    statement.setDouble(4, x.getPrice());
                    statement.executeUpdate();
                }
            }
           connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Zapis sie nie powiodl.");
        } finally {
            connection.close();
        }

    }

    @Override
    public List<Book> loadBook(String dataSourceName) throws Exception {
        connect();


        PreparedStatement statement = connection.prepareStatement("SELECT title, autor, year, price FROM books");
        ResultSet result = statement.executeQuery();
        List<Book>list = new ArrayList<>();

        while(result.next()){
            String title = result.getString(1);
            String autor = result.getString(2);
            int year = result.getInt(3);
            double price = result.getDouble(4);

            list.add(new Book(title, autor, year, price));
        }

        return list;
    }

    @Override
    public void saveUser(String dataSourceName, Set<User> users) throws Exception {
        try {
            connect();
            connection.setAutoCommit(false);
            for(User x: users){
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users(name,email,pesel) VALUES( ?, ?, ?) ");
                statement.setString(1,x.getName());
                statement.setString(2,x.getEmail());
                statement.setInt(3, x.getPesel());
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Zapis uzytkownikow sie nie powiodl.");
        } finally {
            connection.close();
        }
    }

    @Override
    public Set<User> loadUser(String dataSourceName) throws Exception {
        connect();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
        ResultSet result = statement.executeQuery();
        Set<User> set = new HashSet<>();

        while(result.next()){
            Integer id = result.getInt(1);
            String name = result.getString(2);
            String email = result.getString(3);
            Integer pesel = result.getInt(4);

            set.add(new User(name,email,pesel));
        }


        return set;
    }
}
