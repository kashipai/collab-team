package EightsGame;

public class Deck extends CardFunc {
	public Deck(String label) {
		super(label);

		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				addCard(new Card(value, suit));
			}
		}
	}

}
