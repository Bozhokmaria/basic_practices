package guess_number;

public class View {
    public static final String WRONG_INPUT_ERROR = "You entered invalid data. Repeat please:";
    public static final String START_MESSAGE = "Greetings in \"Guess the number\" game,\ntry to guess number between %d and %d";

    private static final String LESS_NUMBER = "Your number (%d) is less than the correct number, it should be in diapason between %d and %d \nnumber of your tries: %s";
    private static final String GREATER_NUMBER = "Your number (%d) is greater than the correct number, it should be in diapason between %d and %d\n number of your tries: %s";
    private static final String WINNER_MESSAGE = "You are winner, it is %d";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStartMessage(int bottomBound, int upperBound) {
        System.out.printf((START_MESSAGE) + "%n", bottomBound, upperBound);
    }

    public void printGameInfo(int response, int number, int bottomBound, int upperBound, String tries) {
        if (response == 1) {
            System.out.printf((GREATER_NUMBER) + "%n", number, bottomBound, upperBound, tries);
            return;
        }
        System.out.printf((LESS_NUMBER) + "%n", number, bottomBound, upperBound, tries);
    }

    public void printGameInfo(int number) {
        System.out.printf(WINNER_MESSAGE, number);
    }
}