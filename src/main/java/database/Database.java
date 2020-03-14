package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
    public static Connection connect(String JDBC_URL) throws SQLException {
        if (JDBC_URL == null) {
            throw new RuntimeException("JDBC_DATABASE_URL environment variable not found");
        } else {
            return DriverManager.getConnection(JDBC_URL);
        }
    }
    
    public static void closeResources(AutoCloseable... sqlResources) {
        for (AutoCloseable a : sqlResources) {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
