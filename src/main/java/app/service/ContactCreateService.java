package app.service;

import app.database.DBCheck;
import app.entity.User;
import app.exceptions.CreateException;
import app.exceptions.DBException;
import app.repository.ContactCreateRepository;
import app.utils.Constants;
import app.utils.PhoneValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactCreateService {

    ContactCreateRepository repository;
    private static final Logger LOGGER =
            Logger.getLogger(ContactCreateService.class.getName());

    public ContactCreateService(ContactCreateRepository repository) {

        this.repository = repository;
    }

    public String createContact(String[] data) {
        // Проверяем на наличие файла БД.
        // ДА - работаем с данными. НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPTS_WRONG_MSG);
                return ce.getErrors(errors);
            }
        }

        return repository.createContact(mapData(data));
    }

    private Map<String, String> validateData(String[] data) {
        // Map для сбора ошибок
        Map<String, String> errors = new HashMap<>();

        if (data[0].trim().isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);

        if (PhoneValidator.isPhoneValid(data[1].trim()))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (EmailValidator.isEmailValid(data[2].trim()))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    // Преобразовываем массив данных в объект.
    private User mapData(String[] data) {
        // Создаем объект.
        User user = new User();
        // Устанавливаем значения свойств объекта.
        user.setName(data[0].trim());
        user.setPhone(data[1].trim());
        // Возвращаем объект.
        return user;
    }
}
