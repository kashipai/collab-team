package Game;

import java.util.Scanner;

public class EightsCardGame {
	private Player one;
	private Player two;
	private Player three;
	private Hand drawPile;
	private Hand discardPile;
	private Scanner input;

	public EightsCardGame() {
		Deck deck = new Deck("Deck");
		deck.shuffle();

		int handSize = 5;
		one = new Player("Harsharaj");
		deck.deal(one.getHand(), handSize);

		two = new Player("Anush");
		deck.deal(two.getHand(), handSize);

		three = new Player("Prajwal");
		deck.deal(three.getHand(), handSize);

		discardPile = new Hand("Discards");
		deck.deal(discardPile, 1);

		drawPile = new Hand("Draw pile");
		deck.dealAll(drawPile);

		input = new Scanner(System.in);
	}

	public boolean isDone() {
		return one.getHand().empty() || two.getHand().empty() || three.getHand().empty();
	}

	public void reshuffle() {

		Card prev = discardPile.popCard();

		discardPile.dealAll(drawPile);

		discardPile.addCard(prev);

		drawPile.shuffle();
	}

	public Card draw() {
		if (drawPile.empty()) {
			reshuffle();
		}
		return drawPile.popCard();
	}

	public Player nextPlayer(Player current) {
		if (current == one) {
			return two;
		} else {
			return one;
		}

	}

	public void displayState() {
		one.display();
		two.display();
		three.display();
		discardPile.display();
		System.out.print("Draw pile: ");
		System.out.println(drawPile.size() + " cards");
	}

	public void waitForUser() {
		input.nextLine();
	}

	public void takeTurn(Player player) {
		Card prev = discardPile.last();
		Card next = player.play(this, prev);
		discardPile.addCard(next);

		System.out.println(player.getName() + " plays " + next);
		System.out.println();
	}

	public void playGame() {
		Player player = one;

		while (!isDone()) {
			displayState();
			waitForUser();
			takeTurn(player);
			player = nextPlayer(player);
		}

		one.displayFinalScore();
		two.displayFinalScore();
		three.displayFinalScore();
	}

	public static void main(String[] args) {
		EightsCardGame game = new EightsCardGame();
		game.playGame();
	}

}
