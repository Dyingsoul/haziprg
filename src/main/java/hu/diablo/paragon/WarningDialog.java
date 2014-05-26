package hu.diablo.paragon;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>CustomDialog</code> is for displaying the result.
 * @author Dyingsoul
 */
public class WarningDialog extends JDialog implements ActionListener {
	/**
	 * Creating new logger: <code>Logger</code>.
	 */
	protected static Logger logger = LoggerFactory.getLogger(MainFrame.class);
	
	/**
	 * Constructing the <code>WarningDialog</code> made for displaying a warning message if the input is not correct.
	 * @param parent <code>parent</code> is the parent window.
	 * @param title <code>title</code> is for setting the title of the Custom Dialog.
	 * @param error <code>error</code> stores the error code.
	 */
	public WarningDialog(JFrame parent, String title, int error) {
		super(parent, title, true);

		if (parent != null) {
			setLocationRelativeTo(parent);
		}
		JPanel messagePane = new JPanel();
		
		if (error == 1)
			messagePane.add(new JLabel("Error "+ error + ": One or more of the input fields are empty!"));
		if (error == 2)
			messagePane.add(new JLabel("Error "+ error + ": The input must be a number!"));
		if (error == 3)
			messagePane.add(new JLabel("Error "+ error + ": One or more of the input fields are not positive number(s)!"));
		if (error == 4)
			messagePane.add(new JLabel("Error "+ error + ": The current level is higher than desired level!"));
		if (error == 5)
			messagePane.add(new JLabel("Error "+ error + ": The current level or the desired level is out of range (range: 0-1500)!"));
		
		
		getContentPane().add(messagePane);
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("OK");
		buttonPane.add(button);
		button.addActionListener(this);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * For disposing the <code>CustomDialog</code>.
	 * @param e Action <code>e</code> that performs the disposal.
	 */
	public void actionPerformed(ActionEvent e) {
		logger.info("OK button clicked, action performed, disposing Custom Dialog.",e);
		setVisible(false);
		dispose();
	}

}