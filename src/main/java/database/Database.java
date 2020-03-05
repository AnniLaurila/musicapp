package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
	
    public static Connection connect() throws SQLException {
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
