package EightsGame;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.play();

		Deck deck = new Deck("Deck");
		deck.shuffleDeck(); //

		Hand hand = new Hand("Hand");
		deck.deal(hand, 5); //
		hand.display(); //

		Hand drawPile = new Hand("Draw Pile");
		deck.dealAll(drawPile);//

		System.out.printf("Draw Pile has %d cards.\n", drawPile.size());

	}
}
