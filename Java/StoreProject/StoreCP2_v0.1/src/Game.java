public class Game {
	String itemName;
	String console;
	String publisher;
	String genre;
	double storePrice;
	double retailPrice;
	double salePrice;
	int stock;
	
	public Game (String argName, String argCon, String argPub, String argGen, double argSto, double argRet, double argSale, int argStock) {
		itemName = argName;
		console = argCon;
		publisher = argPub;
		genre = argGen;
		storePrice = argSto;
		retailPrice = argRet;
		salePrice = argSale;
		stock = argStock;
	}
}