package EightsGame;

import java.util.Scanner;

public class Game {
	Player one;
	Player two;

	private Hand discardPile;
	private Hand drawPile;

	Scanner sc = new Scanner(System.in);

	public Game() {
		Deck deck = new Deck("Deck");
		deck.shuffleDeck();

		int handSize = 5;
		one = new Player("Player 1");
		deck.deal(one.getHand(), handSize);

		two = new Player("Player 2");
		deck.deal(two.getHand(), handSize);

		discardPile = new Hand("Discards");
		deck.deal(discardPile, 1);

		drawPile = new Hand("Draw pile");
		deck.dealAll(drawPile);

		sc = new Scanner(System.in);

	}

	public void play() {
		Player player = one;

		while (!isDone()) {
			displayState();
			waitForPlayer();
			takeTurn(player);
			player = nextPlayer(player);
		}

		one.displayScore();
		two.displayScore();
	}

	public boolean isDone() {
		return one.getHand().empty() || two.getHand().empty();
	}

	public void displayState() {
		one.display();
		two.display();
		discardPile.display();
		System.out.print("Draw pile: ");
		System.out.println(drawPile.size() + " cards");
	}

	public void waitForPlayer() {
		sc.nextLine();
	}

	public void takeTurn(Player player) {
		Card prev = discardPile.last();
		Card next = player.play(this, prev);
		discardPile.addCard(next);

		System.out.println(player.getName() + " plays " + next);
		System.out.println();
	}

	public Card draw() {
		if (drawPile.empty()) {
			reshuffle();
		}
		return drawPile.popCard();
	}

	public void reshuffle() {
		Card prev = discardPile.popCard();

		discardPile.dealAll(drawPile);

		discardPile.addCard(prev);

		drawPile.shuffleDeck();
	}

	public Player nextPlayer(Player current) {
		if (current == one) {
			return two;
		} else {
			return one;
		}
	}

}
