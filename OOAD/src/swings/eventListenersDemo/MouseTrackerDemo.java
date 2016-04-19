package swings.eventListenersDemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* This program illustrates the usage of Event Adapters and inner classes to
 *  handle events. Adapter classes implement a particular listener interface and
 *   provide the method stubs. A class can extend from an Adapter class and provide
 *   the implementation for the required methods. Since, a class may already extend
 *   from another class, it can use an extended Adapter class as an inner class.
 */
public class MouseTrackerDemo extends JFrame {

	private JLabel xLabel, yLabel;
	private MouseEventAdapterA meaA;

	public MouseTrackerDemo() {
		super("MouseTrackerDemo");
		setSize(500, 500);
		xLabel = new JLabel();
		yLabel = new JLabel();
		Container container = getContentPane();
		container.add(xLabel, BorderLayout.EAST);
		container.add(yLabel, BorderLayout.WEST);

		// An instance of MouseAdapter listens to the mouse events
		addMouseListener(new MouseEventAdapterA());
		setVisible(true);
	}// constructor ends here

	// Define an inner class to handle the Mouse Events
	class MouseEventAdapterA extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();
			yLabel.setText("Y coordinate :" + y + " ");
			xLabel.setText("X coordinate : " + x + " ");
		}
	}

	public static void main(String[] args) {
		MouseTrackerDemo application = new MouseTrackerDemo();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
