package hellowicketguice;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Welcome extends WebPage {
    @Inject @Named("app.name") private String appName;
    
    public Welcome() {
        add(new Label("welcome", String.format("Welcome to the %s application!", appName)));
    }
}
