package piece;

import board.Board;
import cards.Card;
import cards.Deck;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Piece {

    private int piecePosition;
    private List<Card> abilities;

    public Piece(int piecePosition, Deck deck) {
        this.piecePosition = piecePosition;
    }

    public abstract int attackPower();

    public abstract int defendPower();

    public abstract String toString();

    public abstract void addNewAbility(Deck deck);

    public abstract List<Card> getCards();

    public abstract int getHP();

    public abstract Collection<Turn.Move> calculateLegalMoves(final Board board);
}
