package guess_number;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void game() {
        Scanner sc = new Scanner(System.in);
        model.setBarrier(GlobalConstants.MIN_BARRIER, GlobalConstants.MAX_BARRIER);
        model.setRandomNumber();
        view.printStartMessage(model.getBottomBound(), model.getUpperBound());
        int number;
        int response;
        while ((response = (model.equalsRandomNumber(number = input(sc)))) != 0) {
            view.printGameInfo(response, number, model.getBottomBound(), model.getUpperBound(), model.getTryListString());
        }
        view.printGameInfo(number);

    }

    private int input(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_ERROR);
            sc.next();
        }
        int res = sc.nextInt();
        if (res <= model.getUpperBound() && res >= model.getBottomBound()) {
            return res;
        }
        view.printMessage(View.WRONG_INPUT_ERROR);
        return input(sc);
    }
}