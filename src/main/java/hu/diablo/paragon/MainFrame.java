package hu.diablo.paragon;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Setting up the main window.
 * @author Dyingsoul
 */

public class MainFrame extends JFrame {
	/**
	 * Creating new logger.
	 */
	protected static Logger logger = LoggerFactory.getLogger(MainFrame.class);
	
	final JTextField currentLevel = new JTextField();
	final JTextField expPerHour = new JTextField();
	final JTextField desiredLevel = new JTextField();
	final JTextField hoursPlayedPerDay = new JTextField();
	
	/**
	 * Main window for the application.
	 * @param args Arguments.
	 */
	public static void main(String args[]) {
		new MainFrame();
	}
	
	/**
	 * Constructing the main window itself.
	 */
	MainFrame() {
		constructPane();
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setTitle("Paragon Level Calculator");
	}
	
	/**
	 * Constructing the Main window's elements.
	 */
	private void constructPane() {
		logger.info("Constructing main window.");
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(5, 2));
		JButton calculateButton = new JButton("Calculate");

//		final JTextField currentLevel = new JTextField();
//		final JTextField expPerHour = new JTextField();
//		final JTextField desiredLevel = new JTextField();
//		final JTextField hoursPlayedPerDay = new JTextField();

		container.add(new JLabel("Current Level:"));
		container.add(currentLevel);
		container.add(new JLabel("Exp/Hour [in Millions]*:"));
		container.add(expPerHour);
		container.add(new JLabel("Desired Level**:"));
		container.add(desiredLevel);
		container.add(new JLabel("Hours of play per day:"));
		container.add(hoursPlayedPerDay);
		container.add(calculateButton);
		
		/**
		 * Performing the calculations upon pressing the Calculate button.
		 */
		calculateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				logger.info("Calculate button clicked.");		
				if(!isEnteredValuesCorrect()) {
//					CustomDialog calculateDialog = new CustomDialog(getFrame(), "Result", result);
					return;
				}
				
				try {
					ParagonResult result = ParagonCalculator.calculateParagon(
							Integer.parseInt(currentLevel.getText()),
							Integer.parseInt(expPerHour.getText()),
							Integer.parseInt(desiredLevel.getText()),
							Integer.parseInt(hoursPlayedPerDay.getText()));
					CustomDialog calculateDialog = new CustomDialog(getFrame(), "Result", result);
				} catch (Exception e) {
					logger.error("Exception caught!", e);
					System.out.println("Exception:" + e.getMessage());
				}

			}
		});

	}
	
	private boolean isEnteredValuesCorrect() {
		if(currentLevel.getText().isEmpty())
			return false;
		return true;
	}
	
	/**
	 * @return The Main window.
	 */
	private JFrame getFrame() {
		return this;
	}

}
