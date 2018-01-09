import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class head {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("/H:/My Stuff/Java/StoreProjectCP2/src/testing.txt");
		StoreObject[] Inventory = ScanFile(f);
		System.out.println("New store Opening!\n");

		System.out.println("===========\n Inventory \n===========");
		for(int i = 0; i < Inventory.length; i++){
			System.out.println(Inventory[i].itemName);
			System.out.println("    Price: $" + Inventory[i].retailPrice);
		}
		System.out.println("\n");
		
		
	}
	
	public static StoreObject[] ScanFile(File f) throws FileNotFoundException {
		int length = 0;
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			length += 1;
			s.nextLine();
		}
		s.close();
		
		s = new Scanner(f);
		String [] file = new String[length+2];
		for (int i = 0; i < file.length-2; i++) {
			file[i+2] = s.nextLine();
			if (file[i+2].equals("..")) {
				sections += 1;
			}
		}
		file[0] = Integer.toString(length);
		file[1] = Integer.toString(sections);
		s.close();
		
		StoreObject[] inv = new StoreObject[sections];
		s = new Scanner(f);
		for (int i = 0; i < sections; i ++) {
			String objectType;
			String objectName;
			double objectStorePrice;
			double objectRetailPrice;
			String objectDev;
			String objectConsole;
			String objectMode;
			objectType = s.nextLine();
			switch (objectType) {
			case "Game":
				System.out.println("Creating new game");
				objectName = s.nextLine();
				objectStorePrice = s.nextDouble();
				objectRetailPrice = s.nextDouble();
				objectConsole = s.nextLine();
				objectDev = s.nextLine();
				inv[i] = new Game(objectName, objectStorePrice, objectRetailPrice, objectConsole, objectDev);
				s.nextLine();
				s.nextLine();
				break;
			case "Console":
				System.out.println("Creating new console");
				objectName = s.nextLine();
				objectStorePrice = s.nextDouble();
				objectRetailPrice = s.nextDouble();
				objectDev = s.nextLine();
				objectMode = s.nextLine();
				inv[i] = new Console(objectName, objectStorePrice, objectRetailPrice, objectDev, objectMode);
				s.nextLine();
				s.nextLine();
				break;
			case "Controller":
				System.out.println("Creating new controller");
				objectName = s.nextLine();
				objectStorePrice = s.nextDouble();
				objectRetailPrice = s.nextDouble();
				objectConsole = s.nextLine();
				objectDev = s.nextLine();
				inv[i] = new Controller(objectName, objectStorePrice, objectRetailPrice, objectConsole, objectDev);
				s.nextLine();
				s.nextLine();
				break;
			default:
				System.out.println("fatal error");
			}
		}
		s.close();
		
		return(inv);
	}
}