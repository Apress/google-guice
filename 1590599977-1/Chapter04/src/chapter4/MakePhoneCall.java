package chapter4;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MakePhoneCall {
    public static void main(String[] args) {
        Injector i = Guice.createInjector(new PhoneModule());
        Phone phone = i.getInstance(Phone.class);
        Receiver auntJane = phone.call(123456789);
        System.out.println(auntJane);
    }
}
