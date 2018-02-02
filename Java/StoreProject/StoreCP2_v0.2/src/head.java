import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
public class head {

	public static void main(String[] args) throws IOException {
		File Inv = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.2/src/testing.txt");
		File Sales = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.2/src/Sales.txt");
		
		FileWriter f = new FileWriter(Sales, false);
		PrintWriter p = new PrintWriter(f);
		p.println("\t\t=====Sales=====");
		p.close();
		
		ArrayList<Game> Inventory = ScanFile(Inv, Sales);
		Scanner scan = new Scanner (System.in);
		
		boolean isRunning = true;
		
		while (isRunning) {
			System.out.println("Please enter a command, press help for a list of commands: ");
			String command = scan.nextLine();
			command.toLowerCase();
			switch (command) {
				case "print":
				case "inventory":
					printInventory(Inventory);
				case "sell":
					System.out.println("Please enter the index of the game you would like to sell: ");
					if (scan.hasNextInt()) {
						int m = scan.nextInt();
						if ((m >= 0) && (m < Inventory.size())) {
							System.out.println("Please enter the amount of " + Inventory.get(m).itemName + " for " + Inventory.get(m).console +" that you would like to sell: ");
							if (scan.hasNextInt()) {
								int n = scan.nextInt();
								System.out.println("Please type 'sell' if the game is on sell. If not press enter: ");
								if (scan.nextLine().toLowerCase().equals("sell"))
									Inventory.get(m).sell(n, true, new Date());
								else
									Inventory.get(m).sell(n, false, new Date());
							} else
								System.out.println("You entered an invalid stock");
						} else
							System.out.println("You entered an invalid index number");
					} else
						System.out.println("You did'nt enter an integer");
					break;
				case "help":
				case "command":
					break;
				case "quit":
					isRunning = false;
					break;
				default:
					System.out.println("Error: Invalid command");
			}
			System.out.println();
		}
	}
	
	public static void printInventory (ArrayList<Game> inv) {
		for(int i = 0; i < inv.size(); i++){
			Game g = (Game)inv.get(i);
			System.out.println(g.itemName + ", a " + g.genre + " game by " + g.publisher + " for " + g.console);
			if (g.stock <= 0)
				System.out.println("    NOT IN STOCK"); 
			System.out.println("    Price: $" + g.retailPrice);
		}
	}
	
	public static boolean SaveFile(File f) {
		return true;
	}
	
 	public static ArrayList<Game> ScanFile(File f, File Sales) throws FileNotFoundException {
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			if(s.nextLine().equals("..")) sections++;
		}
		s.close();
		
		ArrayList<Game> inv = new ArrayList<Game>();
		s = new Scanner(f);
		for (int i = 0; i < sections; i ++) {
			String objName;
			String objCon;
			String objPub;
			String objGen;
			double objSto;
			double objRet;
			double objSale;
			int objStock;
			
			if(s.hasNextLine()) 	{objName = s.nextLine(); 	/*System.out.println(objName);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 1"); break;}
			if(s.hasNextLine()) 	{objCon = s.nextLine(); 	/*System.out.println(objCon);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 2"); break;}
			if(s.hasNextLine()) 	{objPub = s.nextLine(); 	/*System.out.println(objPub);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 3"); break;}
			if(s.hasNextLine()) 	{objGen = s.nextLine(); 	/*System.out.println(objGen);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 4"); break;}
			if(s.hasNextDouble()) 	{objSto = s.nextDouble(); 	/*System.out.println(objSto);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 5"); break;}
			if(s.hasNextDouble()) 	{objRet = s.nextDouble(); 	/*System.out.println(objRet);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 6"); break;}
			if(s.hasNextDouble()) 	{objSale = s.nextDouble(); 	/*System.out.println(objSale);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 7"); break;}
			if(s.hasNextInt())		{objStock = s.nextInt();	/*System.out.println(objStock);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 8"); break;}
			s.nextLine();
			s.nextLine();
			
			inv.add(new Game(objName, objCon, objPub, objGen, objSto, objRet, objSale, objStock, Sales));
		}
		s.close();
		
		return(inv);
	}

}