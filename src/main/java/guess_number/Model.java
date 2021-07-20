package guess_number;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Integer> statistics = new ArrayList<>();
    private int randomNumber;
    private int bottomBound;
    private int upperBound;

    public int equalsRandomNumber(int number) {
        int response = Integer.compare(number, randomNumber);
        addTryToStatisticsList(number);

        if (response == 0) {
            return response;
        } else if (response == 1) {
            upperBound = number;
            return response;
        } else {
            bottomBound = number;
        }
        return response;
    }

    private void addTryToStatisticsList(int number) {
        statistics.add(number);
    }

    public void setBarrier(int min, int max) {
        this.bottomBound = min;
        this.upperBound = max;
    }

    public void setRandomNumber() {
        randomNumber = (int) Math.ceil(Math.random() * (upperBound - bottomBound - 1) + bottomBound);
    }

    public int getBottomBound() {
        return bottomBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public String getTryListString() {
        return statistics.toString();
    }
}