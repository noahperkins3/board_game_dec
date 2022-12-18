package cards;

import java.util.Arrays;
import java.util.List;

public class Card {
    private final String suit;
    private final String faceName;

    public Card(final String suit,
                final String faceName) {
        this.suit = suit;
        this.faceName = faceName;
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("clubs", "spades", "hearts", "diamonds");
    }

    public static List<String> getValidFaceNames() {
        return Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    }

    public String toString() {
        return faceName + " of " + suit;
    }

    public int getFaceValue() {
        int result = 0;
        for (int i = 0; i < 13; i++) {
            switch (this.faceName) {
                case "A" -> result = 1;
                case "2" -> result = 2;
                case "3" -> result = 3;
                case "4" -> result = 4;
                case "5" -> result = 5;
                case "6" -> result = 6;
                case "7" -> result = 7;
                case "8" -> result = 8;
                case "9" -> result = 9;
                case "10", "J" -> result = 10;
                case "Q" -> result = 15;
                case "K" -> result = 20;
            }
        }
        return result;
    }

    public String getSuit() {
        return suit;
    }

}
