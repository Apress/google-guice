package binder;

import com.google.inject.Scope;

public class BindingBuilder<T> {
    private Class<T> clazz;
    private Class<? extends T> impl;
    private Scope scope;
    
    public BindingBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public BindingBuilder<T> to(Class<? extends T> impl) {
        this.impl = impl;
        return this;
    }
    
    public void in(Scope scope) {
        this.scope = scope;
    }

    public Class<T> getClazz() {
        return clazz;
    }
    
    public Class<? extends T> getImpl() {
        return impl;
    }
    
    public Scope getScope() {
        return scope;
    }
}
