package assignment.six;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleSingleton {
    private static Connection conn = null;

    private static SampleSingleton instance = null;

    private SampleSingleton() {}

    public static SampleSingleton getInstance() {
        if (instance == null) {
            synchronized (SampleSingleton.class) {
                if (instance == null) {
                    try {
                        conn = DriverManager.getConnection("fakedb");
                        SampleSingleton.instance = new SampleSingleton();
                    }
                    catch (SQLException e) {
                        System.out.println("Error connecting to db " + e.getMessage());
                    }
                }
            }
        }

        return instance;
    }
}

