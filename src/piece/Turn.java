package piece;

import board.Board;

public abstract class Turn {

    private Board board;
    private static Piece piece;
    private int destinationCoordinate;
    private boolean hasDisadvantage;

    public Turn(Board board,
                Piece piece,
                int destinationCoordinate,
                boolean hasDisadvantage) {
        this.board = board;
        this.piece = piece;
        this.destinationCoordinate = destinationCoordinate;
        this.hasDisadvantage = hasDisadvantage;
    }

        public static class Move extends Turn {

        public Move(Board board, Piece piece, int destinationCoordinate, boolean hasDisadvantage) {
            super(board, piece, destinationCoordinate, hasDisadvantage);
        }

        public boolean hasDisadvantage() {
            return super.hasDisadvantage;
        }
    }

    public static class StaticMove extends Turn {

        public StaticMove(Board board, Piece piece, int destinationCoordinate, boolean hasDisadvantage) {
            super(board, piece, destinationCoordinate, hasDisadvantage);
        }
    }
}
