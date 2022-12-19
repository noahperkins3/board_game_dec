import cards.Card;
import cards.Deck;
import piece.Archer;
import piece.Piece;

public class Main {
    public static void main(String[] args) {
        Deck testDeck = new Deck();
        testDeck.shuffle();
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);
        while (!playerOne.hasNoMorePoints() && !playerTwo.hasNoMorePoints()) {
            playerOne.pickPiece(testDeck);
            playerTwo.pickPiece(testDeck);
            System.out.println("Deck size: " + testDeck.size());
        }
        System.out.println("Player 1 pieces: ");
        for (Piece piece : playerOne.getCurrPieces()) {
            System.out.println(piece.toString());
        }
        System.out.println("Player 1 cards: ");
        for (Piece piece : playerOne.getCurrPieces()) {
            System.out.println(piece);
        }
        System.out.println("Player 2 pieces: ");
        for (Piece piece : playerTwo.getCurrPieces()) {
            System.out.println(piece.toString());
        }
        System.out.println("Player 2 cards: ");
        for (Card card : playerTwo.getCards()) {
            System.out.println(card.toString());
        }
        /*for (int i = 0; i < 52; i++) {
            System.out.println(testDeck.dealTopCard().toString());
            System.out.println(testDeck.size());
        }
        Piece archer = new Archer(15, 0, testDeck);
        archer.addNewAbility(testDeck);
        archer.addNewAbility(testDeck);
        for (Card card : archer.getCards()) {
            System.out.println(card.toString());
        }
        System.out.println("Total Attack: " + archer.attackPower());
        System.out.println("Total Defense: " + archer.defendPower());
    */}
}