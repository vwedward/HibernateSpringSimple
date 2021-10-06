/*
 * ©Edward, 2021
 */

package ru.edward.bookmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.edward.bookmanager.MyBean;
import ru.edward.bookmanager.dao.BookDaoImpl;
import ru.edward.bookmanager.model.Book;
import ru.edward.bookmanager.service.BookServiceImpl;

@Configuration
@EnableTransactionManagement
public class MyConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedClasses(Book.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public BookDaoImpl bookDaoImpl() {
        return new BookDaoImpl();
    };

    @Bean
    public BookServiceImpl bookService() {
        return new BookServiceImpl();
    };

    @Bean
    public MyBean MyBean() {
        return new MyBean();
    }
}
