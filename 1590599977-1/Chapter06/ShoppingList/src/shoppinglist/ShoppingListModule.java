package shoppinglist;

import shoppinglist.repository.RepositoryModule;
import shoppinglist.web.WebModule;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ShoppingListModule implements Module {
    public void configure(Binder binder) {
        // Do not need ServletModule 
        // because the Struts plugin 1.0.1 installs it.
        
        // Application modules
        binder.install(new RepositoryModule());
        binder.install(new WebModule());
    }
}
