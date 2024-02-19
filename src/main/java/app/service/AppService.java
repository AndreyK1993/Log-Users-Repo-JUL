package app.service;

import app.controller.ContactCreateController;
import app.controller.ContactDeleteController;
import app.controller.ContactReadController;
import app.controller.ContactUpdateController;
import app.exceptions.OptionException;
import app.repository.ContactCreateRepository;
import app.repository.ContactDeleteRepository;
import app.repository.ContactReadRepository;
import app.repository.ContactUpdateRepository;
import app.utils.AppStarter;
import app.utils.Constants;
import app.view.ContactCreateView;
import app.view.ContactDeleteView;
import app.view.ContactReadView;
import app.view.ContactUpdateView;

public class AppService {

    public void createContact() {
        ContactCreateRepository repository = new ContactCreateRepository();
        ContactCreateService service = new ContactCreateService(repository);
        ContactCreateView view = new ContactCreateView();
        ContactCreateController controller = new ContactCreateController(service, view);
        controller.createContact();
    }

    public void readContacts() {
        ContactReadRepository repository = new ContactReadRepository();
        ContactReadService service = new ContactReadService(repository);
        ContactReadView view = new ContactReadView();
        ContactReadController controller = new ContactReadController(service, view);
        controller.readContacts();
    }

    public void updateContact() {
        ContactUpdateRepository repository = new ContactUpdateRepository();
        ContactUpdateService service = new ContactUpdateService(repository);
        ContactUpdateView view = new ContactUpdateView();
        ContactUpdateController controller = new ContactUpdateController(service, view);
        controller.updateContact();
    }

    public void deleteContact() {
        ContactDeleteRepository repository = new ContactDeleteRepository();
        ContactDeleteService service = new ContactDeleteService(repository);
        ContactDeleteView view = new ContactDeleteView();
        ContactDeleteController controller = new ContactDeleteController(service, view);
        controller.deleteContact();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Проверка наличия ввода в массиве выбора
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
