import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SudokuGame extends JFrame{

	int[][] gameBoard =
		{{5,3,4,6,7,8,9,1,2},
		{6,7,2,1,9,5,3,4,8},
		{1,9,8,3,4,2,5,6,7},
		{8,5,9,7,6,1,4,2,3},
		{4,2,6,8,5,3,7,9,1},
		{7,1,3,9,2,4,8,5,6},
		{9,6,1,5,3,7,2,8,4},
		{2,8,7,4,1,9,6,3,5},
		{3,4,5,2,8,6,1,7,9}};
			
	boolean[][] hasNum =
		{{true,true,false,false,true,false,false,false,false},
		{true,false,false,true,true,true,false,false,false},
		{false,true,true,false,false,false,false,true,false},
		{true,false,false,false,true,false,false,false,true},
		{true,false,false,true,false,true,false,false,true},
		{true,false,false,false,true,false,false,false,true},
		{false,true,false,false,false,false,true,true,false},
		{false,false,false,true,true,true,false,false,true},
		{false,false,false,false,true,false,false,true,true}};
	
	Button[][] smolBois = new Button[9][9];
	
	// Value user is inputting into a certain square
	private int userInput;
	
	public SudokuGame() {
		super("Sudoku Game");
		Border blackLine = BorderFactory.createLineBorder(Color.white);
		JPanel bigBoiGrid = new JPanel();
		JPanel numGrid = new JPanel(new BorderLayout());
		JPanel massiveBoiPanel = new JPanel();
		bigBoiGrid.setLayout(new GridLayout(3,3));
		numGrid.setLayout(new GridLayout(3,3));
		massiveBoiPanel.setBackground(Color.darkGray);
		massiveBoiPanel.add(bigBoiGrid, BorderLayout.CENTER);
		massiveBoiPanel.add(numGrid, BorderLayout.LINE_END);
		
		// Nested for loops to go through each 3x3 box
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				JPanel outlinePanel = new JPanel();
				outlinePanel.setLayout(new GridLayout(3,3));
				outlinePanel.setBorder(blackLine);
				bigBoiGrid.add(outlinePanel);
				for (int inRow = 0; inRow < 3; inRow++) {
					for (int inCol = 0; inCol < 3; inCol++) {
						// Check square's initial display boolean assign colours of buttons
						if (hasNum[3*row+inRow][3*col+inCol]) {
							Button button = new Button(this, gameBoard[3*row+inRow][3*col+inCol], hasNum[3*row+inRow][3*col+inCol], "black");
							smolBois[3*row+inRow][3*col+inCol] = button;
							outlinePanel.add(button);
						} else {
							Button button = new Button(this, gameBoard[3*row+inRow][3*col+inCol], hasNum[3*row+inRow][3*col+inCol], "gray");
							smolBois[3*row+inRow][3*col+inCol] = button;
							outlinePanel.add(button);
						}	
					}
				}
			}	
		}
		// For loop to add numbers to number pad
		for (int count = 1; count < 10; count++) {
			numButton button = new numButton(this, count);
			numGrid.add(button);
		}
		this.add(massiveBoiPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	// Getter method
	public int getInt() {
		return userInput;
	}
	
	// Setter method
	public void setInt(int input) {
		this.userInput = input;
	}
	
	public boolean hasWon() {
		// Initially true, will turn false if any square is not correct
		boolean win = true;
		for (int row=0; row<9; row++) {
			for (int col=0; col<9; col++) {
				int solutionNum = smolBois[row][col].getActualInt();
				int buttonDispValue = smolBois[row][col].getDispInt();
				if (buttonDispValue != solutionNum) {
					win = false;
				    break; // Stops checking if there is one incorrect
				}
			}
		}
		// Will be true when everything is checked and doesn't turn false
		return win;
	}
	
	// Turns every square's text into an emoji
	public void winLabel() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				String happy = new String(Character.toChars(0x1F60A));
				smolBois[i][j].setText(happy);
			}
		}
	}
	
	public static void main(String[] args) {
		SudokuGame game = new SudokuGame();	
	}
}
