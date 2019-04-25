package guiBased;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Game extends JPanel {
	private int numOfPlayers;
//	private Players[] players;
	/**
	 * Create the panel.
	 */
	public Game() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
		numOfPlayers = 0;
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public void setNumOfPlayers(int num) {
		numOfPlayers = num;
	}
}
