package hellowarpservlet;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HelloGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("app.name")).to("Hello Warp Servlet");
    }
}
