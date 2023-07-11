package utils;

import java.util.List;

public class Utilities {

    public static boolean validRange(int numberToCheck, int min, int max) {
        return ((numberToCheck >= min) && (numberToCheck <= max));
    }

    public static boolean validRange(float numbertoCheck, float min, float max, float delta) {
        return ((numbertoCheck >= (min-delta)) && (numbertoCheck <= (max+delta)));

    }

    public static String truncateString(String stringToTruncate, int length){
        if (stringToTruncate != null) {
            if (stringToTruncate.length() <= length) {
                return stringToTruncate;
            } else {
                return stringToTruncate.substring(0, length);
            }
        }
        else
            return null;
    }

    public static boolean isValidIndex(List list, int indexToCheck){
        return ((indexToCheck >= 0) && (indexToCheck < list.size()));
    }
}
