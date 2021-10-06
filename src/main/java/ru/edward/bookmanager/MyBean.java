/*
 * ©Edward, 2021
 */

package ru.edward.bookmanager;

import org.springframework.beans.factory.annotation.Autowired;
import ru.edward.bookmanager.model.Book;
import ru.edward.bookmanager.service.BookService;

public class MyBean {

    @Autowired
    private BookService bookService;

    public void PrintMessage() {
        System.out.println("PrintMessage");
    }

    public void DbAccess() {
        Book book1 = new Book();
        book1.setBookTitle("Преступление и наказание");
        book1.setBookAuthor("Достоевский");
        book1.setPrice(100);
        bookService.addBook(book1);

        Book book2 = new Book();
        book2.setBookTitle("Программирование");
        book2.setBookAuthor("Епрст Неизвестный");
        book2.setPrice(100);
        bookService.addBook(book2);
    }
}
