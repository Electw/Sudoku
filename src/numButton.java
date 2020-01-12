import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class numButton extends JButton{
	
	private int num;
	
	public numButton(SudokuGame game, int number) {
		this.num = number;
		
		this.addActionListener(new TileClickHandler(game));
		this.setPreferredSize(new Dimension(80,80));
		this.setBackground(Color.gray);
		this.setFont(new Font("sans-serif", Font.PLAIN, 36));
		this.setForeground(Color.white);
		this.setText(Integer.toString(num));
	}

	// Getter method
	public int getInt() {
		return this.num;
	}
}
