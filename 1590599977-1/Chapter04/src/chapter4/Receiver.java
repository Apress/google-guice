package chapter4;


public class Receiver {
    private final String name;
    public Receiver(String name) {
        this.name = name;
    }
    public String toString() {
        return String.format("%s[name=%s]", getClass().getName(), name);
    }
}
