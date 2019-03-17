import java.util.Random;

public class Player {
	private String name;
	private int boardSpot;
	private int die1, die2;
	
	public String name() {
		return name;
	}
	
	public int spot() {
		return boardSpot;
	}
	
	public Player(String name) {
		this.name = name;
		boardSpot = 0;
		die1 = die2 = 0;
	}
	
	public void rollDice() {
		Random dice = new Random(System.currentTimeMillis());
		die1 = dice.nextInt(6) + 1;
		die2 = dice.nextInt(6) + 1;
		boardSpot += die1 + die2;
		boardSpot %= Game.spots;
	}
	
	public void reset() {
		boardSpot = 0;
	}
}
