package app.utils;

// Валидация
public class EmailValidator {
    public static boolean isEmailValid(String email) {

        return email.isEmpty() || !email.matches(Constants.EMAIL_RGX);
    }
}
