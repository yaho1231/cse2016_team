import javax.swing.*;
import java.awt.*;

public class InfoLabel extends JLabel {
	public InfoLabel(String text, int x, int y) {
		super(text);
		setBounds(x,y,150,30);
		setFont(new Font("Serif", 1, 25));
		setForeground(Color.WHITE);
	}
}
