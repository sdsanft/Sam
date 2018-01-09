import java.util.Scanner;
public class head {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		
		System.out.println("Please type in one of the following options:");
		System.out.println("Add");
		System.out.println("Subtract");
		System.out.println("Multiply");
		System.out.println("Divide");
		String calc = s.nextLine();
		
		switch (calc) {
		case("Add"):
		case("add"):
		case("Subtract"):
		case("subtract"):
		case("Multiply"):
		case("multiply"):
		case("Divide"):
		case("divide"):
			break;
		default:
			System.out.println("You didn't enter a valid command.");
			return;
		}
		
		double op1;
		double op2;
		System.out.println("\nPlease enter two numbers: ");
		if (s.hasNextDouble()) op1 = s.nextDouble();
		else {
			System.out.println("You didn't enter a valid number.");
			return;
		}
		if (s.hasNextDouble()) op2 = s.nextDouble();
		else {
			System.out.println("You didn't enter a valid number.");
			return;
		}
		
		switch (calc) {
		case("Add"):
		case("add"):
			System.out.println(op1 + " + " + op2 + " = " + (op1+op2));
			break;
		case("Subtract"):
		case("subtract"):
			System.out.println(op1 + " - " + op2 + " = " + (op1-op2));
			break;
		case("Multiply"):
		case("multiply"):
			System.out.println(op1 + " * " + op2 + " = " + (op1*op2));
			break;
		case("Divide"):
		case("divide"):
			System.out.println(op1 + " / " + op2 + " = " + (op1/op2));
			break;
		}
		s.close();
	}

}
