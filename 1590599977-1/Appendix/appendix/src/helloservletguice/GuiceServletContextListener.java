package helloservletguice;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceServletContextListener implements ServletContextListener {
    public static final String KEY = Injector.class.getName();

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(KEY, getInjector());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute(KEY);
    }

    private Injector getInjector() {
        return Guice.createInjector(new HelloGuiceModule());
    }
}
