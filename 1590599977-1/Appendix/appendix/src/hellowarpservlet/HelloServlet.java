package hellowarpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class HelloServlet extends HttpServlet {
    private final String appName;
    
    @Inject
    public HelloServlet(@Named("app.name") String appName) {
        this.appName = appName;
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