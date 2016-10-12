package hellowicketguice;

import org.apache.wicket.protocol.http.WebApplication;


public class HelloGuiceApplication extends WebApplication {
    @Override
    public Class<?> getHomePage() {
        return Welcome.class;
    }
}