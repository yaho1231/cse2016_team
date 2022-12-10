import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class BlackjackFrame extends JFrame{
	private BlackjackController controller;
	private Button continue_button;
	private Button hit_button;
	private Button stay_button;
	private Card[] cards_player;
	private Card[] cards_dealer;
	private JPanel player_cards_panel;
	private JPanel dealer_cards_panel;
	private JLabel win_who;
	private JLabel player_info;
	
	public BlackjackFrame(BlackjackController c) {
		controller = c;
		continue_button = new Button("continue", controller);
		hit_button = new Button("hit", controller);
		stay_button = new Button("stay", controller);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(5, 1));
		
		// first line setting (Dealer Information)
		JPanel first_line = new JPanel();
		first_line.setLayout(new GridLayout(1,2));
		JLabel dealer_info = new JLabel("Dealer:");
		dealer_info.setFont(new Font("Serif", Font.BOLD, 25));
		dealer_cards_panel = new JPanel();
		dealer_cards_panel.setLayout(new FlowLayout());
		dealer_cards_panel.setFont(new Font("Serif", Font.PLAIN, 20));
		first_line.add(dealer_info);
		first_line.add(dealer_cards_panel);
		
		// second line setting (Player Information)
		JPanel second_line = new JPanel();
		second_line.setLayout(new GridLayout(1,2));
		player_info = new JLabel(controller.playerName()+" (0) ");
		player_info.setFont(new Font("Serif", Font.BOLD, 25));
		player_cards_panel = new JPanel();
		player_cards_panel.setLayout(new FlowLayout());
		player_cards_panel.setFont(new Font("Serif", Font.PLAIN, 20));
		second_line.add(player_info);
		second_line.add(player_cards_panel);
		
		win_who = new JLabel("");

		cp.add(first_line);
		cp.add(second_line);
		cp.add(win_who);	// third line-1
		cp.add(continue_button);	// third line-2
		
		// fourth line setting (hit and stay buttons)
		JPanel fourth_line = new JPanel();
		fourth_line.setLayout(new GridLayout(1,2));
		fourth_line.add(hit_button);
		fourth_line.add(stay_button);
		cp.add(fourth_line);
		
		setTitle("Black Jack");
		setSize(1100, 1000);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void update(String wins) {
		cards_player = controller.getCards("player");
		cards_dealer = controller.getCards("dealer");
		player_cards_panel.removeAll();
		dealer_cards_panel.removeAll();
		
		if (wins.length() > 0)
			win_who.setText(wins+" wins!");
		else
			win_who.setText("");
		
		for (int i=0; i<cards_player.length && cards_player[i] != null; i++) {
			JButton b = new JButton(cards_player[i].getImg());
			b.setPreferredSize(new Dimension(80, 100));
			player_cards_panel.add(b);
		}
		
		for (int i=1; i<cards_dealer.length && cards_dealer[i] != null; i++) {
			JButton b = new JButton(cards_dealer[i].getImg());
			b.setPreferredSize(new Dimension(80, 100));
			dealer_cards_panel.add(b);
		}
		
		if (wins.length() > 0) {
			JButton b = new JButton(cards_dealer[0].getImg());
			b.setPreferredSize(new Dimension(80, 100));
			dealer_cards_panel.add(b);
		}
		
		continue_button.setText("continue");
		hit_button.setText("hit");
		stay_button.setText("stay");
		player_info.setText(controller.playerName()+" ("+controller.playerChips()+") ");
		revalidate();
		repaint();
		setVisible(true);

	}
	
	public Button getStayButton() {
		return stay_button;
	}
	
	public Button getHitButton() {
		return hit_button;
	}
	
}
