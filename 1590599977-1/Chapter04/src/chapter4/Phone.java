package chapter4;

import java.util.HashMap;
import java.util.Map;

public class Phone {
    private static final Map<Number, Receiver> RECEIVERS =
        new HashMap<Number, Receiver>();
    
    static { 
        RECEIVERS.put(123456789, new Receiver("Aunt Jane"));
        RECEIVERS.put(111111111, new Receiver("Santa"));
    }
    
    public Receiver call(Number number) {
        return RECEIVERS.get(number);
    }
}
