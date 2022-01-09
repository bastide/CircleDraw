package circledraw;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Application {
	boolean packFrame = true;

	/**Construct the application*/
	public Application() {
		JFrame frame = new JFrame() {
			/**Overridden so we can exit when window is closed*/
			protected void processWindowEvent(WindowEvent e) {
				super.processWindowEvent(e);
				if (e.getID() == WindowEvent.WINDOW_CLOSING) {
					System.exit(0);
				}
			}
		};
		frame.setTitle("Circle Draw");
		frame.getContentPane().add(new CircleDrawPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
