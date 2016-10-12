package shoppinglist.web.util;

import java.io.Serializable;

import net.jcip.annotations.Immutable;

/**
 * Identifies a user session.
 * @author Robbie Vanbrabant
 */
@Immutable
public class UserToken implements Serializable {
    /** Key used to store the {@link UserToken} in the session. */
    public static final String KEY = UserToken.class.getSimpleName();

    private final String login;
    public UserToken(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
}
