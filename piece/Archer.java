package piece;

import board.Board;
import board.BoardUtils;
import board.Tile;
import cards.Card;
import cards.Deck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Archer extends Piece {

    private static final int MAX_HP = 15;

    private static final int MAX_NUM_ABILITIES = 3;

    private static final int[] CANDIDATE_COORDINATES = {-16, -9, -8, -7, -2, 2, 7, 8, 9, 16};

    private int piecePosition;
    private int healthPoints = 15;
    private final List<Card> abilities;

    public Archer(int piecePosition, Deck deck) {
        super(piecePosition, deck);
        this.healthPoints = healthPoints;
        abilities = new ArrayList<>();
        abilities.add(deck.dealTopCard());
    }

    public int attackPower() {
        int result = 0;
        for (Card card : this.abilities) {
            if (card.getSuit().equals("spades")) {
                result += card.getFaceValue() * 2;
            } else {
                result += card.getFaceValue();
            }
        }
        return result;
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
        return "archer";
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

    @Override
    public Collection<Turn.Move> calculateLegalMoves(final Board board) {
        final List<Turn.Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_COORDINATES) {
            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                if (isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isEighthColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                                candidateDestinationTile.isTileOccupied()) {
                    continue;
                } else if (board.getTile(BoardUtils.leftAdjacentTile(candidateDestinationCoordinate)).isTileOccupied() ||
                        board.getTile(BoardUtils.rightAdjacentTile(candidateDestinationCoordinate)).isTileOccupied() ||
                        board.getTile(BoardUtils.aboveAdjacentTile(candidateDestinationCoordinate)).isTileOccupied() ||
                        board.getTile(BoardUtils.belowAdjacentTile(candidateDestinationCoordinate)).isTileOccupied()) {
                    legalMoves.add(new Turn.Move(board, this, candidateDestinationCoordinate, true));
                    // disadvantage
                } else {
                    legalMoves.add(new Turn.Move(board, this, candidateDestinationCoordinate, false));
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -2 || candidateOffset == -9);
    }

    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -2);
    }

    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == 2);
    }

    private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == 2 || candidateOffset == 9);
    }
}
