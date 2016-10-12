package shoppinglist.web;

import javax.servlet.http.HttpSession;

import net.jcip.annotations.NotThreadSafe;

import shoppinglist.web.util.User;
import shoppinglist.web.util.UserToken;

import com.google.inject.Inject;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@NotThreadSafe
public class LoginAction implements ModelDriven<User> {
    private final User user;
    private final HttpSession session;
    
    @Inject
    public LoginAction(User user, HttpSession session) {
        this.user = user; // simply a fresh instance from Guice
        this.session = session; // don't care about synchronization
    }
    
    public String execute() {
        if ("Robbie".equals(user.getLogin()) || "Dhanji".equals(user.getLogin())) {
            session.setAttribute(UserToken.KEY, new UserToken(user.getLogin()));
            return Action.SUCCESS;
        }
        return Action.INPUT;
    }

    public User getModel() {
        return user;
    }
}
