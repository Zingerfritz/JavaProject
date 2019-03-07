
public class Game {
	private static int numOfPlayers;
	public static final String gName = "Monopoly Party";
	private static Player[] players;
	
	public static int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public static void setPlayers(int num, String[] name) {
		players = new Player[num];
		for (int j = 0; j < num; j++)
			players[j].setName(name[j]);
	}
}