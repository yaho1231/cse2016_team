package team;

public class ComputerPlayer extends CardPlayer {
	
	public ComputerPlayer(int max_cards) {
		super(max_cards);
	}

	public boolean wantsACard() {
		return false;
	}
}
