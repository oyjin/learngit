package swing;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class AwtTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		frame.setLayout(new FlowLayout());
		Button button = new Button("button");
		frame.add(button);
		
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

}
