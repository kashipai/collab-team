import java.util.ArrayList;
import java.util.Scanner;

public class Eights {

    private Hand drawPile;
    private Hand discardPile;
    private final Scanner in;
    private Player[] players;
    private int currentPlayer = 0;
    private int numofPlayer;


    public Eights() {
        in = new Scanner(System.in);
        Deck deck = new Deck("Deck");
        deck.shuffle();

        System.out.println("Enter the number of Player between 2 and 5");
        numofPlayer = in.nextInt();
        if (numofPlayer < 2 || numofPlayer > 5) {
            System.out.println("Invalid number of Players");
            System.exit(1);
        } else {
            int handSize = 5;
            players = new Player[numofPlayer];
            for (int i = 0; i < numofPlayer; i++) {
                System.out.println("Enter the Name of Player " + (i + 1));
                String name = in.next();
                players[i] = new Player(name);
                deck.deal(players[i].getHand(), handSize);
            }

            // turn one card face up
            discardPile = new Hand("Discard pile");
            deck.deal(discardPile, 1);

            // put the rest of the deck face down
            drawPile = new Hand("Draw pile");
            deck.dealAll(drawPile);
        }

    }

    //Returns true if player hand is empty.
    public boolean isDone(Player player) {
        return player.getHand().empty();
    }


    //Switches players.
    public Player nextPlayer(int current) {
        if (current == numofPlayer - 1) {
            currentPlayer = 0;
        } else {
            currentPlayer++;
        }
        return players[currentPlayer];
    }

    //Moves cards from the discard pile to the draw pile and shuffles.
    public void reshuffle() {
        Card prev = discardPile.popCard();
        discardPile.dealAll(drawPile);
        discardPile.addCard(prev);
        drawPile.shuffle();
    }

    //Returns a card from the draw pile.
    public Card draw() {
        if (drawPile.empty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    //Displays the state of the hand.
    public void displayState(Player player) {
        player.display();
        discardPile.displaysLatestCard();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
    }

    //One player takes a turn.
    public void takeTurn(Player player) {
        System.out.println();
        System.out.println(player.getName() + "'s turn");
        System.out.flush();
        Card prev = discardPile.last();
        check(player, prev);
    }

    public void check(Player player, Card prev) {
        ArrayList<Card> list =  player.searchForMatch(prev);
        if (list.size() == 0) {
            System.out.println("No Card found");
            player.drawForMatch(this, prev);
            player.display();
            // To show the latest card
            discardPile.displaysLatestCard();
            check(player, prev);
        } else {
            System.out.println("Available cards for discard ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(+(i + 1) + ":" + list.get(i));
            }
            System.out.println("Enter the  card index to be discard");
            int cardindex = in.nextInt();
            if (cardindex - 1 > list.size() - 1) {
                System.out.println("Enter correct Index");
                check(player, prev);
            } else {
                discardCard(player, list, cardindex);
            }
        }
    }

    public void discardCard(Player player, ArrayList<Card> list, int cardIndex) {
        discardPile.addCard(list.get(cardIndex - 1));
        player.removePlayCard(list.get(cardIndex - 1));
        System.out.println(player.getName() + " plays " + list.get(cardIndex - 1));
        System.out.println();
    }

    //Plays the game.
    public void playGame() {
        Player player = players[currentPlayer];
        boolean flag = false;
        // keep playing until there's a winner
        while (!flag) {
            displayState(player);
            takeTurn(player);
            flag = isDone(player);
            player = nextPlayer(currentPlayer);

        }
        System.out.println();
        for (int i = 0; i < numofPlayer; i++) {
            players[i].displayScore();
        }
    }

    public static void main(String[] args) {
        Eights game = new Eights();
        game.playGame();
    }

}