package servicii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "ciscosecpa55";
    private final Connection connection;

    private DbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = getConnection();
        } catch (SQLException | ClassNotFoundException exception) {
            throw new RuntimeException("Something went wrong during connection/driver invocation!!!!");
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USER_NAME,DATABASE_PASSWORD);
    }

    private static final class SINGLETON_HOLDER{
        private static final DbConnection INSTANCE = new DbConnection();
    }

    public static DbConnection getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public Connection getDBConnection() {
        return this.connection;
    }
}