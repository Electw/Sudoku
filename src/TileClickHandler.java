import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class TileClickHandler implements ActionListener {
	
	private SudokuGame game;

	public TileClickHandler(SudokuGame game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton b1 = (JButton)ae.getSource();
		// Check if the action was on a Button or numButton
		if (b1 instanceof Button) {
			Button b = (Button)b1;
			b.setDispInt(game.getInt());
			if (game.hasWon()) {
				// Turn each square into a smiling emoji
				game.winLabel();
				// Option pane to notify player of win
				JOptionPane pane = new JOptionPane("Congratulations, you win! Now close both windows.", JOptionPane.PLAIN_MESSAGE);
				JDialog dialog = pane.createDialog("You win");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			}
		} else {
			numButton nb = (numButton)b1;
			int numPadValue = nb.getInt();
			game.setInt(numPadValue);
		}
	}
}