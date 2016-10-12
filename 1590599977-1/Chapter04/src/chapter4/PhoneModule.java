package chapter4;

import static com.google.inject.matcher.Matchers.only;
import static com.google.inject.matcher.Matchers.returns;
import static com.google.inject.matcher.Matchers.subclassesOf;

import com.google.inject.AbstractModule;

public class PhoneModule extends AbstractModule {
    protected void configure() {
        bindInterceptor(
            subclassesOf(Phone.class),
            returns(only(Receiver.class)),
            new PhoneLoggerInterceptor(),
            new PhoneRedirectInterceptor()
        );
    }
}
