package hellowicketguice;

import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.AbstractModule;

public class WicketModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WebApplication.class).to(HelloGuiceApplication.class);
        install(new HelloGuiceModule());
    }
}
