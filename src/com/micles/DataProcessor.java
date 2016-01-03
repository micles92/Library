package com.micles;

import java.util.List;
import java.util.Set;

/**
 * Created by Michał on 30.12.2015.
 */
public interface DataProcessor {
    void saveBook(String dataSourceName, List<Book> books) throws Exception;
    List<Book> loadBook(String dataSourceName) throws Exception;


    void saveUser(String dataSourceName, Set<User> users) throws Exception;
    Set<User> loadUser(String dataSourceName) throws Exception;
}
