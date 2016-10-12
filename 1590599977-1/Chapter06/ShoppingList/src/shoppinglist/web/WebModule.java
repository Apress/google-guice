package shoppinglist.web;

import javax.servlet.http.HttpSession;

import shoppinglist.web.util.UserToken;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class WebModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserToken.class).toProvider(UserTokenProvider.class);// no scope!
    }
    
    static class UserTokenProvider implements Provider<UserToken> {
        @Inject private HttpSession session;
        public UserToken get() {
            // Struts 2 synchronizes on the same object
            synchronized (session) {
                return (UserToken) session.getAttribute(UserToken.KEY);
            }
        }
    }
}
