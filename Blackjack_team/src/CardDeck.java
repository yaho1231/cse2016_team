
public class CardDeck {
	
	private int card_count; // �⑥�� 移대�� �� 
	private Card[] deck = new Card[4 * Card.SIZE_OF_ONE_SUIT];
	// Invariant: deck[0], .., decl[card_count-1] �� 移대��媛� ����. 
	
	/** Constructor - CardDeck 移대�� �� 踰� ����  */ 
	public CardDeck() { 
		createDeck();
	}
	
	/** createSuit - 二쇱�댁� 臾대�щ� 移대�� 13�� ����  */ 
	private void createSuit(String which_suit) {
		for(int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i++) {
			deck[card_count] = new Card(which_suit, i); 
			card_count = card_count + 1;
		} 
	}
	
	private void createDeck() {
		createSuit(Card.SPADES);
		createSuit(Card.HEARTS); 
		createSuit(Card.CLUBS); 
		createSuit(Card.DIAMONDS);
	}
	
	/** newCard - ������ �� 移대�� �� �μ�� 戮��� 以�
	* @return 移대�� �깆���� ����濡� �� �μ�� 戮��� 由ы�� 
	*         ���쇰㈃ 移대�� 1踰��� ��濡� 留��ㅺ� �� �μ�� 戮��� 由ы��   */
	public Card newCard() { 
		if (! this.moreCards()) 
			createDeck();
		int index = (int)(Math.random() * card_count);
		Card card_to_deal = deck[index];
		for (int i = index+1; i < card_count; i++)
			deck[i-1] = deck[i];
		card_count = card_count - 1;
		return card_to_deal;
	}
	
	/** moreCards - 移대�� �깆�� 移대��媛� �⑥������吏� ���ㅼ�  
	 * @return ���쇰㈃ true, ���쇰㈃ false */
	public boolean moreCards() { 
		return card_count > 0; 
	}

}