package team;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
	private String name;
	private BlackjackController controller;
	private ImageIcon image;

	public Button(String n, String img, BlackjackController c) {
		super(n);
		this.name = n;
		this.image = new ImageIcon(img);
		this.setIcon(this.image);
		this.controller = c;
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (name.equals("continue")) {
			controller.firstGame();
		} else if (name.equals("")) {
			this.controller.hitted();
		} else if (name.equals("stay")) {
			this.controller.stay();
		}

	}
}