public class Controller extends StoreObject {
	public String console;
	public String manufacturer;
	
	public Controller (String argItemName, double argStorePrice, double argRetailPrice, String argCon, String argMan) {
		super(argItemName, argStorePrice, argRetailPrice);
		console = argCon;
		manufacturer = argMan;
	}
	
	public Controller (String argItemName, double argStorePrice, double argRetailPrice, double argDis, String argCon, String argMan) {
		super(argItemName, argStorePrice, argRetailPrice, argDis);
		console = argCon;
		manufacturer = argMan;
	}
}