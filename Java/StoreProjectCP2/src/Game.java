public class Game extends StoreObject {
	public String gameConsole;
	public String gameDev;
	
	public Game (String argItemName, double argStorePrice, double argRetailPrice, String argConsole, String argDev) {
		super(argItemName, argStorePrice, argRetailPrice);
		gameConsole = argConsole;
		gameDev = argDev;
	}
	
	public Game (String argItemName, double argStorePrice, double argRetailPrice, double argDiscount, String argConsole, String argDev) {
		super(argItemName, argStorePrice, argRetailPrice, argDiscount);
		gameConsole = argConsole;
		gameDev = argDev;
	}
}