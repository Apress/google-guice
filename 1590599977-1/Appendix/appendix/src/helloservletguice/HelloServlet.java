package helloservletguice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class HelloServlet extends HttpServlet {
    @Inject
    @Named("app.name")
    private String appName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext sc = config.getServletContext();
        Injector injector = 
            (Injector) sc.getAttribute(GuiceServletContextListener.KEY);
        injector.injectMembers(this);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.printf("<h1>Welcome to the %s application!</h1>%n", appName);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
