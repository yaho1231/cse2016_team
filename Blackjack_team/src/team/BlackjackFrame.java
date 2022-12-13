package team;

import javax.swing.*;

import java.awt.*;

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
	private JLabel dealer_info;
	private JLabel name_info;
	private JLabel chip_info;
	
	public BlackjackFrame(BlackjackController c) {
		controller = c;
		continue_button = new Button("continue", null, controller);
//		hit_button = new Button("", ".//cardimage//card-back.png", controller);
		stay_button = new Button("stay", null, controller);
		Color board_green = new Color(1, 102, 52);
		Color deck_green = new Color(0, 75, 37);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		dealer_cards_panel = new JPanel();
		cp.add(dealer_cards_panel, "North");
		dealer_cards_panel.setLayout(new FlowLayout());
		dealer_cards_panel.setBackground(deck_green);

		player_cards_panel = new JPanel();
		cp.add(player_cards_panel, "South");
		player_cards_panel.setLayout(new FlowLayout());
		player_cards_panel.setBackground(deck_green);

		JPanel control_area = new JPanel();
		cp.add(control_area, "Center");
		control_area.setLayout(null);
		control_area.setBackground(board_green);

		hit_button = new Button("", ".//cardimage//card-back.png", controller);
		hit_button.setBounds(242, 110, 100, 140);
		control_area.add(hit_button);

		continue_button = new Button("continue", null, controller);
		continue_button.setBounds(423, 280, 150, 30);
		control_area.add(continue_button);

		stay_button = new Button("stay", null, controller);
		stay_button.setBounds(423, 320, 150, 30);
		control_area.add(stay_button);

		player_info = new InfoLabel("Player", 10,320);
		control_area.add(player_info);

		dealer_info = new InfoLabel("Dealer", 10,5);
		control_area.add(dealer_info);

		name_info = new InfoLabel(controller.playerName(), 450, 35);
		control_area.add(name_info);

		chip_info = new InfoLabel("Chips: " + controller.playerChips(), 450, 5);
		control_area.add(chip_info);

		win_who = new InfoLabel("", 10, 162);
		control_area.add(win_who);

//		dealer_cards_panel.add(new JLabel(new ImageIcon(".\\cardimage\\SPADE-1.png")));
//		player_cards_panel.add(new JLabel(new ImageIcon(".\\cardimage\\SPADE-1.png")));
//		player_cards_panel.add(new JLabel(new ImageIcon("card-back.png")));

		setSize(600, 700);
		setTitle("Black Jack");
		setVisible(true);
		setDefaultCloseOperation(3);
		setResizable(false);
	}
	
	public void update(String wins) {
		cards_player = controller.getCards("player");
		cards_dealer = controller.getCards("dealer");
		player_cards_panel.removeAll();
		dealer_cards_panel.removeAll();

		player_info.setText("Player: " + controller.playerScore());
		chip_info.setText("Chips: " + controller.playerChips());

		for (Card card : cards_player) {
			// player_cards_panel.add(new JLabel(card.getImg()));
			player_cards_panel.add(new JLabel(card.getImg()));
		}

		// match not end
		if (wins.equals("")){
			// dealer_cards_panel.add(new JLabel(cards_dealer[0].getImg()));
//			dealer_cards_panel.add(new JLabel(cards_dealer[0].getSuit() + cards_dealer[0].getRank()));
			dealer_cards_panel.add(new JLabel(cards_dealer[0].getImg()));
			dealer_info.setText("Dealer: ??");
			win_who.setText("");
		}
		// match end
		else {
			for (Card card : cards_dealer) {
				//dealer_cards_panel.add(new JLabel(card.getImg()));
				dealer_cards_panel.add(new JLabel(card.getImg()));
			}
			dealer_info.setText("Dealer: " + controller.dealerScore());
			win_who.setText(wins + " wins!");
		}
		repaint();
	}
	
	public Button getStayButton() {
		return stay_button;
	}
	
	public Button getHitButton() {
		return hit_button;
	}
	
}
