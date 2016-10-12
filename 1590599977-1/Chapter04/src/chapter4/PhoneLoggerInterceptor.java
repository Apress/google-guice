package chapter4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PhoneLoggerInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        for (Object arg : invocation.getArguments())
            if (arg instanceof Number)
                System.out.println("CALL: "+arg);
        
        return invocation.proceed();
    }
}
