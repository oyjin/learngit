package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwintTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		JButton button = new JButton("button");
		frame.add(button);
		
		frame.setSize(200, 200);
		frame.setVisible(true);

	}

}
