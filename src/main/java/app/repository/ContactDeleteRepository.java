package app.repository;

import app.database.DBConn;
import app.entity.User;
import app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDeleteRepository {

    private static final Logger LOGGER =
            Logger.getLogger(ContactDeleteRepository.class.getName());

    public String deleteContact(User user) {

        String sql = "DELETE FROM " + Constants.TABLE_CONTACTS + " WHERE id = ?";

        try (PreparedStatement stmt = DBConn.connect().prepareStatement(sql)) {
            // установка соответствующих параметров
            stmt.setInt(1, user.getId());
            // выполнение запроса в БД
            stmt.executeUpdate();
            return Constants.DATA_DELETE_MSG;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}
