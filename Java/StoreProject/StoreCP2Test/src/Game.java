public class Game extends StoreObject {
	public String gameConsole;
	public String gameDev;
	public String genre;
	public boolean hasMultiplayer;
	public boolean hasOnline;
	
	public Game (String argItemName, double argStorePrice, double argRetailPrice, String argConsole, String argDev, String argGenre, boolean argMultiplayer, boolean argOnline) {
		super(argItemName, argStorePrice, argRetailPrice);
		gameConsole = argConsole;
		gameDev = argDev;
		genre = argGenre;
		hasMultiplayer = argMultiplayer;
		hasOnline = argOnline;
	}
	
	public Game (String argItemName, double argStorePrice, double argRetailPrice, double argDiscount, String argConsole, String argDev, String argGenre, boolean argMultiplayer, boolean argOnline) {
		super(argItemName, argStorePrice, argRetailPrice, argDiscount);
		gameConsole = argConsole;
		gameDev = argDev;
		genre = argGenre;
		hasMultiplayer = argMultiplayer;
		hasOnline = argOnline;
	}
}