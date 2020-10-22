package javaEvaluation2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrazyEights {

  private CardCollection drawPile;
  private CardCollection discardPile;
  private Scanner in = new Scanner(System.in);;
  private ArrayList<Hand> players;

  public CrazyEights() {
    Deck deck = new Deck("Deck");
    deck.addCardsToDeck();
    deck.shuffle();

    this.players = new ArrayList<Hand>();

    discardPile = new CardCollection("Discards");
    deck.deal(discardPile, 1);

    drawPile = new CardCollection("Draw pile");
    deck.dealAll(drawPile);
  }

  public void createPlayer(Hand player) {
    players.add(player);
  }

  public String playerName() {
    System.out.println("Enter player name: ");
    String name = in.next();
    while (name == "") {
      name = in.nextLine();
    }
    return name;
  }

  public void equipPlayer() {
    Hand player = new Hand(playerName());
    createPlayer(player);
    drawPile.deal(player.getHand(), 5);
  }

  public Hand getPlayer(int i) {
    return players.get(i);
  }

  public int getPlayerIndex(Hand player) {
    return players.indexOf(player);
  }

  public boolean isDone() {
    for (int x = 0; x < players.size(); x++) {
      if (getPlayer(x).getHand().empty()) {
        return true;
      }
    }
    return false;
  }

  public void reshuffle() {
    
    Card convert = discardPile.popCard();
    Pile prev = new Pile(0, 0);
    prev = prev.convert(convert);
    
    discardPile.dealAll(drawPile);
    discardPile.addCard(prev);
    
    drawPile.shuffle();
  }

  public Pile draw() {
    if (drawPile.empty()) {
      reshuffle();
    }
    Card convert = drawPile.popCard();
    Pile prev = new Pile(0, 0);
    return prev.convert(convert);
  }


  public Hand nextPlayer(Hand current) {

    if (getPlayerIndex(current) < players.size() - 1) {
      return getPlayer(getPlayerIndex(current) + 1);
    }
    if (getPlayerIndex(current) == players.size() - 1) {
      return getPlayer(getPlayerIndex(current) + 1 - players.size());
    }
    return null;

  }

  public void displayState() {
    for (int x = 0; x < players.size(); x++) {
      getPlayer(x).display();
    }
    
    discardPile.display();
    
    System.out.print("Draw pile now has "+ drawPile.size() + " cards\n");
  }

  public void takeTurn(Hand player) {
    Card convert = discardPile.last();
    Pile prev = new Pile(0, 0);
    prev = prev.convert(convert);    
    Pile next = player.play(this, prev);
    discardPile.addCard(next);

    System.out.println(player.getName() + " plays " + next);
    System.out.println();
  }

  public void playGame() {

    System.out.println("-------CRAZY EIGHTS-------");
    System.out.println();
      System.out.println("Press [ENTER] key to start the game");
      in.nextLine();
    
    System.out.println("Enter number of players: ");

    int nop = in.nextInt();
    while (nop < 2) {
      System.err.println("Number of players must be greater than or equal to 2");
      System.out.println();
      System.out.println("Re-enter number of players: ");
      nop = in.nextInt();
    }

    for (int i = 0; i < nop; i++) {
      equipPlayer();
    }
    Hand player = getPlayer(0);
    
    while (!isDone()) {
      displayState();
      System.out.print("Press [ENTER] key to play your turn");
      in.nextLine();
      takeTurn(player);
      player = nextPlayer(player);
    }
    
    System.out.println("Scores of each player is as folllows:\n");
    for (int x = 0; x < players.size(); x++) {
    	System.out.print(x+1+")");
    	getPlayer(x).displayWinner();
    	getPlayer(x).displayScores();
    }
  }

  public static void main(String[] args) {
	  try {
		  CrazyEights game = new CrazyEights();
		  game.playGame();
	  }
	  catch(InputMismatchException ime)
	  {
		 System.out.println(ime.getMessage());
	  }

  }
}
