

public class Blackjack {
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		new BlackjackController(dealer);
	}
}
