package com.wideplay.warp.jpa;

import javax.persistence.EntityManagerFactory;

import net.jcip.annotations.ThreadSafe;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.wideplay.warp.persist.PersistenceService;

/**
 * For use with Warp-Persist. Needed because Guice's current
 * Struts 2 plugin creates the Guice Injector internally, thus is
 * not available to other filters before the Struts filter executes.
 * http://groups.google.com/group/warp-core/browse_thread/thread/738a8ce3c7275602/.
 * <p>
 * After serialization this class will currently fail to close down the JPA
 * {@link EntityManagerFactory} properly.
 * 
 * @author Robbie Vanbrabant
 */
@ThreadSafe
public class SessionPerRequestInterceptor implements Interceptor {
    // not Serializable
    private transient Provider<EntityManagerFactory> emfProvider;
    
    @Inject
    public SessionPerRequestInterceptor(Provider<EntityManagerFactory> emfProvider) {
        // only use after the PersistenceService starts
        this.emfProvider = emfProvider;
    }

    public String intercept(ActionInvocation ai) throws Exception {
        EntityManagerFactoryHolder.getCurrentEntityManager();      
        try {
            return ai.invoke();
        } finally {
            EntityManagerFactoryHolder.closeCurrentEntityManager();
        }
    }
    
    /**
     * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
     */
    public void init() {}
    
    /**
     * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
     */
    public void destroy() {
        if (emfProvider != null) {
            EntityManagerFactory emf = emfProvider.get();
            synchronized(emf) {
                if (emf.isOpen()) emf.close();
            }
        }
    }
    
    // This could use optional=true by requiring a binding annotation;
    // then users could choose whether the interceptor starts the
    // PersistenceService or not.
    @Inject 
    public void start(PersistenceService service) {
        // this is a good place to start the persistence service
        // for this to work, but you need to make sure that you only
        // have 1 (one) interceptor-ref to this interceptor. You can do this
        // by creating an interceptor-stack with this interceptor, and then
        // reference it through that single-interceptor stack.
        // Struts 2 creates one interceptor instance per interceptor-ref,
        // and the Guice plugin currently does not support scoping them.
        service.start();
    }
}
