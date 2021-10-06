/*
 * ©Edward, 2021
 */

package ru.edward.bookmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edward.bookmanager.dao.BookDao;
import ru.edward.bookmanager.model.Book;

import java.util.List;

//@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookByID(int id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBook() {
        return this.bookDao.listBooks();
    }
}
