import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class StoreObject {
	String itemName;
	String shortName;
	double storePrice;
	double retailPrice;
	double salePrice;
	int stock;
	File sellsFile;
	
	public StoreObject (String argName, double argSto, double argRet, double argSale, int argStock, File argFile) {
		itemName = argName;
		storePrice = argSto;
		retailPrice = argRet;
		salePrice = argSale;
		stock = argStock;
		sellsFile = argFile;
		if(itemName.length() <= 19)
			shortName = itemName;
		else
			shortName = itemName.substring(0, 18) + "...";
	}
	
	public boolean sell (int argStock, boolean sale, Date date) throws IOException {
		FileWriter f = new FileWriter(sellsFile, true);
		PrintWriter p = new PrintWriter(f);
		
		if ((argStock <= stock) && (argStock > 0)) {
			p.println(itemName);
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