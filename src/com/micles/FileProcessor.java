package com.micles;

import java.util.List;

/**
 * Created by Bolesław on 2015-12-28.
 */
public interface FileProcessor {
    void save(String fileName, List<Book>books);
    List<Book> load(String FileName);
}
