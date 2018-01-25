public class Console extends StoreObject {
	public String consoleDev;
	public String mode;
	
	public Console (String argItemName, double argStorePrice, double argRetailPrice, String argDev, String argMode) {
		super(argItemName, argStorePrice, argRetailPrice);
		consoleDev = argDev;
		mode = argMode;
	}
	
	public Console (String argItemName, double argStorePrice, double argRetailPrice, double argDiscount, String argDev, String argMode) {
		super(argItemName, argStorePrice, argRetailPrice, argDiscount);
		consoleDev = argDev;
		mode = argMode;
	}
}