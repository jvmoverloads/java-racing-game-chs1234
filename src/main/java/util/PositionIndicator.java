package util;

public class PositionIndicator {

    private static final String DISPLAY_CHARACTER = "-";

    public static String indicateCharacterByPosition(int position) {
        return DISPLAY_CHARACTER.repeat(Math.max(0, position));
    }
}
