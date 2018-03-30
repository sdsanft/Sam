import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Game extends StoreObject {
	String console;
	String publisher;
	String genre;
	
	public Game (String argName, String argCon, String argPub, String argGen, double argSto, double argRet, double argSale, int argStock, File argFile) {
		super(argName, argSto, argRet, argSale, argStock, argFile);
		console = argCon;
		publisher = argPub;
		genre = argGen;
	}
	
	public boolean sell (int argStock, boolean sale, Date date) throws IOException {
		FileWriter f = new FileWriter(sellsFile, true);
		PrintWriter p = new PrintWriter(f);
		
		if ((argStock <= stock) && (argStock > 0)) {
			p.println(itemName + ", " + console);
			p.println("\tSold: " + argStock + ", Remaining: " + (stock-argStock));
			if (sale) p.println("\tPrice: $" + salePrice + ", Profit: $" + (salePrice - storePrice));
			else p.println("\tPrice: $" + retailPrice + ", Profit $" + (retailPrice - storePrice));
			p.println("\t" + date.toString());
			
			System.out.println("Sold " + argStock + " copies of " + itemName);
			stock -= argStock;
			f.close();
			return true;
		}
		
		System.out.println("Sell Error: not enough stock");
		f.close();
		return false;
	}
}