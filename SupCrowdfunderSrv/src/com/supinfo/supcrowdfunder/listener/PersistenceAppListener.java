package com.supinfo.supcrowdfunder.listener;

import com.supinfo.supcrowdfunder.utils.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        PersistenceManager.closeEntityManagerFactory();
    }
}
