package app.repository;

import app.database.DBConn;
import app.entity.User;
import app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactCreateRepository {

    private static final Logger LOGGER =
            Logger.getLogger(ContactCreateRepository.class.getName());

    public String createContact(User user) {
        String sql = "INSERT INTO " + Constants.TABLE_CONTACTS + "(name, phone) VALUES(?, ?)";
        // PreparedStatement - подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}
