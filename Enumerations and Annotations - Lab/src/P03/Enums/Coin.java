package P03.Enums;

/**
 * Created by Andrian on 25.3.2017 г..
 */
public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);


    private int value;
    Coin(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
