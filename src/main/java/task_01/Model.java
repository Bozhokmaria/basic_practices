package task_01;

import java.util.ArrayList;

public class Model {
    private ArrayList<String> message = new ArrayList<>();

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> userMessage) {
        this.message = userMessage;
    }
}
