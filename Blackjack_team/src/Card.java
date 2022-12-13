

import javax.swing.ImageIcon;
import java.awt.Image;

public class Card {
	
	public static final String SPADES = "SPADE";
	public static final String HEARTS = "HEART";
	public static final String DIAMONDS = "DIAMOND";
	public static final String CLUBS = "CLUB";
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static final int SIZE_OF_ONE_SUIT = 13;
	
	private String suit;
	private int rank;

	/** Constructor - Card�� 臾댁���� �깃��� �ㅼ�� 
	 * @param s - 臾대�� 
	 * @param r - �깃�  */
	public Card(String s, int r) { 
		suit = s;
		rank = r;
	}

	/** getSuit - 移대���� 臾대�� 由ы�� */ 
	public String getSuit() { 
		return suit; 
	}
	
	/** getCount - 移대���� �깃� 由ы�� */ 
	public int getRank() { 
		return rank; 
	}
	
	public ImageIcon getImg() {
		ImageIcon imgIcon;
		imgIcon = new ImageIcon(".//cardimage//"+suit+"-"+Integer.toString(rank)+".png");
		Image resized_img = (imgIcon.getImage()).getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
		
		return new ImageIcon(resized_img);
	}
	
}