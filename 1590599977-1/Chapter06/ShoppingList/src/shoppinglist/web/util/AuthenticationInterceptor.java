package shoppinglist.web.util;

import java.util.Map;

import net.jcip.annotations.ThreadSafe;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

// Struts 2 Interceptors are semi-singletons!
// http://readlist.com/lists/struts.apache.org/user/8/44571.html
@ThreadSafe
public class AuthenticationInterceptor implements Interceptor {
    public void destroy() {}
    public void init() {}

    public String intercept(ActionInvocation ai) throws Exception {
        // Struts 2's SessionMap synchronizes HttpSession access
        Map<?, ?> session = ai.getInvocationContext().getSession();
        UserToken user = (UserToken) session.get(UserToken.KEY);
        if (user == null) {
            return Action.LOGIN;
        } else {
            return ai.invoke();
        }
    }
}
