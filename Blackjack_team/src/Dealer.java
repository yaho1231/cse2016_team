

public class Dealer {
	CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
	}
	
	public void dealTo(CardPlayerBehavior p) {
		do {
			Card c = deck.newCard();
			p.receiveCard(c);
		} while(p.wantsACard());
	}
	
	public void dealOneTo(CardPlayerBehavior p) {
		Card c = deck.newCard();
		p.receiveCard(c);
	}
}
