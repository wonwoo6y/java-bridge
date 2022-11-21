package bridge;

import java.util.Arrays;

public enum BridgeMoving {
    D(0),
    U(1);

    private final int numberNotation;

    BridgeMoving(int numberNotation) {
        this.numberNotation = numberNotation;
    }

    public int getNumberNotation() {
        return numberNotation;
    }

    public static String toString(int number) {
        return Arrays.stream(BridgeMoving.values())
                .filter(cell -> cell.getNumberNotation() == number)
                .findAny()
                .get().name();
    }
}