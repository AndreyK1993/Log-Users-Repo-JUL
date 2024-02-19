package app.repository;

import app.database.DBConn;
import app.entity.User;
import app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactReadRepository {

    private static final Logger LOGGER =
            Logger.getLogger(ContactReadRepository.class.getName());

    public List<User> readContacts() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            List<User> list = new ArrayList<>();

            String sql = "SELECT id, name, phone FROM " + Constants.TABLE_CONTACTS;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
            // Возвращаем коллекцию данных
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }
}
