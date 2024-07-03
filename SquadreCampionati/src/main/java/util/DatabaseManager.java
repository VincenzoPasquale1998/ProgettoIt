package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() throws SQLException {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String JDBC_DRIVER ="com.mysql.jdbc.Driver";
            String url = props.getProperty("url");
            //url="jdbc:mysql://localhost:3306/campionato_calcio";
            String user = props.getProperty("user");
            //user="root";
            String password = props.getProperty("password");
            //password="";
            //connection = DriverManager.getConnection(url, user, password);
			Class.forName(JDBC_DRIVER);
			connection=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new SQLException("Errore di connessione al database", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}