package task_01;

import java.util.ArrayList;

public class View {

    public void printMessage(Model model) {
        System.out.println("Congrats!");
        ArrayList<String> message = model.getMessage();
        for (int i = 0; i < message.size(); i++) {
            System.out.print(message.get(i) + " ");
        }
    }
}
