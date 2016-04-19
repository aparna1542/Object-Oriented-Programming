package swings.thread;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.event.*;

public class LongRunTask {
	private static JButton startBtn = new JButton("Start");
	private static JButton show = new JButton("Show");
	private static JTextField tf = new JTextField(10);
	private static JLabel label = new JLabel("Ready", JLabel.CENTER);

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(startBtn);
		panel.add(show);
		panel.add(tf);
		Container c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel, BorderLayout.CENTER);
		c.add(label, BorderLayout.SOUTH);
		startBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				label.setText("Working ...");
				startBtn.setEnabled(false);
				// Simulating a long running task by calling sleep()
				SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {

					@Override
					protected Boolean doInBackground() throws Exception {
						try {
							//throw new InterruptedException();
							Thread.sleep(5000);
						} catch (InterruptedException ex) {
							//Thread.sleep(5000);
							return false;

						}
						return true;
					}

					@Override
					protected void done() {
						Boolean status = false;
						try {
							status = get();

						} catch (InterruptedException e) {

							e.printStackTrace();
						} catch (ExecutionException e) {

							e.printStackTrace();
						}
						if (status) {
							// After sleep
							label.setText("...Ready");

						} else {
							label.setText("...Not Ready");
						}
						startBtn.setEnabled(true);

					}

					@Override
					protected void process(List<Void> chunks) {
						
						super.process(chunks);
					}

				};
				worker.execute();

			}// end of actionPerformed
		});// end startBtn.addActionListener()
			// and the anonymous class

		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tf.setText("Show");
			}
		});// end show.addActionListener() and the anonymous class
		mainFrame.setSize(300, 200);
		mainFrame.setVisible(true);

	}// end - main

}