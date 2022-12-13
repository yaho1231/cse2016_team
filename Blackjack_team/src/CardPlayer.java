
public abstract class CardPlayer implements CardPlayerBehavior {
	
	private Card[] hand;
	private int count;
	
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards];
		count = 0;
	}
	
	public abstract boolean wantsACard();
	public boolean receiveCard(Card c) {
		if (count < hand.length) {
			hand[count] = c;
			count += 1;
			return true;
		}
		
		return false;
	}
	
	public Card[] showCards() {
		Card[] cards = new Card[count];
		for (int i=0; i<cards.length; i++) {
			cards[i] = hand[i];
		}
		return cards;
	}
	
	public int totalScore() {
		int total = 0;
		int rank;

		for (int i=0; i<hand.length && hand[i] != null; i++) {
			rank = hand[i].getRank();
			if (rank == 1) {
				if (total + 11 <= 21)
					total += 11;
				else
					total += 1;
			}
			else {
				if (rank > 10) rank = 10;
				total += rank;
			}
		}
		
		return total;
	}
	
	public void cardsReset(int max_cards) {
		hand = new Card[max_cards];
		count = 0;
	}
	
}
