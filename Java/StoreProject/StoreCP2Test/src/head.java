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
			if (Inventory[i] instanceof Game) {
				Game g = (Game) Inventory[i];
				System.out.println(g.itemName + ", a " + g.genre + " game by " + g.gameDev + " for " + g.gameConsole);
			} else if (Inventory[i] instanceof Console) {
				Console c = (Console) Inventory[i];
				System.out.println(c.itemName + ", a " + c.mode + " console from " + c.consoleDev);
			} else if (Inventory[i] instanceof Controller) {
				Controller c = (Controller) Inventory[i];
				System.out.println(c.itemName + ", a controller from " + c.manufacturer + " for " + c.console);
			} else {
				System.out.println(Inventory[i].itemName);
			}
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
			if(s.nextLine().equals("..")) sections++;
		}
		s.close();
		
		StoreObject[] inv = new StoreObject[sections];
		s = new Scanner(f);
		for (int i = 0; i < sections; i ++) {
			String objectType = null;
			String objectName = null;
			double objectStorePrice = 0.0;
			double objectRetailPrice = 0.0;
			String objectDev = null;
			String objectConsole = null;
			String objectMode = null;
			boolean objectMultiplayer = false;
			boolean objectOnline = false;
			
			objectType = s.nextLine();
			
			switch (objectType) {
			
			case "Game":
				System.out.println("Creating new game");
				if(s.hasNextLine()) 	objectName = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectStorePrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectRetailPrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				s.nextLine();
				if(s.hasNextLine()) 	objectConsole = s.nextLine();			else {System.out.println("error: data missing"); break;}
				if(s.hasNextLine()) 	objectDev = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextLine()) 	objectMode = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextBoolean()) 	objectMultiplayer = s.nextBoolean();	else {System.out.println("error: data missing"); break;}
				if(s.hasNextBoolean()) 	objectOnline = s.nextBoolean();			else {System.out.println("error: data missing"); break;}
				
				inv[i] = new Game(objectName, objectStorePrice, objectRetailPrice, objectConsole, objectDev, objectMode, objectMultiplayer, objectOnline);
				s.nextLine();
				s.nextLine();
				break;
				
			case "Console":
				System.out.println("Creating new console");
				if(s.hasNextLine()) 	objectName = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectStorePrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectRetailPrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				s.nextLine();
				if(s.hasNextLine()) 	objectDev = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextLine()) 	objectMode = s.nextLine();				else {System.out.println("error: data missing"); break;}
				
				inv[i] = new Console(objectName, objectStorePrice, objectRetailPrice, objectDev, objectMode);
				s.nextLine();
				break;
				
			case "Controller":
				System.out.println("Creating new controller");
				if(s.hasNextLine()) 	objectName = s.nextLine();				else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectStorePrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				if(s.hasNextDouble()) 	objectRetailPrice = s.nextDouble();		else {System.out.println("error: data missing"); break;}
				s.nextLine();
				if(s.hasNextLine()) 	objectConsole = s.nextLine();			else {System.out.println("error: data missing"); break;}
				if(s.hasNextLine()) 	objectDev = s.nextLine();				else {System.out.println("error: data missing"); break;}
				
				inv[i] = new Controller(objectName, objectStorePrice, objectRetailPrice, objectConsole, objectDev);
				s.nextLine();
				break;
				
			default:
				System.out.println("Error: data type unspecified");
			}
		}
		s.close();
		
		return(inv);
	}

}