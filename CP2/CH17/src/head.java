import java.io.*;
import java.util.*;

public class head {
	public static void main(String args[]) {
		/*
		int ary[] = new int[] {1,3,5,7,9,11,13,15};
		
		for(int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
		}
		*/
		
		/*
		String m = "Good morning, how may I help you? I289 56";
		Scanner sc = new Scanner(m);
		System.out.println(sc.next( ));
		
		sc.skip("\\s*mo");
		String s = sc.next( );
		System.out.println(s);

		sc.useDelimiter("\\s+I");
		System.out.println(sc.next( ));



		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter something like 8 + 33 + 1,345 + 137 : ");
		s = kb.nextLine( );
		String s2 = "";
		sc = new Scanner(s);
		
		if (s.substring(0, 1).equals("-")) {
			s2 += "-";
		}
		
		sc.useDelimiter("\\s*\\-\\s*");
		s2 += sc.next();
		while(sc.hasNext()) {
			s2 += " + -" + sc.next();
		}
		System.out.println(s2);
		sc.close();
		
		sc = new Scanner(s2);
		
		sc.useDelimiter("\\s*\\+\\s*");
		
		int sum = 0;
		
		while(sc.hasNextInt( ))	{
			sum = sum + sc.nextInt( );
		}
		
		System.out.println("Sum is: " + sum + "\n\n");
		*/
		
		
		Scanner kbReader = new Scanner(System.in);
		System.out.print("Enter a sentence that is to be encrypted: ");
		String sntnc = kbReader.nextLine( );
		System.out.println("Original sentence = " + sntnc);
		
		Crypto myCryptObj = new Crypto( );
		String encryptdSntnc = myCryptObj.encrypt2(sntnc, 2038482);
		System.out.println("Encrypted sentence = " + encryptdSntnc);
		
		String decryptdSntnc = myCryptObj.decrypt2(encryptdSntnc, 2038482);
		System.out.println("Decrypted sentence = " + decryptdSntnc);
	}
}