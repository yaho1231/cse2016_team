import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener{
	private String name;
	private BlackjackController controller;
	
	public Button(String n, BlackjackController c) {
		super(n);
		name = n;
		controller = c;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (name.equals("continue")) {
			controller.firstGame();
		}
		else if (name.equals("hit")) {
			controller.hitted();
		}
		else if (name.equals("stay")){
			controller.stay();
		}
		
	}
	
}
