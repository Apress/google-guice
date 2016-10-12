package hellowarpservlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.wideplay.warp.servlet.Servlets;
import com.wideplay.warp.servlet.WarpServletContextListener;

public class HelloGuiceServletContextListener extends WarpServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new HelloGuiceModule(), 
                Servlets.configure()
                        .filters()
                        .servlets().serve("/*").with(HelloServlet.class)
                        .buildModule());
    }
}
