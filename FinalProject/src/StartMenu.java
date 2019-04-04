import java.util.Scanner;

public class StartMenu extends Driver {
	
	public int getPlayerNum() {	
		Scanner scanner = new Scanner(System.in);
		int numOfPlayers = intInput("How Many Players? ", 2, 4);
		return numOfPlayers;
	}
	
	public void createPlayers(int num) {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		
		Player[] players = new Player[num];
		for (int j = 0; j < num; j++) {
			System.out.print("Enter Player " + (j + 1) + " Name: ");
			players[j] = new Player(scanner.nextLine());
		}
		
		game.setPlayers(players);
	}
	
	public void start() {
		int choice;
		game = new Game();
		
		System.out.println(gName);
		System.out.println("\t1. Start Game");
		System.out.println("\t2. Quit");
		
		choice = intInput("", 1, 2);
		
		if (choice != 1) {
			close();
		}
		else {
			choice = getPlayerNum();
			createPlayers(choice);
			game.play();
		}
		
	}
	
	public void cont() {
		int choice;
		
		System.out.println(gName);
		System.out.println("\t1. Play Again");
		System.out.println("\t2. Main Menu");
		System.out.println("\t3. Quit");
		
		choice = intInput("", 1, 3);
		
		if (choice == 1) {
			game.play();
		}
		else if (choice == 2) {
			start();
		}
		else {
			close();
		}
	}
}
