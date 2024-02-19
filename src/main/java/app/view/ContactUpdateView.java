package app.view;

import java.util.Scanner;

public class ContactUpdateView {

    // Получение данных.
    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine();

        title = "Enter new phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        String phone = scanner.nextLine();

        title = "Enter new email in format example@mail.com: ";
        System.out.print(title);
        String email = scanner.nextLine().trim();

        return new String[] {id, phone, email};
    }

    // Вывод результата.
    public void getOutput(String output) {
        System.out.println(output);
    }
}
