import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class head {

	public static void main(String[] args) throws IOException {
		File InvGameFile = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.4/src/data/InvGame.txt");
		File InvGameInput = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.4/src/data/InputGame.txt");
		File InvConsoleFile = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.4/src/data/InvConsole.txt");
		File InvConsoleInput = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.4/src/data/InputConsole.txt");
		File Sales = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.4/src/Sales.txt");
		
		//FileWriter f = new FileWriter(Sales, false);
		//PrintWriter p = new PrintWriter(f);
		//p.println("\t\t=====Sales=====");
		//p.close();
		
		ArrayList<Game> InvGame = new ArrayList<Game>();
		InvGame = ScanFile(InvGameFile, Sales, InvGame);
		InvGame = ScanFile(InvGameInput, Sales, InvGame);
		ArrayList<Console> InvConsole = new ArrayList<Console>();
		InvConsole = ScanFileConsole(InvConsoleFile, Sales, InvConsole);
		InvConsole = ScanFileConsole(InvConsoleInput, Sales, InvConsole);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Type 'customer' to view inventory or press enter for employee mode");
		String command = s.nextLine();
		if (command.toLowerCase().equals("customer"))
			customer(InvGame, InvConsole);
		else
			employee(InvGame, InvConsole, InvGameFile, InvConsoleFile, Sales);
		
		SaveFile(InvGameFile, InvGame);
		SaveFileConsole(InvConsoleFile, InvConsole);
		s.close();
	}
	
	public static void employee (ArrayList<Game> InvGame, ArrayList<Console> InvConsole, File InvGameFile, File InvConsoleFile, File Sales) throws IOException {
		Scanner scan = new Scanner (System.in);
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("Please enter a command, press help for a list of commands: ");
			String command = scan.nextLine();
			command.toLowerCase();
			switch (command) {
				case "print":
				case "inventory":
					printInventory(InvGame);
					printInventoryConsole(InvConsole);
					break;
				case "sales":
				case "print sales":
					printSales(Sales);
					break;
				case "sell":
					System.out.println("Please specify the item you are selling (ie 'sell console'");
					break;
				case "sell game":
					System.out.println("Please enter the index of the game you would like to sell: ");
					if (scan.hasNextInt()) {
						int ind = scan.nextInt();
						if ((ind >= 0) && (ind < InvGame.size())) {
							System.out.println("Please enter the amount of copies of " + InvGame.get(ind).itemName + " for " + InvGame.get(ind).console +" that you would like to sell: ");
							if (scan.hasNextInt()) {
								int sto = scan.nextInt(); scan.nextLine();
								System.out.println("Please type 'yes' if the game is on sale ($" + InvGame.get(ind).salePrice + "). If not type no.");
								String sal = scan.nextLine();
								if (sal.toLowerCase().equals("yes"))
									InvGame.get(ind).sell(sto, true, new Date());
								else
									InvGame.get(ind).sell(sto, false, new Date());
							} else
								System.out.println("You entered an invalid stock");
						} else
							System.out.println("You entered an invalid index number");
					} else
						System.out.println("You didn't enter an integer");
					break;
				case "sell console":
					System.out.println("Please enter the index of the console you would like to sell: ");
					if (scan.hasNextInt()) {
						int ind = scan.nextInt();
						if ((ind >= 0) && (ind < InvConsole.size())) {
							System.out.println("Please enter the amount of " + InvConsole.get(ind).itemName + " consoles that you would like to sell: ");
							if (scan.hasNextInt()) {
								int sto = scan.nextInt(); scan.nextLine();
								System.out.println("Please type 'yes' if the console is on sale ($" + InvConsole.get(ind).salePrice + "). If not type no.");
								String sal = scan.nextLine();
								if (sal.toLowerCase().equals("yes"))
									InvConsole.get(ind).sell(sto, true, new Date());
								else
									InvConsole.get(ind).sell(sto, false, new Date());
							} else
								System.out.println("You entered an invalid stock");
						} else
							System.out.println("You entered an invalid index number");
					} else
						System.out.println("You didn't enter an integer");
					break;
				case "help":
				case "command":
					System.out.println("\tprint: print inventory");
					System.out.println("\tsell: record sales of stock in inventory");
					System.out.println("\thelp: view a list of commands");
					System.out.println("\tquit: exit the program");
					break;
				case "save":
					SaveFile(InvGameFile, InvGame);
					SaveFileConsole(InvConsoleFile, InvConsole);
					break;
				case "quit":
					isRunning = false;
					break;
				default:
					System.out.println("Error: Invalid command");
			}
			System.out.println();
		}
		scan.close();
	}
	
	public static void customer (ArrayList<Game> InvGame, ArrayList<Console> InvConsole) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				createGui(InvGame, InvConsole);
			}
		});
	}
	
	
	
	public static ArrayList<Game> mergeInventory (ArrayList<Game> inv) {
		ArrayList indexes = new ArrayList();
		for (int m = 0; m < inv.size(); m++) {
			for (int n = m + 1; n < inv.size(); n++) {
				if (inv.get(m).itemName.equals(inv.get(n).itemName) && inv.get(m).console.equals(inv.get(n).console)) {
					//System.out.println("Inventory clone located");
					inv.get(n).stock += inv.get(m).stock;
					indexes.add(m);
				}
			}
		}
		for(int i = indexes.size() - 1; i >= 0; i--) {
			//System.out.println(indexes.get(i));
			inv.remove(indexes.get(i));
		}
		return (inv);
	}
	
	public static void printInventory (ArrayList<Game> inv) {
		for(int i = 0; i < inv.size(); i++){
			Game g = (Game)inv.get(i);
			System.out.println(g.itemName + ", a " + g.genre + " game by " + g.publisher + " for " + g.console);
			if (g.stock <= 0)
				System.out.println("\tNOT IN STOCK");
			else
				System.out.println("\tStock: " + g.stock);
			System.out.println("\tPrice: $" + g.retailPrice);
		}
	}
	
	public static boolean SaveFile(File f, ArrayList<Game> inv) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter(f, false));
		p.print("");
		p.close();
		p = new PrintWriter(new FileWriter(f, true));
		for (int i = 0; i < inv.size(); i++) {
			p.println(inv.get(i).itemName);
			p.println(inv.get(i).console);
			p.println(inv.get(i).publisher);
			p.println(inv.get(i).genre);
			p.println(inv.get(i).storePrice);
			p.println(inv.get(i).retailPrice);
			p.println(inv.get(i).salePrice);
			p.println(inv.get(i).stock);
			p.println("..");
		}
		p.close();
		return true;
	}
 	
 	public static ArrayList<Game> ScanFile(File f, File Sales, ArrayList<Game> inv) throws IOException {
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			if(s.nextLine().equals("..")) sections++;
		}
		s.close();
		
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
		
		PrintWriter p = new PrintWriter(new FileWriter(f, false));
		p.println("");
		p.close();
		
		inv = mergeInventory(inv);
		return(inv);
	}
 	
 	

 	public static ArrayList<Console> mergeInventoryConsole (ArrayList<Console> inv) {
		ArrayList indexes = new ArrayList();
		for (int m = 0; m < inv.size(); m++) {
			for (int n = m + 1; n < inv.size(); n++) {
				if (inv.get(m).itemName.equals(inv.get(n).itemName)) {
					//System.out.println("Inventory clone located");
					inv.get(n).stock += inv.get(m).stock;
					indexes.add(m);
				}
			}
		}
		for(int i = indexes.size() - 1; i >= 0; i--) {
			//System.out.println(indexes.get(i));
			inv.remove((int)indexes.get(i));
		}
		return (inv);
	}
	
	public static void printInventoryConsole (ArrayList<Console> inv) {
		for(int i = 0; i < inv.size(); i++){
			Console g = inv.get(i);
			System.out.println(g.itemName + ", a " + g.type + " console from " + g.manufacturer);
			if (g.stock <= 0)
				System.out.println("\tNOT IN STOCK");
			else
				System.out.println("\tStock: " + g.stock);
			System.out.println("\tPrice: $" + g.retailPrice);
		}
	}
	
	public static boolean SaveFileConsole (File f, ArrayList<Console> inv) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter(f, false));
		p.print("");
		p.close();
		p = new PrintWriter(new FileWriter(f, true));
		for (int i = 0; i < inv.size(); i++) {
			p.println(inv.get(i).itemName);
			p.println(inv.get(i).manufacturer);
			p.println(inv.get(i).type);
			p.println(inv.get(i).storePrice);
			p.println(inv.get(i).retailPrice);
			p.println(inv.get(i).salePrice);
			p.println(inv.get(i).stock);
			p.println("..");
		}
		p.close();
		return true;
	}
 	
	public static ArrayList<Console> ScanFileConsole (File f, File Sales, ArrayList<Console> inv) throws IOException {
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			if(s.nextLine().equals("..")) sections++;
		}
		s.close();
		
		s = new Scanner(f);
		for (int i = 0; i < sections; i ++) {
			String objName;
			String objMan;
			String objType;
			double objSto;
			double objRet;
			double objSale;
			int objStock;
			
			if(s.hasNextLine()) 	{objName = s.nextLine(); 	/*System.out.println(objName);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 1"); break;}
			if(s.hasNextLine()) 	{objMan = s.nextLine(); 	/*System.out.println(objCon);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 2"); break;}
			if(s.hasNextLine()) 	{objType = s.nextLine(); 	/*System.out.println(objCon);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 2"); break;}
			if(s.hasNextDouble()) 	{objSto = s.nextDouble(); 	/*System.out.println(objSto);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 5"); break;}
			if(s.hasNextDouble()) 	{objRet = s.nextDouble(); 	/*System.out.println(objRet);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 6"); break;}
			if(s.hasNextDouble()) 	{objSale = s.nextDouble(); 	/*System.out.println(objSale);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 7"); break;}
			if(s.hasNextInt())		{objStock = s.nextInt();	/*System.out.println(objStock);*/}		else {System.out.println("error: data missing\n" + f.getPath() + " Section " + (i+1) + ", Line 8"); break;}
			s.nextLine();
			s.nextLine();
			
			inv.add(new Console(objName, objMan, objType, objSto, objRet, objSale, objStock, Sales));
		}
		s.close();
		
		PrintWriter p = new PrintWriter(new FileWriter(f, false));
		p.println("");
		p.close();
		
		inv = mergeInventoryConsole(inv);
		return(inv);
	}

	
	
	public static void printSales (File salesFile) throws FileNotFoundException {
		int length = 0;
		Scanner fileScanner = new Scanner(salesFile);
		
		while(fileScanner.hasNextLine()) {
			length++;
			fileScanner.nextLine();
		}
		fileScanner.close();
		
		fileScanner = new Scanner(salesFile);
		for (int i = 0; i < length; i++) {
			System.out.println(fileScanner.nextLine());
		}
		fileScanner.close();
	}

	public static void createGui(ArrayList<Game> InvGame, ArrayList<Console> InvConsole) {
		JFrame frame = new JFrame ("Inventory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar ();
		menu.setOpaque(true);
		menu.setBackground(new Color(150, 200, 150));
		menu.setPreferredSize(new Dimension(200, 50));
		
		JTextArea textbox = new JTextArea();
		textbox.setOpaque(true);
		textbox.setBackground(new Color(250, 250, 200));
		textbox.append("Games\n");
		for(int i = 0; i < InvGame.size(); i++) {
			textbox.append("$" + InvGame.get(i).retailPrice + "        " + InvGame.get(i).itemName + ":\n");
			if (InvGame.get(i).stock <= 0) textbox.append("\tNOT IN STOCK\n");
			textbox.append("\tA(n) " + InvGame.get(i).genre + " game developed by " + InvGame.get(i).publisher + " for " + InvGame.get(i).console + "\n");
		}
		textbox.append("\nConsoles\n");
		for(int i = 0; i < InvConsole.size(); i++) {
			textbox.append("$" + InvConsole.get(i).retailPrice + "        " + InvConsole.get(i).itemName + ":\n");
			if (InvConsole.get(i).stock <= 0) textbox.append("\tNOT IN STOCK\n");
			textbox.append("\tA " + InvConsole.get(i).type + " console made by " + InvConsole.get(i).manufacturer + "\n");
		}
		textbox.setEditable(false);
		
		frame.setJMenuBar(menu);
		frame.add(textbox, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
}