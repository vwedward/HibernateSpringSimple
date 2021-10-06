/*
 * ©Edward, 2021
 */

package ru.edward.bookmanager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.edward.bookmanager.config.MyConfig;

public class StartContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(MyConfig.class);
        MyBean myBean = springContext.getBean(MyBean.class);
        myBean.DbAccess();
        myBean.PrintMessage();
    }
}
