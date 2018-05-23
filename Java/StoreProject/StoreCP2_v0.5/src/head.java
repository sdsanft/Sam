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

public class head extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static JFrame frame, addFrame, sellFrame;
	JLabel label, labelCustomer;
	JButton button, button2, button3, button4, button5, buttonAdd, buttonRefresh, buttonSell;
	JTextArea text, textbox,
			gameName, gameConsole, gameDeveloper, gameGenre, gameStoPri, gameRetPri, gameSalPri, gameQuantity,
			consName, consDeveloper, consType, consStoPri, consRetPri, consSalPri, consQuantity;
	JSplitPane splitPane, splitPane2, splitPane3, splitPane4, splitPane5, splitPaneCustomer, splitPaneWhole, splitPaneButtons;
	JPanel bottomPane, topPane, rightPane1, rightPane2, rightPane3, customerPane, wholePane, buttonsPane;
	ArrayList<JSplitPane> spSellItems;
	ArrayList<JPanel> jpSellItems;
	ArrayList<Game> InvGame;
	ArrayList<Console> InvConsole;
	ArrayList<JTextArea> sellItemsText;
	File InvGameFile, InvGameBackup, InvConsoleFile, InvConsoleBackup, Sales, InvGameInput, InvConsoleInput;
	
	
	public static void main(String[] args) throws IOException {
		/*
		File InvGameFile = new File("/H:/My Stuff/Java/StoreProject/data/InvGame.txt");
		File InvGameInput = new File("/H:/My Stuff/Java/StoreProject/data/InputGame.txt");
		File InvConsoleFile = new File("/H:/My Stuff/Java/StoreProject/data/InvConsole.txt");
		File InvConsoleInput = new File("/H:/My Stuff/Java/StoreProject/data/InputConsole.txt");
		File Sales = new File("/H:/My Stuff/Java/StoreProject/data/Sales.txt");
		*/
		
		//FileWriter f = new FileWriter(Sales, false);
		//PrintWriter p = new PrintWriter(f);
		//p.println("\t\t=====Sales=====");
		//p.close();
		
		/*
		ArrayList<Game> InvGame = new ArrayList<Game>();
		InvGame = ScanFile(InvGameFile, Sales, InvGame);
		InvGame = ScanFile(InvGameInput, Sales, InvGame);
		ArrayList<Console> InvConsole = new ArrayList<Console>();
		InvConsole = ScanFileConsole(InvConsoleFile, Sales, InvConsole);
		InvConsole = ScanFileConsole(InvConsoleInput, Sales, InvConsole);
		*/
		
		Scanner s = new Scanner(System.in);
		System.out.println("Type 'customer' to view inventory or press enter for employee mode");
		String command = s.nextLine();
		if (command.toLowerCase().equals("customer"))
			customer();
		else
			employee();
			//employee(InvGame, InvConsole, InvGameFile, InvConsoleFile, Sales);
		
		/*
		SaveFile(InvGameFile, InvGame);
		SaveFileConsole(InvConsoleFile, InvConsole);
		*/
		s.close();
	}
	
	/*
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
	*/
	
	public static void employee () {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				try {
					showEmployeeGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void customer () {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				try {
					createCustomerGui();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public static ArrayList<Game> mergeInventory (ArrayList<Game> inv) {
		ArrayList indexes  = new ArrayList();
		for (int m = 0; m < inv.size(); m++) {
			for (int n = m + 1; n < inv.size(); n++) {
				if (inv.get(m).itemName.equals(inv.get(n).itemName) && inv.get(m).console.equals(inv.get(n).console)) {
					System.out.println("Inventory clone located");
					inv.get(n).stock += inv.get(m).stock;
					indexes.add(m);
				}
			}
		}
		for(int i = indexes.size() - 1; i >= 0; i--) {
			System.out.println(indexes.get(i));
			inv.remove((int) indexes.get(i));
		}
		return (inv);
	}
	
	/*
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
	*/
	
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
	
 	/*
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
	*/
	
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

	
	
	public void printInventory () {
		JFrame frame = new JFrame("Print Inventory");
		
		JMenuBar menu = new JMenuBar ();
		menu.setOpaque(true);
		menu.setBackground(new Color(150, 200, 150));
		menu.setPreferredSize(new Dimension(200, 50));
		
		JTextArea textbox = new JTextArea();
		textbox.setOpaque(true);
		textbox.setBackground(new Color(250, 250, 200));
		textbox.append("Games\tIn Stock\n");
		for(int i = 0; i < InvGame.size(); i++) {
			textbox.append("$" + InvGame.get(i).retailPrice + "/$" + InvGame.get(i).salePrice + "\t" + InvGame.get(i).stock + "        " + InvGame.get(i).itemName + ":\n");
			if (InvGame.get(i).stock <= 0) textbox.append("\tNOT IN STOCK\n");
			textbox.append("\t\tA(n) " + InvGame.get(i).genre + " game developed by " + InvGame.get(i).publisher + " for " + InvGame.get(i).console + "\n");
		}
		textbox.append("\nConsoles\tIn Stock\n");
		for(int i = 0; i < InvConsole.size(); i++) {
			textbox.append("$" + InvConsole.get(i).retailPrice + "/$" + InvConsole.get(i).salePrice + "\t" + InvConsole.get(i).stock + "        " + InvConsole.get(i).itemName + ":\n");
			if (InvConsole.get(i).stock <= 0) textbox.append("\tNOT IN STOCK\n");
			textbox.append("\t\tA " + InvConsole.get(i).type + " console made by " + InvConsole.get(i).manufacturer + "\n");
		}
		textbox.setEditable(false);
		
		frame.add(menu);
		frame.add(textbox);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void printSales() throws FileNotFoundException {
		int length = 0;
		Scanner fileScanner = new Scanner(Sales);
		
		while(fileScanner.hasNextLine()) {
			length++;
			fileScanner.nextLine();
		}
		fileScanner.close();
		
		JFrame frame = new JFrame("Print Inventory");
		
		JMenuBar menu = new JMenuBar ();
		menu.setOpaque(true);
		menu.setBackground(new Color(150, 200, 150));
		menu.setPreferredSize(new Dimension(200, 50));
		
		JTextArea textbox = new JTextArea();
		textbox.setOpaque(true);
		textbox.setBackground(new Color(250, 250, 200));
		textbox.append("\t===Sales===\n\n");
		
		fileScanner = new Scanner(Sales);
		if (length > 40) {
			for (int i = 0; i < length; i++) {
				if (i < (length - 40)) {
					fileScanner.nextLine();
				} else {
					textbox.append(fileScanner.nextLine() + "\n");
				}
			}
			textbox.append("\nFor a complete view of sales please view " + Sales.getAbsolutePath());
		} else {
			for (int i = 0; i < length; i++) {
				textbox.append(fileScanner.nextLine() + "\n");
			}
		}
		fileScanner.close();
		
		textbox.setEditable(false);
		
		frame.add(menu);
		frame.add(textbox);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addItems() {
		addFrame = new JFrame("Print Inventory");
		
		gameName = new JTextArea();
		gameName.setOpaque(true);
		gameName.setBackground(new Color(220, 220, 220));
		gameName.setBorder(BorderFactory.createLineBorder(Color.black));
		gameConsole = new JTextArea();
		gameConsole.setOpaque(true);
		gameConsole.setBackground(new Color(200, 200, 200));
		gameConsole.setBorder(BorderFactory.createLineBorder(Color.black));
		gameDeveloper = new JTextArea();
		gameDeveloper.setOpaque(true);
		gameDeveloper.setBackground(new Color(220, 220, 220));
		gameDeveloper.setBorder(BorderFactory.createLineBorder(Color.black));
		gameGenre = new JTextArea();
		gameGenre.setOpaque(true);
		gameGenre.setBackground(new Color(200, 200, 200));
		gameGenre.setBorder(BorderFactory.createLineBorder(Color.black));
		gameStoPri = new JTextArea();
		gameStoPri.setOpaque(true);
		gameStoPri.setBackground(new Color(220, 220, 220));
		gameStoPri.setBorder(BorderFactory.createLineBorder(Color.black));
		gameRetPri = new JTextArea();
		gameRetPri.setOpaque(true);
		gameRetPri.setBackground(new Color(200, 200, 200));
		gameRetPri.setBorder(BorderFactory.createLineBorder(Color.black));
		gameSalPri = new JTextArea();
		gameSalPri.setOpaque(true);
		gameSalPri.setBackground(new Color(220, 220, 220));
		gameSalPri.setBorder(BorderFactory.createLineBorder(Color.black));
		gameQuantity = new JTextArea();
		gameQuantity.setOpaque(true);
		gameQuantity.setBackground(new Color(200, 200, 200));
		gameQuantity.setBorder(BorderFactory.createLineBorder(Color.black));
		
		consName = new JTextArea();
		consName.setOpaque(true);
		consName.setBackground(new Color(220, 220, 220));
		consName.setBorder(BorderFactory.createLineBorder(Color.black));
		consDeveloper = new JTextArea();
		consDeveloper.setOpaque(true);
		consDeveloper.setBackground(new Color(200, 200, 200));
		consDeveloper.setBorder(BorderFactory.createLineBorder(Color.black));
		consType = new JTextArea();
		consType.setOpaque(true);
		consType.setBackground(new Color(220, 220, 220));
		consType.setBorder(BorderFactory.createLineBorder(Color.black));
		consStoPri = new JTextArea();
		consStoPri.setOpaque(true);
		consStoPri.setBackground(new Color(200, 200, 200));
		consStoPri.setBorder(BorderFactory.createLineBorder(Color.black));
		consRetPri = new JTextArea();
		consRetPri.setOpaque(true);
		consRetPri.setBackground(new Color(220, 220, 220));
		consRetPri.setBorder(BorderFactory.createLineBorder(Color.black));
		consSalPri = new JTextArea();
		consSalPri.setOpaque(true);
		consSalPri.setBackground(new Color(200, 200, 200));
		consSalPri.setBorder(BorderFactory.createLineBorder(Color.black));
		consQuantity = new JTextArea();
		consQuantity.setOpaque(true);
		consQuantity.setBackground(new Color(220, 220, 220));
		consQuantity.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JTextArea gamesHeader = new JTextArea();
		gamesHeader.setOpaque(true);
		gamesHeader.setBackground(new Color(250, 250, 200));
		gamesHeader.setText("            ===Games===\n"
				+ "Input data in the following format:\n"
				+ "Game Name\n"
				+ "Console\n"
				+ "Game Publisher\n"
				+ "Genre\n"
				+ "Price Paid\n"
				+ "Retail Price\n"
				+ "Sale Price\n"
				+ "Quantity");
		gamesHeader.setEditable(false);
		
		JTextArea consolesHeader = new JTextArea();
		consolesHeader.setOpaque(true);
		consolesHeader.setBackground(new Color(250, 250, 200));
		consolesHeader.setText("            ===Consoles===\n"
				+ "Input data in the following format:\n"
				+ "Console Name\n"
				+ "Console Developer\n"
				+ "Console Type\n"
				+ "Price Paid\n"
				+ "Retail Price\n"
				+ "Sale Price\n"
				+ "Quantity\n");
		consolesHeader.setEditable(false);
		
		buttonAdd = new JButton();
		buttonAdd.setBackground(new Color(150, 200, 150));
		buttonAdd.setText("Save");
		
		buttonAdd.addActionListener(this);
		
		JPanel addGamesPanel = new JPanel(new GridLayout(8,1));
		JPanel addConsolesPanel = new JPanel(new GridLayout(7,1));
		
		addGamesPanel.add(gameName);
		addGamesPanel.add(gameConsole);
		addGamesPanel.add(gameDeveloper);
		addGamesPanel.add(gameGenre);
		addGamesPanel.add(gameStoPri);
		addGamesPanel.add(gameRetPri);
		addGamesPanel.add(gameSalPri);
		addGamesPanel.add(gameQuantity);
		
		addConsolesPanel.add(consName);
		addConsolesPanel.add(consDeveloper);
		addConsolesPanel.add(consType);
		addConsolesPanel.add(consStoPri);
		addConsolesPanel.add(consRetPri);
		addConsolesPanel.add(consSalPri);
		addConsolesPanel.add(consQuantity);

		JPanel gPane = new JPanel(new GridLayout(2, 1));
		gPane.add(gamesHeader);
		gPane.add(addGamesPanel);
		
		JPanel cPane = new JPanel(new GridLayout(2, 1));
		cPane.add(consolesHeader);
		cPane.add(addConsolesPanel);
		
		JPanel Pane = new JPanel(new GridLayout(1, 2));
		Pane.add(gPane);
		Pane.add(cPane);
		
		JSplitPane fullSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Pane, buttonAdd);
		JPanel fullPane = new JPanel(new GridLayout(1, 0));
		fullPane.add(fullSplitPane);
		
		addFrame.add(fullPane);
		
		addFrame.pack();
		addFrame.setVisible(true);
	}
	
	public void sellItems() {
		sellFrame = new JFrame("Sell Items");
		
		sellItemsText = new ArrayList<JTextArea>();
		
		sellItemsText.add(new JTextArea("\tSell Items"));
		sellItemsText.add(new JTextArea("========Games========"));
		sellItemsText.add(new JTextArea("========Consoles========"));
				
		for (int i = 0; i < 3; i++)
			sellItemsText.get(i).setBackground(new Color(250, 250, 200));
		
		for(int i = 0; i < InvGame.size(); i++) {
			sellItemsText.get(1).append("\n" + (i + 1) + ")   " + InvGame.get(i).shortName + ", " + InvGame.get(i).console + "\tQuantity: " + InvGame.get(i).stock);
		}
		for(int i = 0; i < InvConsole.size(); i++) {
			sellItemsText.get(2).append("\n" + (i + 1) + ")   " + InvConsole.get(i).itemName + "\tQuantity: " + InvConsole.get(i).stock);
		}
		sellItemsText.get(0).setEditable(false);
		sellItemsText.get(1).setEditable(false);
		sellItemsText.get(2).setEditable(false);
		
		sellItemsText.add(new JTextArea("Game Index Number"));
		sellItemsText.add(new JTextArea("Quantity"));
		sellItemsText.add(new JTextArea("On Sale? (y or n)"));
		sellItemsText.add(new JTextArea("Console Index Number"));
		sellItemsText.add(new JTextArea("Quantity"));
		sellItemsText.add(new JTextArea("On Sale? (y or n)"));
		
		for(int i = 3; i < 7; i += 3) {
			sellItemsText.get(i).setBackground(new Color(220, 220, 220));
			sellItemsText.get(i + 1).setBackground(new Color(200, 200, 200));
			sellItemsText.get(i + 2).setBackground(new Color(220, 220, 220));
		}
		
		buttonSell = new JButton();
		buttonSell.setText("Sell Items");
		buttonSell.setBackground(new Color(150, 200, 150));
		buttonSell.addActionListener(this);
		
		jpSellItems = new ArrayList<JPanel>();
		spSellItems = new ArrayList<JSplitPane>();
		
		for(int i = 0; i < 9; i++) {
			jpSellItems.add(new JPanel(new GridLayout(1, 0)));
		}
		
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, sellItemsText.get(3), sellItemsText.get(4)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, jpSellItems.get(0), sellItemsText.get(5)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, sellItemsText.get(6), sellItemsText.get(7)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, jpSellItems.get(2), sellItemsText.get(8)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, sellItemsText.get(1), jpSellItems.get(1)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, sellItemsText.get(2), jpSellItems.get(3)));
			spSellItems.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpSellItems.get(4), jpSellItems.get(5)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, sellItemsText.get(0), jpSellItems.get(6)));
			spSellItems.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, jpSellItems.get(7), buttonSell));
		
		for(int i = 0; i < 9; i++) {
			jpSellItems.get(i).add(spSellItems.get(i));
		}
		
		sellFrame.add(jpSellItems.get(8));
		sellFrame.pack();
		sellFrame.setVisible(true);
	}
	
	/*
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
	*/

	
	
	public static void createCustomerGui() throws IOException {
		//Create and set up the window.
        JFrame frame = new JFrame("Print Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new head(true);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	public head(boolean b) throws IOException {
		InvGameFile = new File("/H:/My Stuff/Java/StoreProject/data/InvGame.txt");
		InvGameInput = new File("/H:/My Stuff/Java/StoreProject/data/InputGame.txt");
		InvConsoleFile = new File("/H:/My Stuff/Java/StoreProject/data/InvConsole.txt");
		InvConsoleInput = new File("/H:/My Stuff/Java/StoreProject/data/InputConsole.txt");
		Sales = new File("/H:/My Stuff/Java/StoreProject/data/Sales.txt");
		
		InvGame = new ArrayList<Game>();
		InvGame = ScanFile(InvGameFile, Sales, InvGame);
		InvGame = ScanFile(InvGameInput, Sales, InvGame);
		SaveFile(InvGameFile, InvGame);
		
		InvConsole = new ArrayList<Console>();
		InvConsole = ScanFileConsole(InvConsoleFile, Sales, InvConsole);
		InvConsole = ScanFileConsole(InvConsoleInput, Sales, InvConsole);
		SaveFileConsole(InvConsoleFile, InvConsole);
		
		labelCustomer = new JLabel ();
		labelCustomer.setOpaque(true);
		labelCustomer.setBackground(new Color(150, 200, 150));
		labelCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomer.setText("Store Shelf");
		
		textbox = new JTextArea();
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
		
		splitPaneCustomer = new JSplitPane(JSplitPane.VERTICAL_SPLIT, labelCustomer, textbox);
		customerPane = new JPanel(new GridLayout(1, 0));
		customerPane.add(splitPaneCustomer);
		
		add(customerPane);
	}

	public head() throws IOException {
		InvGameFile = new File("/H:/My Stuff/Java/StoreProject/data/InvGame.txt");
		InvGameInput = new File("/H:/My Stuff/Java/StoreProject/data/InputGame.txt");
		InvConsoleFile = new File("/H:/My Stuff/Java/StoreProject/data/InvConsole.txt");
		InvConsoleInput = new File("/H:/My Stuff/Java/StoreProject/data/InputConsole.txt");
		Sales = new File("/H:/My Stuff/Java/StoreProject/data/Sales.txt");
		
		InvGame = new ArrayList<Game>();
		InvGame = ScanFile(InvGameFile, Sales, InvGame);
		InvGame = ScanFile(InvGameInput, Sales, InvGame);
		SaveFile(InvGameFile, InvGame);
		
		InvConsole = new ArrayList<Console>();
		InvConsole = ScanFileConsole(InvConsoleFile, Sales, InvConsole);
		InvConsole = ScanFileConsole(InvConsoleInput, Sales, InvConsole);
		SaveFileConsole(InvConsoleFile, InvConsole);
		
		label = new JLabel ();
		label.setOpaque(true);
		label.setBackground(new Color(250, 250, 200));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Inventory Management");
		
		button = new JButton();
		button.setBackground(new Color(150, 150, 200));
		button.setText("Print Inventory");
		
		button2 = new JButton();
		button2.setBackground(new Color(150, 200, 200));
		button2.setText("Print Sales");
		
		button3 = new JButton();
		button3.setBackground(new Color(200, 150, 200));
		button3.setText("Sell Items");
		
		button4 = new JButton();
		button4.setBackground(new Color(130, 200, 170));
		button4.setText("Save");
		
		button5 = new JButton();
		button5.setBackground(new Color(200, 175, 150));
		button5.setText("Add Items");
		
		buttonRefresh = new JButton();
		buttonRefresh.setBackground(new Color(150, 150, 200));
		buttonRefresh.setText("Refresh Inventory");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		buttonRefresh.addActionListener(this);
		
		text = new JTextArea ();
		text.setOpaque(true);
		text.setBackground(new Color(150, 200, 150));
		text.append("Games");
		for(int i = 0; i < InvGame.size(); i++) {
			text.append("\n$" + InvGame.get(i).retailPrice + "        " + InvGame.get(i).shortName + "\tQuantity: " + InvGame.get(i).stock);
		}
		text.append("\n\nConsoles");
		for(int i = 0; i < InvConsole.size(); i++) {
			text.append("\n$" + InvConsole.get(i).retailPrice + "        " + InvConsole.get(i).shortName + "\tQuantity: " + InvConsole.get(i).stock);
		}
		text.setEditable(false);
		
		rightPane3 = new JPanel(new GridLayout(4, 1));
		rightPane3.add(button);
		rightPane3.add(button2);
		rightPane3.add(button3);
		rightPane3.add(button5);
		
		bottomPane = new JPanel(new GridLayout(1, 2));
		bottomPane.add(text);
		bottomPane.add(rightPane3);
				
		buttonsPane = new JPanel(new GridLayout(1, 2));
		buttonsPane.add(button4);
		buttonsPane.add(buttonRefresh);
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, label, bottomPane);
		topPane = new JPanel(new GridLayout(1,0));
		topPane.add(splitPane);
		
		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPane, buttonsPane);
			
		
		//setMenuPanel(menu);
		add(splitPane2);
	}
	
	public static void errorMessage(String message) {
		JFrame errorFrame = new JFrame("Error");
		
		JTextArea text = new JTextArea (message);
		text.setBackground(new Color (200, 150, 150));
		text.setEditable(false);
		
		errorFrame.add(text);
		errorFrame.pack();
		errorFrame.setVisible(true);
	}
	
	public static void infoMessage(String message) {
		JFrame errorFrame = new JFrame("Info");
		
		JTextArea text = new JTextArea (message);
		text.setBackground(new Color (150, 200, 150));
		text.setEditable(false);
		
		errorFrame.add(text);
		errorFrame.pack();
		errorFrame.setVisible(true);
	}
	
	
	
	private static void showEmployeeGUI() throws IOException {
        //Create and set up the window.
        frame = new JFrame("Inventory Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new head();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			printInventory();
		} else if (e.getSource().equals(button5)) {
			addItems();
		} else if (e.getSource().equals(button3)) {
			sellItems();
		} else if(e.getSource().equals(button2)) {
			try {
				printSales();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(button4)) {
			try {
				SaveFile(InvGameFile, InvGame);
				SaveFileConsole(InvConsoleFile, InvConsole);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonAdd)) {
			try {
				PrintWriter p = new PrintWriter(new FileWriter(InvGameInput, false));
				p.println(gameName.getText());
				p.println(gameConsole.getText());
				p.println(gameDeveloper.getText());
				p.println(gameGenre.getText());
				p.println(gameStoPri.getText());
				p.println(gameRetPri.getText());
				p.println(gameSalPri.getText());
				p.println(gameQuantity.getText());
				p.println("..");
				p.close();
				
				p = new PrintWriter(new FileWriter(InvConsoleInput, false));
				p.println(consName.getText());
				p.println(consDeveloper.getText());
				p.println(consType.getText());
				p.println(consStoPri.getText());
				p.println(consRetPri.getText());
				p.println(consSalPri.getText());
				p.println(consQuantity.getText());
				p.println("..");
				p.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			addFrame.dispose();
			
			try {
				SaveFile(InvGameFile, InvGame);
				SaveFileConsole(InvConsoleFile, InvConsole);
				frame.dispose();
				showEmployeeGUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonRefresh)){	
			try {
				SaveFile(InvGameFile, InvGame);
				SaveFileConsole(InvConsoleFile, InvConsole);
				frame.dispose();
				showEmployeeGUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonSell)) {
			try {
				if (Integer.parseInt(sellItemsText.get(3).getText()) <= InvGame.size() && Integer.parseInt(sellItemsText.get(3).getText()) > 0) {
					int index = Integer.parseInt(sellItemsText.get(3).getText()) - 1;
					if (Integer.parseInt(sellItemsText.get(4).getText()) <= InvGame.get(index).stock) {
						int quant = Integer.parseInt(sellItemsText.get(4).getText());
						if (sellItemsText.get(5).getText().equals("y")) {
							InvGame.get(index).sell(quant, true, new Date());
						} else if (sellItemsText.get(5).getText().equals("n")) {
							InvGame.get(index).sell(quant, false, new Date());
						} else {
							errorMessage("Sell Game: Please state whether the game is on sale or not by typing 'y' or 'n' in the appropriate box");
						}
					} else {
						errorMessage("Sell Game: There are not enough items in stock");
					}
				} else {
					errorMessage("Sell Game: An invalid index number was given.");
				}
			} catch (NumberFormatException e1) {
				errorMessage("Sell Game: A number was not provided in the appropriate box");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if (Integer.parseInt(sellItemsText.get(6).getText()) <= InvConsole.size()) {
					int index = Integer.parseInt(sellItemsText.get(6).getText()) - 1;
					if (Integer.parseInt(sellItemsText.get(7).getText()) <= InvConsole.get(index).stock) {
						int quant = Integer.parseInt(sellItemsText.get(7).getText());
						if (sellItemsText.get(8).getText().equals("y")) {
							InvConsole.get(index).sell(quant, true, new Date());
						} else if (sellItemsText.get(8).getText().equals("n")) {
							InvConsole.get(index).sell(quant, false, new Date());
						} else {
							errorMessage("Sell Console: Please type 'y' or 'n'");
						}
					} else {
						errorMessage("Sell Console: There are not enough items in stock");
					}
				} else {
					errorMessage("Sell Console: An invalid index number was given.");
				}
			} catch (NumberFormatException e1) {
				errorMessage("Sell Console: A number was not provided in the appropriate box");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			sellFrame.dispose();
			
			try {
				SaveFile(InvGameFile, InvGame);
				SaveFileConsole(InvConsoleFile, InvConsole);
				frame.dispose();
				showEmployeeGUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}