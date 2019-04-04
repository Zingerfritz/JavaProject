import java.util.Scanner;

public class Driver {
	protected Game game;
	protected Player[] players;
	public final String gName = "Monopoly Party";
	public final int spots = 12;
	
	
	public int intInput(String query, int low, int high) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			String input;
			boolean isDig = true;
			System.out.print(query);
			input = scanner.nextLine();
			for (int j = 0; j < input.length(); j++) {
				if (!Character.isDigit(input.charAt(j)))
					isDig = false;
			}
			if (isDig && input.length() > 0) 
				num = Integer.parseInt(input);
		} while(num < low || num > high);
		return num;
	}
	
	public void winner(String name) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n\nWINNER");
		System.out.println(name);
		long t = System.currentTimeMillis();
		while (System.currentTimeMillis() - t < 5000) {
		}
		System.out.println("Press any key to continue");
		scanner.nextLine();
	}
	
	public void close() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBye-Bye");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		StartMenu startMenu = new StartMenu();
		startMenu.start();
		startMenu.cont();
	}
	
	
}
