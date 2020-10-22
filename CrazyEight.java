package secondEvaluation;

import java.util.ArrayList;
import java.util.Scanner;

public class CrazyEight {
  private CardCollection deck;
  private CardCollection drawPile;
  private CardCollection discardPile;
  private Scanner in;
  private ArrayList<Player> players;

  public CrazyEight() {
    deck = new Deck("Deck");
    deck.shuffle();

    this.players = new ArrayList<Player>();

    discardPile = new CardCollection("Discard Pile");
    deck.deal(discardPile, 1);

    drawPile = new CardCollection("Draw pile");
    deck.dealAll(drawPile);

    in = new Scanner(System.in);
  }

	public void setPlayers() {
		System.out.println("Enter player name: ");
		String name = in.next();
		while (name == "") {
			name = in.nextLine();
		}
		Player player = new Player(name);
		players.add(player);
		drawPile.deal(player.getHand(), 8);
	}

  public Player getPlayer(int i) {
    return players.get(i);
  }

  public int getPlayerTurn(Player player) {
    return players.indexOf(player);
  }

  public boolean isDone() {
    for (int i = 0; i < players.size(); i++) {
      if (getPlayer(i).getHand().size()==0) {
        return true;
      }
    }
    return false;
  }

  public void reshuffle() {
    Card topCard = discardPile.removeLastCard();
    discardPile.dealAll(drawPile);
    discardPile.addCard(topCard);
    drawPile.shuffle();
  }

  public Card draw() {
    if (drawPile.size()==0) {
      reshuffle();
    }
    Card convert = drawPile.removeLastCard();
    return convert;
  }

  public void displayState() {
    for (int i = 0; i < players.size(); i++) {
      getPlayer(i).display();
    }
    System.out.println("\n"+discardPile.toString());
    System.out.println("Draw pile: "+drawPile.size() + " cards");
  }

  public void waitForUser() {
    in.nextLine();
  }

  public void takeTurn(Player player) {
    Card convert = discardPile.lastCard();
    Card next = player.play(this, convert);
    discardPile.addCard(next);
    System.out.println(player.getName() + " plays " + next);
    System.out.println();
  }

	public Player nextPlayer(Player current) {

		if (getPlayerTurn(current) < players.size() - 1) {
			return getPlayer(getPlayerTurn(current) + 1);
		}
		if (getPlayerTurn(current) == players.size() - 1) {
			return getPlayer(getPlayerTurn(current) + 1 - players.size());
		}
		return null;
	}

  public void startGame() {
    System.out.println("Welcome to Crazy Eights!!");
    System.out.println();
    System.out.println("Enter number of players: ");
    int noOfPlayers = in.nextInt();
    while (noOfPlayers > 5 || noOfPlayers < 2) {
      System.out.println("Number of players must be between 2 and 5");
      System.out.println();
      System.out.println("Please re enter number of players: ");
      noOfPlayers = in.nextInt();
    }

    for (int i = 0; i < noOfPlayers; i++) {
      setPlayers();
    }
    Player player = getPlayer(0);

    while (!isDone()) {
      displayState();
      waitForUser();
      takeTurn(player);
      player = nextPlayer(player);
    }
	System.out.println("Game Ended!!");
	for (int i = 0; i < players.size(); i++) {
		if (getPlayer(i).score()==0 )
			System.out.println("\n" + getPlayer(i).getName()+" Won!!");
	}
	System.out.println("\nScores:");
	for (int i = 0; i < players.size(); i++) {
		getPlayer(i).displayScore();
	}

}

  public static void main(String[] args) {
    CrazyEight game = new CrazyEight();
    game.startGame();

  }
}
