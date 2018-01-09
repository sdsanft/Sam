import java.util.Scanner;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i;
		
		System.out.print("Please enter an Integer: ");
		if(s.hasNextInt()) {
			i = s.nextInt();
			if (i % 2 == 0) System.out.println("Your integer is even.");
			else System.out.println("Your integer is odd.");
		} else System.out.println("You did not enter an integer.");
		s.close();
	}
}
