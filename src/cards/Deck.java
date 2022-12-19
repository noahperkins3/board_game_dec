package cards;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Deck {
    private final List<Card> deck;
    private final Set<Card> discardPile;

    public Deck() {
        this.deck = new ArrayList<>();
        this.discardPile = new HashSet<>();
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();
        for (String suit : suits) {
            for (String faceName : faceNames) {
                this.deck.add(new Card(suit, faceName));
            }
        }
    }

    //shuffles the deck
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    //removes the top card
    public Card dealTopCard() {
        return this.deck.remove(0);
    }

    public int size() {
        return this.deck.size();
    }

    public void discard(Card card) {
        this.discardPile.add(card);
    }

    public void newRound() {
        this.deck.addAll(this.discardPile);
        Collections.shuffle(this.deck);
    }

}
