package app.controller;

import app.service.ContactUpdateService;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.ContactUpdateView;

public class ContactUpdateController {

    ContactUpdateService service;
    ContactUpdateView view;

    public ContactUpdateController(ContactUpdateService service, ContactUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateContact() {
        // Получаем данные.
        // Передаем данные на обработку и получаем результат.
        String str = service.updateContact(view.getData());
        // Проверяем результат.
        // Если БД отсутствует, выводим сообщение об этом
        // и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}
