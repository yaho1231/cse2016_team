import javax.swing.ImageIcon;
import java.awt.Image;

public class Card {
	
	public static final String SPADES = "spades";
	public static final String HEARTS = "hearts";
	public static final String DIAMONDS = "diamonds";
	public static final String CLUBS = "clubs";
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static final int SIZE_OF_ONE_SUIT = 13;
	
	private String suit;
	private int rank;

	/** Constructor - Card의 무의와 등급을 설정 
	 * @param s - 무늬 
	 * @param r - 등급  */
	public Card(String s, int r) { 
		suit = s;
		rank = r;
	}

	/** getSuit - 카드의 무늬 리턴 */ 
	public String getSuit() { 
		return suit; 
	}
	
	/** getCount - 카드의 등급 리턴 */ 
	public int getRank() { 
		return rank; 
	}
	
	public ImageIcon getImg() {
		ImageIcon imgIcon;
		if (rank == 1)
			imgIcon = new ImageIcon("images/ace_of_"+suit+".png");
		else if (rank == 11)
			imgIcon = new ImageIcon("images/jack_of_"+suit+".png");
		else if (rank == 12)
			imgIcon = new ImageIcon("images/queen_of_"+suit+".png");
		else if (rank == 13)
			imgIcon = new ImageIcon("images/king_of_"+suit+".png");
		else
			imgIcon = new ImageIcon("images/"+Integer.toString(rank)+"_of_"+suit+".png");
		Image resized_img = (imgIcon.getImage()).getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(resized_img);
	}
	
}
