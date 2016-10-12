
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Start Jetty on the codebase's exploded WAR structure.
 * For use with Eclipse or perhaps another IDE.
 * 
 * @author Robbie Vanbrabant
 */
public class JettyRunner {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext wac = new WebAppContext();
        wac.setContextPath("/");
        // current dir is the toplevel project dir
        wac.setWar("./");
        server.setHandler(wac);
        server.setStopAtShutdown(true);
        server.start();
        server.join();
    }
}
