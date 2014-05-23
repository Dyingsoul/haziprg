import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	public static void main(String args[]) {
		// Main window of the application.
		new MainFrame();
	}

	MainFrame() {
		constructPane();
		this.setSize(500, 500);
		// pack();
		// Stop running when hitting red X.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// Setting the Title.
		this.setTitle("Paragon Level Calculator");
	}

	private void constructPane() {
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(5, 2));
		JButton calculateButton = new JButton("Calculate");

		final JTextField currentLevel = new JTextField();
		final JTextField expPerHour = new JTextField();
		final JTextField desiredLevel = new JTextField();
		final JTextField hoursPlayedPerDay = new JTextField();

		container.add(new JLabel("Current Level:"));
		container.add(currentLevel);
		container.add(new JLabel("Exp/Hour [in Millions]*:"));
		container.add(expPerHour);
		container.add(new JLabel("Desired Level**:"));
		container.add(desiredLevel);
		container.add(new JLabel("Hours of play per day:"));
		container.add(hoursPlayedPerDay);
		container.add(calculateButton);

		calculateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					ParagonResult result = ParagonCalculator.calculateParagon(
							Integer.parseInt(currentLevel.getText()),
							Integer.parseInt(expPerHour.getText()),
							Integer.parseInt(desiredLevel.getText()),
							Integer.parseInt(hoursPlayedPerDay.getText()));
					CustomDialog calculateDialog = new CustomDialog(getFrame(), "Result", result);
				} catch (Exception e) {
					System.out.println("Exception:" + e.getMessage());
				}

			}
		});

	}

	private JFrame getFrame() {
		return this;
	}

}
