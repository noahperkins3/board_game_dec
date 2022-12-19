package piece;

import board.Board;
import board.Tile;
import cards.Card;
import cards.Deck;
import java.util.*;

import java.util.Collection;

public class Soldier extends Piece {

    private int healthPoints = 20;
    private int piecePosition;
    private List<Card> abilities;

    private static final int[] CANDIDATE_COORDINATES = {-16, -9, -8, -7, -2, 2, 7, 8, 9, 16};

    public Soldier(int piecePosition, Deck deck) {
        super(piecePosition, deck);
        abilities = new ArrayList<>();
        abilities.add(deck.dealTopCard());
    }

    @Override
    public Collection<Turn.Move> calculateLegalMoves(Board board) {
        final List<Turn.Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_COORDINATES) {
            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
        }


        return Collections.unmodifiableList(legalMoves);
    }

    @Override
    public int attackPower() {
        return 0;
    }

    @Override
    public int defendPower() {
        int result = 0;
        for (Card card : this.abilities) {
            if (card.getSuit().equals("clubs")) {
                result += card.getFaceValue() * 2;
            } else {
                result += card.getFaceValue();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "soldier";
    }

    public static int cost() {
        return 10;
    }

    @Override
    public void addNewAbility(Deck deck) {
        abilities.add(deck.dealTopCard());
    }

    @Override
    public List<Card> getCards() {
        return abilities;
    }

    @Override
    public int getHP() {
        return this.healthPoints;
    }

}
