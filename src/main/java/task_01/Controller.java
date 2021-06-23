package task_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void userGame() {
        inputWords();
        view.printMessage(model);
    }

    public void inputWords() {
        Scanner scanner = new Scanner(System.in);
        String word;
        ArrayList<String> message = new ArrayList<>();
        System.out.println("Print your message");
        for (; ; ) {
            word = scanner.next();

            if (word.equals("Hello") && !message.contains(word)) {
                message.add(word);
            } else if (word.equals("world") && !message.contains(word)) {
                message.add(word);
            } else {
                System.out.println("Wrong message - print again");
            }

            if (message.contains("world") && message.contains("Hello")) {
                model.setMessage(message);
                break;
            }
        }
    }
}

