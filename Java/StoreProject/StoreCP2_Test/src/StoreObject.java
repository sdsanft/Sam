public class StoreObject {
	String itemName;
	double tax;
	double profit;
	double storePrice;
	double retailPrice;
	double discount;
	double subtotal;
	double customerCost;
	
	public StoreObject (String argItemName, double argStorePrice, double argRetailPrice) {
		itemName = argItemName;
		storePrice = argStorePrice;
		retailPrice = argRetailPrice;
		discount = 0;
		subtotal = (1-discount) * retailPrice;
		tax = .07 * subtotal;
		customerCost = subtotal + tax;
		profit = subtotal - storePrice;
	}
	
	public StoreObject (String argItemName, double argStorePrice, double argRetailPrice, double argDiscount) {
		itemName = argItemName;
		storePrice = argStorePrice;
		retailPrice = argRetailPrice;
		discount = argDiscount;
		subtotal = (1-discount) * retailPrice;
		tax = .07 * subtotal;
		customerCost = subtotal + tax;
		profit = subtotal - storePrice;
	}
}