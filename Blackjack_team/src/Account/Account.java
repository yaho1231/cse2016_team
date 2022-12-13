package account;

public class Account {
	private String id;
	private int score;

	public Account(String id, int score) {
		this.id = id;
		this.score = score;
	}

	public String id() {
		return id;
	}
	public int score() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}