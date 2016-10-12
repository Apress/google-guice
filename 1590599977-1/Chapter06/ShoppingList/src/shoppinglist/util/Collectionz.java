package shoppinglist.util;

import java.util.HashMap;
import java.util.Map;

/** 
 * Named to avoid name clash with {@link java.util.Collections}. 
 * This class only exists because I don't want to add too much dependencies
 * to this sample application. In real life, use Google Collections!
 */
public class Collectionz {
    public static <K,V> Map<K,V> newHashMap() {
        return new HashMap<K,V>();
    }
}
