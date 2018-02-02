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
		File Inv = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.1/src/testing.txt");
		File Sales = new File("/H:/My Stuff/Java/StoreProject/StoreCP2_v0.1/src/Sales.txt");
		
		FileWriter f = new FileWriter(Sales);
		PrintWriter p = new PrintWriter(f);
		p.println("\t\t=====Sales=====");
		p.close();
		
		Game[] Inventory = ScanFile(Inv, Sales);

		printInventory(Inventory);
		
		Inventory[0].sell(10, false, new Date());
		Inventory[0].sell(10, true, new Date());
		Inventory[0].sell(10, true, new Date());
		System.out.println("\n");
		
		printInventory(Inventory);		
	}
	
	public static void printInventory (Game[] inv) {
		for(int i = 0; i < inv.length; i++){
			Game g = inv[i];
			System.out.println(g.itemName + ", a " + g.genre + " game by " + g.publisher + " for " + g.console);
			if (g.stock <= 0)
				System.out.println("    NOT IN STOCK"); 
			System.out.println("    Price: $" + inv[i].retailPrice);
		}
	}
	
	public static boolean SaveFile(File f) {
		return true;
	}
	
 	public static Game[] ScanFile(File f, File Sales) throws FileNotFoundException {
		int length = 0;
		int sections = 0;
		
		Scanner s = new Scanner(f);
		while (s.hasNextLine()){
			length += 1;
			if(s.nextLine().equals("..")) sections++;
		}
		s.close();
		
		Game[] inv = new Game[sections];
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
			
			inv[i] = new Game(objName, objCon, objPub, objGen, objSto, objRet, objSale, objStock, Sales);
		}
		s.close();
		
		return(inv);
	}

}