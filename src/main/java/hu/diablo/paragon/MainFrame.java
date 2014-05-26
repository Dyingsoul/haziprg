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
 * Setting up the main window: <code>MainFrame</code>.
 * @author Dyingsoul
 */

public class MainFrame extends JFrame {
	/**
	 * Creating new logger: <code>Logger</code>.
	 */
	protected static Logger logger = LoggerFactory.getLogger(MainFrame.class);
	
	private int error = 0;
	
	final JTextField currentLevel = new JTextField();
	final JTextField expPerHour = new JTextField();
	final JTextField desiredLevel = new JTextField();
	final JTextField hoursPlayedPerDay = new JTextField();
	
	/**
	 * Main window for the application: <code>MainFrame</code>.
	 * @param args Arguments.
	 */
	public static void main(String args[]) {
		new MainFrame();
	}
	
	/**
	 * Constructing the main window itself: <code>MainFrame()</code>.
	 */
	MainFrame() {
		constructPane();
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setTitle("Paragon Level Calculator");
	}
	
	/**
	 * <code>constructPane</code> is for constructing the Main window's elements.
	 */
	private void constructPane() {
		logger.info("Constructing main window.");
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(5, 2));
		JButton calculateButton = new JButton("Calculate");

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
				if(!isEnteredValuesNotEmpty()) {
					logger.info("One or more of the input fields are empty!");
					WarningDialog warnDialog = new WarningDialog(getFrame(), "Warning!", error);
					return;
				}
				
				if(!isEnteredValuesNumbers()) {
					logger.info("The input must be a number!");
					WarningDialog warnDialog = new WarningDialog(getFrame(), "Warning!", error);
					return;
				}
				
				if (!isEnteredValuesPositiveNumber()){
					logger.info("One or more of the input fields are not positive number(s)!");
					WarningDialog warnDialog = new WarningDialog(getFrame(), "Warning!", error);
					return;
				}
				
				if(!isDesiredHigherThanCurrent()){
					logger.info("The current level is higher than desired level!");
					WarningDialog warnDialog = new WarningDialog(getFrame(), "Warning!", error);
					return;
				}
				
				if(!isNotOutOfRange()){
					logger.info("The current level or the desired level is out of range (range: 0-1500)!");
					WarningDialog warnDialog = new WarningDialog(getFrame(), "Warning!", error);
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
	
	/**
	 * <code>isEnteredValuesNotEmpty</code> is checking if any of the fields are empty.
	 * @return <code>false</code> if there are empty fields, <code>true</code> if they are filled.
	 */
	private boolean isEnteredValuesNotEmpty() {
		if(currentLevel.getText().isEmpty() || expPerHour.getText().isEmpty() || desiredLevel.getText().isEmpty() || hoursPlayedPerDay.getText().isEmpty() ){
			error = 1;
			return false;
		}
		return true;
	}
	
	/**
	 * <code>isEnteredValuesNumbers</code> is checking the fields for numeric data.
	 * @return <code>false</code> if the entered value is not a number, <code>true</code> if it is a number.
	 */
	private boolean isEnteredValuesNumbers() {
		if(!isNum(currentLevel.getText()) || !isNum(expPerHour.getText()) || !isNum(desiredLevel.getText()) || !isNum(hoursPlayedPerDay.getText()) ){
			error = 2;
			return false;
		}
		return true;
	}
	
	/**
	 * <code>isEnteredValuesPositiveNumber</code> is checking the fields for positive numbers.
	 * @return <code>false</code>, if the number is negative, <code>true</code> if it is a positive number.
	 */
	private boolean isEnteredValuesPositiveNumber() {
		if(Math.signum(Integer.parseInt(currentLevel.getText())) == -1.0  || Math.signum(Integer.parseInt(expPerHour.getText())) == -1.0 || Math.signum(Integer.parseInt(desiredLevel.getText())) == -1.0 || Math.signum(Integer.parseInt(hoursPlayedPerDay.getText())) == -1.0){
			error = 3;
			return false;
		}
		return true;
	}
	
	/**
	 * <code>isDesiredHigherThanCurrent</code> is telling if the desired level is lower than current level.
	 * @return <code>false</code> if the desired level is lower than current level, returns <code>true</code> if it is higher.
	 */
	private boolean isDesiredHigherThanCurrent() {
		if(Integer.parseInt(currentLevel.getText()) > Integer.parseInt(desiredLevel.getText())){
			error = 4;
			return false;
		}
		return true;
	}
	
	/**
	 * <code>isNotOutOfRange</code> is checking if the user enters invalid level range to calculate.
	 * @return <code>false</code> if the level's range is invalid, returns <code>true</code> if it is valid.
	 */
	private boolean isNotOutOfRange() {
		if(Integer.parseInt(currentLevel.getText()) >= 1501 || Integer.parseInt(desiredLevel.getText()) >= 1501){
			error = 5;
			return false;
		}
		return true;
	}
	
	/**
	 * Method <code>isNum</code> checks if the String is Numeric or not
	 * @param strNum is the String to check.
	 * @return <code>true</code> if the String is Numeric, <code>false</code> if it is not.
	 */
	private static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {

	        Double.parseDouble(strNum);

	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
	
	/**
	 * @return The Main window.
	 */
	private JFrame getFrame() {
		return this;
	}

}
