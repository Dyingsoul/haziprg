import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomDialog extends JDialog implements ActionListener {

	public CustomDialog(JFrame parent, String title, ParagonResult result) {
		super(parent, title, true);

		if (parent != null) {
			setLocationRelativeTo(parent);
		}
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel("Exp to next level: " + (result.getExpNextLevel()).toString()));
		messagePane.add(new JLabel("Hours to next level: " + Integer.toString(result.getHoursNextLevel())));
		messagePane.add(new JLabel("Exp to desired level: " + (result.getExpToDesiredLevel()).toString()));
		messagePane.add(new JLabel("Hours to desired level: " + Integer.toString(result.getHoursToDesiredLevel())));
		messagePane.add(new JLabel("Days to desired level: " + Integer.toString(result.getDaysToDesiredLevel())));
		
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

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}

}