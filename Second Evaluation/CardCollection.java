package javaEvaluation2;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {

  private String cardName;
  private ArrayList<Card> cards = new ArrayList<Card>();
  Random random = new Random();

  public CardCollection(String cName) {
    this.cardName = cName;
  }

  public String getCardName() {
    return cardName;
  }

  public Card getCard(int i) {
    return cards.get(i);
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public Card popCard(int i) {
    return cards.remove(i);
  }

  public Card popCard() {
    int i = cards.size() - 1;
    return popCard(i);
  }

  public int size() {
    return cards.size();
  }

  public boolean empty() {
    return cards.size() == 0;
  }

  public void deal(CardCollection that, int n) {
    for (int i = 0; i < n; i++) {
      Card card = popCard();
      that.addCard(card);
    }
  }
  public void dealAll(CardCollection that) {
    int n = size();
    deal(that, n);
  }

  public Card last() {
    int i = size() - 1;
    return cards.get(i);
  }

  public void shuffle() {
   
    for (int i = cards.size() - 1; i > 0; i--) {
      int j = random.nextInt(i);
      Card temp = cards.get(i);
      cards.set(i, cards.get(j));
      cards.set(j, temp);
    }
  }


  public String toString() {
    return cardName + ": " + cards.toString();
  }


  public void display() {
    System.out.println(cardName + ": ");
    for (Card card: cards) {
      System.out.println(card);
    }
    System.out.println();
  }

}