package shoppinglist.web.util;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String name) {
        this.login = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
