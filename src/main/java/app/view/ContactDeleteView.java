package app.view;

import java.util.Scanner;

public class ContactDeleteView {

    // Получение данных.
    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Enter contact's ID: ";
        System.out.print(title);
        String id = scanner.nextLine();
        return new String[] {id};
    }

    // Вывод результата.
    public void getOutput(String output) {
        System.out.println(output);
    }
}
