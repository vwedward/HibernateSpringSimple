package ru.edward.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.edward.bookmanager.model.Book;

import java.util.List;

//@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);

        if (book != null) {
            session.delete(book);
        }
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.load(Book.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();

        return (List<Book>) session.createQuery("from Book").list();
    }
}
