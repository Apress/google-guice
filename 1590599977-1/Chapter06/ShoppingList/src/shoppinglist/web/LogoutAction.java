package shoppinglist.web;

import javax.servlet.http.HttpSession;

import com.google.inject.Inject;
import com.opensymphony.xwork2.Action;

// http://struts.apache.org/2.x/docs/how-do-we-get-invalidate-the-session.html
// Using SessionAware is ugly for invalidating
public class LogoutAction {
    @Inject HttpSession session;
    
    public String execute() {
      try {
        return Action.SUCCESS;
      } finally {
        session.invalidate();
      }
    }
}
