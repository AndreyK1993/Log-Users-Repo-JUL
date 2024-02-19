package app.database;

import app.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Класс-коннектор к БД.
public class DBConn {

    private static final Logger LOGGER =
            Logger.getLogger(DBConn.class.getName());

    public static Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(Constants.DB_DRIVER +
                            Constants.DB_BASE_URL + Constants.DB_NAME);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
