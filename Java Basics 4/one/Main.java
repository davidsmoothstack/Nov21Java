package one;

import java.util.Arrays;

public class Main {
    private static volatile Main instance;

    public static void main(final String[] args) {
        final var objectList = Arrays.asList(new Object[10]);

        // All instances should have the same hash code
        objectList.stream()
                .parallel()
                .map(obj -> getInstance())
                .forEach(obj -> System.out.println("Hash: " + obj.hashCode()));
    }

    public static Main getInstance() {
        if (instance == null) {
            synchronized (Main.class) {
                if (instance == null)
                    instance = new Main();
            }
        }

        return instance;
    }
}
