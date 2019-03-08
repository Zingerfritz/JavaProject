import java.util.Scanner;

public class Game extends Driver {
	private static int numOfPlayers;
	public static final String gName = "Monopoly Party";
	public static final int spots = 12;
	private static Player[] players;
	
	public static int numOfPlayers() {
		return numOfPlayers;
	}
	
	public static void setPlayers(Player[] players) {
		Game.players = players;
		numOfPlayers = players.length;
	}
	
	public static void game() {
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
				if (choice == 2) Driver.close();
				players[j].rollDice();
				if (players[j].spot() == 0) {
					Driver.winner(players[j].name());
					gameOn = false;
					break;
				}
			}
		}
	}
}