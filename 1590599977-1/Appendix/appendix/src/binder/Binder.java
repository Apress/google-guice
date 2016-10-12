package binder;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Scopes;

public class Binder {
    private final List<BindingBuilder<?>> bindings =
        new ArrayList<BindingBuilder<?>>();
    
    public <T> BindingBuilder<T> bind(Class<T> clazz) {
        BindingBuilder<T> builder = new BindingBuilder<T>(clazz);
        bindings.add(builder);
        return builder;
    }
    
    public static void main(String[] args) {
        new Binder()
            .bind(FortuneService.class)
            .to(FortuneServiceImpl.class)
            .in(Scopes.SINGLETON);
    }    
}

interface FortuneService {}
class FortuneServiceImpl implements FortuneService {}
