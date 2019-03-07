import java.util.Scanner;

public class StartMenu {
	public static int getPlayerNum() {
		Scanner scanner = new Scanner(System.in);
		int numOfPlayers;
		
		do {
			String input;
			boolean isDig = true;
			System.out.print("How many players? ");
			input = scanner.nextLine();
			for (int j = 0; j < input.length(); j++) {
				if (!Character.isDigit(input.charAt(j)))
					isDig = false;
			}
			if (isDig) 
				numOfPlayers = Integer.parseInt(input);
			else 
				numOfPlayers = 0;
		} while(numOfPlayers < 2 || numOfPlayers > 4);
		
		System.out.print("\n\n" + numOfPlayers);
		
		scanner.close();
		return numOfPlayers;
	}
	
	public static void createPlayers(int num) {
		for (int j = 0; j < num; j++) {
			
	}
	
	public static void startMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		System.out.println(Game.gName);
		System.out.println("\t1. Start Game");
		System.out.println("\t2. Quit");
		
		choice = scanner.nextInt();
		
		if (choice == 1) {
			choice = getPlayerNum();
			createPlayers(choice);
		}
	}
}
