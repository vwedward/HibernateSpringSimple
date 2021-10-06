/*
 * ©Edward, 2021
 */

package ru.edward.bookmanager.service;

import ru.edward.bookmanager.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(int id);
    public Book getBookByID(int id);
    public List<Book> listBook();
}
