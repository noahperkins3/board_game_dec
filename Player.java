import cards.Card;
import cards.Deck;
import piece.Archer;
import piece.Piece;
import piece.Soldier;

import java.util.*;

public class Player { private static final int MAX_POINTS = 50;
    private final List<Piece> currPieces;
    private final Set<Card> allCards;
    private int pointsSpent = 0;
    private boolean noMorePoints = false;
    private final int playerNum;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.currPieces = new ArrayList<>();
        this.allCards = new HashSet<>();
        for (Piece piece : currPieces) {
            allCards.addAll(piece.getCards());
        }
    }

    public void pickPiece(Deck deck) {
        if (this.pointsSpent < MAX_POINTS) {
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + this.playerNum + " pick a piece!");
            String answer = input.nextLine();
            if (answer.equals("archer")) {
                this.currPieces.add(new Archer(0, deck));
                this.pointsSpent += Archer.cost();
            } else if (answer.equals("soldier")) {
                this.currPieces.add(new Soldier(0, deck));
                this.pointsSpent += Soldier.cost();
            } else {
                throw new IllegalArgumentException("Invalid piece!");
            }
        } else {
            this.noMorePoints = true;
        }
    }

    public Collection<Piece> getCurrPieces() {
        return this.currPieces;
    }

    public boolean hasNoMorePoints() {
        return this.noMorePoints;
    }

    public Collection<Card> getCards() {
        return this.allCards;
    }

    public void newRoundCards(Deck deck) {
        for (int i = 0; i < currPieces.size(); i++) {
            allCards.add(deck.dealTopCard());
        }
    }
}
