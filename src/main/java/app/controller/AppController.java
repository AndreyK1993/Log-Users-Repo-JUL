package app.controller;

import app.service.AppService;
import app.utils.Constants;
import app.view.AppView;


public class AppController {

    AppView view;
    AppService service;

    public AppController(AppView view, AppService service) {
        this.view = view;
        this.service = service;
    }

    public void runApp() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.createContact();
            case 2 -> service.readContacts();
            case 3 -> service.updateContact();
            case 4 -> service.deleteContact();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }
}
