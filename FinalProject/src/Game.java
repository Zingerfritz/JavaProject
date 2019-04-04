import java.util.Scanner;

public class Game extends Driver {
	private int numOfPlayers;
	private Player[] players;
	
	public int numOfPlayers() {
		return numOfPlayers;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
		numOfPlayers = players.length;
	}
	
	public void reset() {
		for (int j = 0; j < numOfPlayers; j++) {
			players[j].reset();
		}
	}
	
	public void play() {
		Scanner scanner = new Scanner(System.in);
		boolean gameOn = true;
		while(gameOn) {
			for (int j = 0; j < numOfPlayers; j++) {
				System.out.println("\n\n\n\n\n\n");
				System.out.println("CURRENT STANDINGS");
				for (int i = 0; i < numOfPlayers; i++) 
					System.out.println(players[i].name() + ": Spot " + players[i].spot());
				int choice = 0;
				System.out.println();
				System.out.println(players[j].name() + "'s Turn");
				System.out.println("You can...");
				System.out.println("\t1. Roll Dice");
				System.out.println("\t2. Quit");
				choice = intInput("Your choice: ", 1, 2);
				if (choice == 2) close();
				players[j].rollDice();
				if (players[j].spot() == 0) {
					winner(players[j].name());
					gameOn = false;
					break;
				}
			}
		}
		
		
	}
}