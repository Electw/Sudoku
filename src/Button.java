import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton {
	
	private int num;
	private boolean vis;
	private int displayNum;
	
	public Button(SudokuGame game, int number, boolean visible, String colour) {
		this.num = number;
		this.vis = visible;
		this.addActionListener(new TileClickHandler(game));
		this.setPreferredSize(new Dimension(80,80));
		this.setFont(new Font("sans-serif", Font.PLAIN, 36));
		this.setForeground(Color.white);
		if (colour == "black") {
			this.setBackground(Color.black);
		} else if (colour == "gray") {
			this.setBackground(Color.darkGray);
		}
		if (vis == true && num != 0) {
			this.setText(Integer.toString(num));
			this.displayNum = num;
		} 
	}
	
	// Getter for display integer
	public int getDispInt() {
		return this.displayNum;
	}

	// Getter for the actual integer of the button
	public int getActualInt() {
		return this.num;
	}
	
	// Setter for the display integer
	public void setDispInt(int input) {
		if (!vis) {
			this.displayNum = input;
			this.setText(Integer.toString(input));
		}	
	}
	
}
