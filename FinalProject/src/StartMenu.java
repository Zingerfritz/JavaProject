import java.util.Scanner;

public class StartMenu extends Driver {

	public static int getPlayerNum() {	//This method enforces full input validation
		Scanner scanner = new Scanner(System.in);
		int numOfPlayers = intInput("How Many Players? ", 2, 4);
		return numOfPlayers;
	}
	
	public static void createPlayers(int num) {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		
		Player[] players = new Player[num];
		for (int j = 0; j < num; j++) {
			System.out.print("Enter Player " + (j + 1) + " Name: ");
			players[j] = new Player(scanner.nextLine());
		}
		
		Game.setPlayers(players);
	}
	
	public static void startMenu() {
		int choice;
		
		System.out.println(Game.gName);
		System.out.println("\t1. Start Game");
		System.out.println("\t2. Quit");
		
		choice = intInput("", 1, 2);
		
		if (choice != 1) {
			Driver.close();
		}
		else {
			choice = getPlayerNum();
			createPlayers(choice);
		}
		
	}
}
